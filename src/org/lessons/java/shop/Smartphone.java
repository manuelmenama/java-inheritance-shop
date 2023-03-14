package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public BigDecimal discountedPrice() {
        if (memory < 32){
            BigDecimal discountValue = priceWithVat().multiply(BigDecimal.valueOf(0.05));
            return priceWithVat().subtract(discountValue).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            return super.discountedPrice();
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "; Price+vat: " + priceWithVat() +
                "; Prezzo scontato: " + discountedPrice() +
                "; imei: " + imei + "; memory: " + memory;
    }
}
