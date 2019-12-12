package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;
import com.example.ontology.SparqlService;


@Service
public class ProductsBusiness {
	
	ArrayList<Product> listProducts = SparqlService.loadProduct();
	
	public Product createNewProduct(Product product) {
		product.setId( UUID.randomUUID().toString());
		listProducts.add(product);
		return product;
	}
	public List<Product> listProductsFromStore(String id){
		List<Product> responseList = (ArrayList<Product>) listProducts.stream().filter(prod-> prod.getIdStore().equals(id)).collect(Collectors.toList());
		return responseList;
	}

}
