package com.ecommerce.customer;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name , double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void reduceBalance (double amount) {
        balance -= amount;
    }


}
