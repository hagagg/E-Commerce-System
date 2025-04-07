package com.ecommerce.cart;

import com.ecommerce.customer.Customer;
import com.ecommerce.shipping.ShippingService;
import com.ecommerce.interfaces.Expirable;
import com.ecommerce.interfaces.Shippable;
import com.ecommerce.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List <CartItem> itemsList = new ArrayList<>();

    public  void addProduct (Product product , int quantity) throws Exception{
        if ( quantity > product.getQuantity()) {
            throw new Exception("There isn't enough quantity for this product");
        }
        itemsList.add (new CartItem(product, quantity));
    }

    public List<CartItem> getItemsList() {
        return itemsList;
    }

    public boolean isEmpty (){
        return itemsList.isEmpty();
    }

    public double getSubTotal () {
        double subTotal = 0;
        for (CartItem cartItem : itemsList) {
            subTotal += cartItem.getTotalPrice();
        }
        return subTotal;
    }

    public void checkout(Customer customer) throws Exception{
        double subTotal = getSubTotal();
        double shippingFees = 0;
        double totalWeight = 0 ;
        List <Shippable> shippableList = new ArrayList<>();

        for (CartItem cartItem : itemsList ) {
            Product pro = cartItem.getProduct();

            if (pro.getQuantity() < cartItem.getQuantity()) {
                throw new Exception("There isn't enough quantity for :" + pro.getName());
            }

            if (pro instanceof Expirable && pro.isExpired()) {
                throw new Exception(pro.getName() + "is expired");
            }

            if (pro instanceof Shippable) {
                for ( int i = 0 ; i < cartItem.getQuantity() ; i++ ) {
                    shippableList.add ((Shippable) pro);
                    shippingFees += 10;
                    totalWeight += ((Shippable) pro).getWeight();

                }
            }
        }

        double totalPrice = subTotal + shippingFees ;

        if (customer.getBalance() < totalPrice) {
            throw new Exception("You have not enough balance");
        }

        for (CartItem cartItem : itemsList) {
            cartItem.getProduct().reduceQuantity(cartItem.getQuantity());
        }
        customer.reduceBalance(totalPrice);


        System.out.println("** Checkout Receipt  **");
        for (CartItem cartItem : itemsList) {
            System.out.print(cartItem.getQuantity() + "x " + cartItem.getProduct().getName());
            System.out.print("  :  ");
            System.out.println(cartItem.getTotalPrice());
        }

        double amount = subTotal + shippingFees;

        System.out.println(" ------------------ ");
        System.out.println("subTotal       " + subTotal);
        System.out.println("shipping       " + shippingFees);
        System.out.println("amount         " + amount);

        System.out.println(" ------------------ ");

        ShippingService.sendItems(itemsList);


    }




}
