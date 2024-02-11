package com.bsak.Generator;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee extends Person {

    LocalDate employmentStartDate;
    String currentPosition;
    BigDecimal currentSalary;

    public Employee(String pesel) {
        super("EMPLOYEE", "Karolina", "Mysz", pesel, 165, 55.6, generateUniqueEmail());
        this.employmentStartDate = LocalDate.parse("2022-10-10");
        this.currentPosition = "Magazynier";
        this.currentSalary = new BigDecimal("4500");
    }

    @Override
    public String toString() {
        return super.toString() + "," + employmentStartDate + "," + currentPosition + "," + currentSalary + ",,,,,,";
    }

    private static String generateUniqueEmail() {
        return "karolina.k" + emailCounter++ + "@example.com";
    }
}
