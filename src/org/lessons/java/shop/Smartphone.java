package org.lessons.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Product {

    //ATTRIBUTI
    private int imei;
    private int memory;

    //COSTRUTTORI
    public Smartphone(String name, String description, BigDecimal price, BigDecimal vat, int imei, int memory) {
        super(name, description, price, vat);
        this.imei = imei;
        this.memory = memory;
    }

    //GETTER E SETTER

    public int getImei() {
        return imei;
    }

    public void setImei(int imei) {
        this.imei = imei;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    //METODI

    @Override
    public String toString() {
        return "Name: " + getName() + "; Price+vat: " + priceWithVat() +
                "; imei: " + imei + "; memory: " + memory;
    }
}
