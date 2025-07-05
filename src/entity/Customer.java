package entity;

import java.util.List;

public class Customer {


    private Double balance;

	private List<Products> products;

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProductsList(List<Products> products) {
		this.products = products;
	}
}
