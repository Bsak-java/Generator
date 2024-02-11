package com.bsak.Generator;

import java.math.BigDecimal;

public class Student extends Person {

    String universityName;
    int studyYear;
    String studyField;
    BigDecimal scholarshipAmount;

    public Student(String pesel) {
        super("STUDENT", "Tomek", "Koral", pesel, 192, 100.0, generateUniqueEmail());
        this.universityName = "MIT";
        this.studyYear = 4;
        this.studyField = "Biological Engineering";
        this.scholarshipAmount = new BigDecimal("1400");
    }

    @Override
    public String toString() {
        return super.toString() + ",,,,,," + universityName + "," + studyYear + "," + studyField + "," + scholarshipAmount;
    }

    private static String generateUniqueEmail() {
        return "tomek.k" + emailCounter++ + "@example.com";
    }
}
