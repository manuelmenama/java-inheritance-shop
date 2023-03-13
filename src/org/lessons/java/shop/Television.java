package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
    public BigDecimal discountedPrice() {
        if (!isSmart){
            BigDecimal discountValue = getPrice().multiply(BigDecimal.valueOf(0.1));
            return getPrice().subtract(discountValue).setScale(2, RoundingMode.HALF_EVEN);
        } else {
            return super.discountedPrice();
        }
    }
    @Override
    public String toString() {
        return "Name: " + getName() + "; Price+vat: " + priceWithVat() +
                "; Prezzo scontato: " + discountedPrice() +
                "; smart-tv: " + isSmart + "; pollici: " + inches;
    }
}
