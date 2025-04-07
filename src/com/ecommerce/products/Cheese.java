package com.ecommerce.products;

import com.ecommerce.interfaces.Expirable;
import com.ecommerce.interfaces.Shippable;

import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable {

    private double weight;
    LocalDate expiryDate;

    public Cheese(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired(){
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
