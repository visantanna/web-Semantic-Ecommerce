package com.example.demo.dto;

public class Product {
	
	private String id;
	private double price;
	private String name;
	private String idStore;
	private String brand;
	private String productPhoto;
	
	
	public Product(String id, double price, String name, String idStore, String brand, String productPhoto) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.idStore = idStore;
		this.brand = brand;
		this.productPhoto = productPhoto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdStore() {
		return idStore;
	}
	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getProductPhoto() {
		return productPhoto;
	}
	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}
}
