package org.lessons.java.shop;

import java.math.BigDecimal;

public class Chart {
    public static void main(String[] args) {

        Smartphone smartphone = new Smartphone("telefonetto", "non hai ancora il telefonetto?", new BigDecimal(200.30), new BigDecimal(0.22), 13344411, 256);

        System.out.println(smartphone.toString());

    }
}
