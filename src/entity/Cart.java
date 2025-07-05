package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import servuces.ShippedProductImpl;
import servuces.ShippingService;

public class Cart {

    List<Products> products = new ArrayList<>();
	List<Products> baseProducts;
   
	public Cart(List<Products> baseProducts) {
		super();
		this.baseProducts = baseProducts;
	}


	public List<Products> getProducts() {
		return products;
	}


	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Boolean quantityProductIsEnough(Products product, Long quantity){
		
		return product.getQuantity() >= quantity;
		
	}

    public void addProductToCart(String name, Long quantity) {
    	  
    	for(Products product: baseProducts) {
    		if(product.getName().equals(name)) {

    			Boolean flag = true;
    			
    			if(product.getExpier() != null) {
	    			if (product.getExpier().isBefore(LocalDate.now())) {
	    				flag = false;
	    			    System.out.println("this item is already expired date");
	    			    continue;
	    			}
    			}
    			
    			if(flag) {
	    			 if(quantityProductIsEnough(product, quantity)) {
						product.setQuantity(product.getQuantity() - quantity);
						Products pc = new Products(name, quantity);
    					products.add(pc);
	    			}
	    			else System.out.println("Not there are enough product");
    			}

    		}
    	}
    }
   
    ////////////////////////////////////////
    
    public double getPriceOfProduct(Products product){
    	
    	for(Products pro: baseProducts) {
    		 if(pro.getName().equals(product.getName())) {
    			 return pro.getPrice();
    		 }
    	}
    	return 0.0;
    }
    
  public Products isShippedProduct(Products product){
    	
    	for(Products pro: baseProducts) {
    		 if(pro.getName().equals(product.getName()) && pro.getShipp() != 0.0) {
    			 return pro;
    		 }
    	}
    	return null;
    }
    
    public void Checkout(Customer customer, Cart cart) {
        System.out.println("Total detials");
        Boolean flag = false;
        
        double Subtotal = 0.0, Shipping = 0.0, Amount = 0.0;
        List<Products> shippedProducts = new ArrayList<>();
        
        for(Products product: cart.getProducts()){
        	
        	Double price = getPriceOfProduct(product)*product.getQuantity();
        	Subtotal += price;
        	
        	Products shipped = isShippedProduct(product);
        	
        	if(shipped != null) {
        		shipped.setQuantity(product.getQuantity());
        		Shipping += shipped.getShipp();
        		shippedProducts.add(shipped);
        	}
        	
        	if(!flag) {
        		System.out.println(" ** Checkout receipt ** ");
        		flag = true;
        	}
    		System.out.println(product.getQuantity()+"x  "+ 
    					product.getName()+"      "+
    					price);
        }
        
        Amount = Subtotal+Shipping;
        
        if(customer.getBalance() < Amount) {
        	
        	System.out.println("Your Balance Not Enough");
        	return ;
        }
        
        customer.setBalance(customer.getBalance()-Amount);
        
        ShippingService shipPro = new ShippedProductImpl();
        shipPro.PrintBill(shippedProducts);
				        
        System.out.println("Subtotal "+Subtotal+ "\n"
        					+"Shipping "+Shipping+ "\n" 
        					+ "Amount: " + Amount);
    }
    

}
