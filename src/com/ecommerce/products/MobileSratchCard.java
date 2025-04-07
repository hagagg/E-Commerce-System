package com.ecommerce.products;

import com.ecommerce.interfaces.Expirable;

import java.time.LocalDate;

public class MobileSratchCard extends Product implements Expirable {

    private LocalDate expiryDate;

    public MobileSratchCard(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
