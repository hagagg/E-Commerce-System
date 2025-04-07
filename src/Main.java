import com.ecommerce.cart.Cart;
import com.ecommerce.customer.Customer;
import com.ecommerce.products.Cheese;
import com.ecommerce.products.MobileSratchCard;
import com.ecommerce.products.TV;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        try {
            TV tv = new TV("TV", 1000, 10, 2000);
            Cheese cheese = new Cheese("Cheese", 200, 6, LocalDate.of(2025, 6, 1), 100);
            MobileSratchCard sraCard = new MobileSratchCard("Mobile Scratch Card", 50, 10, LocalDate.of(2025, 4, 30));


            Cart cart = new Cart();
            cart.addProduct(tv , 2);
            cart.addProduct(cheese , 5);
            cart.addProduct(sraCard, 2);



            Customer customer = new Customer("Ahmed Hagag" , 10000);

            cart.checkout(customer);


        } catch (Exception ex){
            System.out.println("Exception: " + ex.getMessage());
        }

    }
}
