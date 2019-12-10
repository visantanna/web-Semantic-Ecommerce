package com.example.demo.dto;

public class Store {
	
	private String id;
	private String type;
	private String name;
	private String description;
	private String store_photo;
	private String location;
	
	public Store(String id, String type, String name, String description, String store_photo, String location) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.store_photo = store_photo;
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getStore_photo() {
		return store_photo;
	}
	public void setStore_photo(String store_photo) {
		this.store_photo = store_photo;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

}
