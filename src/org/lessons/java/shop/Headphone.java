package org.lessons.java.shop;

import java.math.BigDecimal;

public class Headphone extends Product{
    //ATTRIBUTI
    private String color;
    private boolean isWireless;

    //COSTRUTTORI

    public Headphone(String name, String description, BigDecimal price, BigDecimal vat, String color, boolean isWireless) {
        super(name, description, price, vat);
        this.color = color;
        this.isWireless = isWireless;
    }


    //GETTER E SETTER
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    //METODI
    @Override
    public String toString() {
        return "Name: " + getName() + "; Price+vat: " + priceWithVat() +
                "; color: " + color + "; senza filo: " + isWireless;
    }
}
