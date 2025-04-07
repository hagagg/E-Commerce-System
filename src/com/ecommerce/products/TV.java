package com.ecommerce.products;

import com.ecommerce.interfaces.Expirable;
import com.ecommerce.interfaces.Shippable;

public class TV extends Product implements Expirable, Shippable {

    private double weight;

    public TV (String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
