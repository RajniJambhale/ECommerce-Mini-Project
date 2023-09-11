package com.ecommerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BuyProduct 
{

	private int ProductId;
	private String name;
	private String description;
	private double price;
	private int quantity;
	
	public BuyProduct(int productId, String name, String description, double price, int quantity) {
		
		ProductId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public int getProductId() {
		return ProductId;
	}

	public void setProductId(int productId) {
		ProductId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BuyProduct [ProductId=" + ProductId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	
		
	
	
}
