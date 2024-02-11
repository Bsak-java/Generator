package com.bsak.Generator;

public class Person {

    protected static int emailCounter = 1;
    String type;
    String name;
    String surname;
    String pesel;
    int height;
    double weight;
    String email;

    public Person(String type, String name, String surname, String pesel, int height, double weight, String email) {
        this.type = type;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.height = height;
        this.weight = weight;
        this.email = email;
    }

    @Override
    public String toString() {
        return type + "," + name + "," + surname + "," + pesel + "," + height + "," + weight + "," + email;
    }
}
