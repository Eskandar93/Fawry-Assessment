import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.Cart;
import entity.Customer;
import entity.Products;
import enums.ProductType;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, Fawry Assessment !");

        final List<Products> baseProducts = new ArrayList<>();

        Products baseP1 = new Products("Cheese", 100.0, ProductType.CHEESE, 50L, 20.0, LocalDate.of(2028, 12, 30), 20.0);
        Products baseP2 = new Products("TV", 200.0, ProductType.TV, 50L, 20.0, null, 30.0);
        Products baseP3 = new Products("Mobile", 200.0, ProductType.MOBILE, 40L, 10.0, null, 5.0);
        Products baseP4 = new Products("Card Mobile", 30.0, ProductType.MobileScratchCards, 40L, 0.0, null, 0.0);
        
        baseProducts.addAll(Arrays.asList(baseP1, baseP2, baseP3, baseP4));

        ///////////////////////////////////

        Products p = new Products("Cheese", 1L);
        Products p2 = new Products("Mobile", 2L);

        Customer customer = new Customer();
        customer.setBalance(1000.0);
        customer.setProductsList(Arrays.asList(p, p2));

        
        Cart cart = new Cart(baseProducts);
      
        cart.addProductToCart(p.getName(), 1L);
        cart.addProductToCart(p2.getName(), 2L);
        
        cart.Checkout(customer, cart);
    
        
    }
    
}