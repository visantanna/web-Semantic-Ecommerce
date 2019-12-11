package com.example.demo.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;
@Service
public class CartBusiness {
	
	ArrayList<Product> cartList = new ArrayList<Product>();
	
	public List<Product> listAllSales(){
		return cartList;
	}
	public void addProductToList(Product product) {
		cartList.add(product);
	}
}
