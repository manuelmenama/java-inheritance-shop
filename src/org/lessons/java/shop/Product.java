package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class Product {
    //ATTRIBUTI
    private int code;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal vat;

    private final static BigDecimal premiumDiscount = BigDecimal.valueOf(0.02);



    //COSTRUTTORI
    public Product() {
        code = getRandomCode();
    }

    public Product(String name, String description, BigDecimal price, BigDecimal vat) {
        this.code = getRandomCode();
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
    }

    //GETTER E SETTER


    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    //METODI
    private int getRandomCode() {
        Random random = new Random();
        return random.nextInt(1, 10000);
    }

    public BigDecimal priceWithVat() {
        BigDecimal vatPrice = price.multiply(vat);
        return price.add(vatPrice).setScale(2, RoundingMode.HALF_EVEN);
    }

    private String getFormattedCode() {
        DecimalFormat decimalFormat = new DecimalFormat("00000000");
        return decimalFormat.format(code);
    }

    public String getExtendedName() {
        return getFormattedCode() + "-" + name;
    }

    public BigDecimal discountedPrice() {
        BigDecimal discountValue = priceWithVat().multiply(baseDiscount());
        return priceWithVat().subtract(discountValue).setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal baseDiscount() {
        return BigDecimal.valueOf(0.02);
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + getFormattedCode() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price.setScale(2, RoundingMode.HALF_EVEN) +
                ", price+vat=" + priceWithVat() +
                '}';
    }
}
