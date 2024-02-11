package com.bsak.Generator;

import java.math.BigDecimal;

public class Pensioner extends Person {

    BigDecimal pensionAmount;
    int yearsOfWork;

    public Pensioner(String pesel) {
        super("PENSIONER", "Karol", "Nowak", pesel, 180, 75.5, generateUniqueEmail());
        this.pensionAmount = new BigDecimal("3850");
        this.yearsOfWork = 55;
    }

    @Override
    public String toString() {
        return super.toString() + ",,,," + pensionAmount + "," + yearsOfWork + ",,,,,";
    }

    private static String generateUniqueEmail() {
        return "karol.k" + emailCounter++ + "@example.com";
    }
}
