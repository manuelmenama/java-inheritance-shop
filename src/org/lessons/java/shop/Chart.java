package org.lessons.java.shop;

import java.math.BigDecimal;

public class Chart {
    public static void main(String[] args) {
        /*Product product1 = new Product();

        System.out.println(product1.toString());*/

        Product product2 = new Product("samsung a52s", "Buono telefono, compra!", new BigDecimal(299.99), new BigDecimal(0.22));
        System.out.println(product2.toString());
    }
}
