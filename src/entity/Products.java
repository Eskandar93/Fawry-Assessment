package entity;

import java.time.LocalDate;

import enums.ProductType;

public class Products {

    private Long id;

    private String name;

    private Long quantity;
    
    private Double price;
    
    private ProductType type;

    private LocalDate expier;

    private Double shipp;
    
    private Double weight;


    public Products(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    
    public Products(String name, Long quantity, Double weight) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public Products(String name, Double price,  ProductType type,  Long quantity, Double shipp, LocalDate expier, Double weight) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.shipp = shipp;
        this.expier = expier;
        this.weight = weight;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {

        return name;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

    public LocalDate getExpier() {
        return expier;
    }

    public void setExpier(LocalDate expier) {
        this.expier = expier;
    }

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getShipp() {
		return shipp;
	}

	public void setShip(Double shipp) {
		this.shipp = shipp;
	}
    
	
    
}
