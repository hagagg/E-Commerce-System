package com.ecommerce.shipping;

import com.ecommerce.cart.CartItem;
import com.ecommerce.interfaces.Shippable;
import com.ecommerce.products.Product;

import java.util.List;

public class ShippingService {

    public static void sendItems (List<CartItem> items){

        System.out.println("** Shipment Notice **");

        double totalWeight = 0;

        for (CartItem item : items){
            Product product = item.getProduct();

            if (product instanceof Shippable){

            System.out.print(item.getQuantity() + "x " + product.getName() );
            System.out.print("  :  ");
            System.out.println(item.getQuantity() *  ((Shippable) product).getWeight() + "g");
            totalWeight += ((Shippable) product).getWeight();
            }
        }
        System.out.println("Total Package Weight: " + totalWeight /1000 + "kg");
    }



}
