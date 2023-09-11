package com.ecommerce;

public class Products {

	
	
		private int productId;
		private String name;
		private String description;
		private double price;
		private int quantity;
		
		
//		public Products(int productId, String name, String description, double price, int quantity) {
//		
//			this.productId = productId;
//			this.name = name;
//			this.description = description;
//			this.price = price;
//			this.quantity = quantity;
//		}


		public int getProductId() {
			return productId;
		}


		public void setProductId(int productId) {
			this.productId = productId;
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
			return "Products [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
					+ price + ", quantity=" + quantity + "]";
		}
		
		
		
	
}
