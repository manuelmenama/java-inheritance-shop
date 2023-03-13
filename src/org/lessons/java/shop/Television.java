package org.lessons.java.shop;

import java.math.BigDecimal;

public class Television extends Product {

    //ATTRIBUTI
    private int inches;
    private boolean isSmart;

    //COSTRUTTORI
    public Television(String name, String description, BigDecimal price, BigDecimal vat, int inches, boolean isSmart) {
        super(name, description, price, vat);
        this.inches = inches;
        this.isSmart = isSmart;
    }

    //GETTER E SETTER

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    //METODI
    @Override
    public String toString() {
        return "Name: " + getName() + "; Price+vat: " + priceWithVat() +
                "; smart-tv: " + isSmart + "; pollici: " + inches;
    }
}
