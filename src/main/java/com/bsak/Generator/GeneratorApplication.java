package com.bsak.Generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootApplication
public class GeneratorApplication {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        SpringApplication.run(GeneratorApplication.class, args);

        Set<String> generatedPesel = new HashSet<>();
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 50000; i += 3) {
            String pesel = generatePesel(generatedPesel);
            people.add(new Employee(pesel));
            pesel = generatePesel(generatedPesel);
            people.add(new Student(pesel));
            pesel = generatePesel(generatedPesel);
            people.add(new Pensioner(pesel));
        }


        Collections.shuffle(people);

        for (Person person : people) {
            writeToCsv(person.toString() + "\n");
        }


        System.out.println("Zakonoczno!");
    }

    private static String generatePesel(Set<String> generatedPesel) {
        String pesel;
        do {
            pesel = generateRandomPesel();
        } while (generatedPesel.contains(pesel));

        generatedPesel.add(pesel);
        return pesel;
    }

    private static String generateRandomPesel() {
        Random random = new Random();
        StringBuilder pesel = new StringBuilder("");

        do {
            pesel.append(random.nextInt(10));
        } while (pesel.length() < 11);

        return pesel.toString();
    }

    private static void writeToCsv(String content) {
        lock.lock();
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("people50k.csv", true))) {
                writer.write(content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } finally {
            lock.unlock();
        }
    }
}
