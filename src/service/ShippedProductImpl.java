package servuces;

import java.util.List;

import entity.Products;

public class ShippedProductImpl implements ShippingService{

	@Override
	public void PrintBill(List<Products> shippProducts) {
		
		Double weight = 0.0;
		System.out.println(" ** Shipment notice ** ");
		for(Products product: shippProducts) {
			weight += product.getWeight()*product.getQuantity();

			System.out.println(product.getQuantity()+"x  "+ product.getName()+"      "+
					product.getWeight()*product.getQuantity()+"g");
		}
		
		System.out.println("Total package weight "+ weight +"g");
	}

}
