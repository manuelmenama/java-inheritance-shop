package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public BigDecimal discountedPrice() {
        if (!isWireless){
            BigDecimal discountValue = priceWithVat().multiply(BigDecimal.valueOf(0.07));
            return priceWithVat().subtract(discountValue).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            return super.discountedPrice();
        }
    }
    @Override
    public String toString() {
        return "Name: " + getName() + "; Price+vat: " + priceWithVat() +
                "; Prezzo scontato: " + discountedPrice() +
                "; color: " + color + "; senza filo: " + isWireless;
    }
}
