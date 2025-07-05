package servuces;

import java.util.List;

import entity.Products;

public interface ShippingService {

	public void PrintBill(List<Products> shippProducts);
}
