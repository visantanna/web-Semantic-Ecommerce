package com.example.demo.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Product;


@Service
public class ProductsBusiness {
	//Product tenisNike = new Product("593c1e3e-1a5311ea978f2e728ce88125",177.90, "Nike SB50" , "c3f6f6ae1a4411ea978f2e728ce88125", "Nike","https://c.static-nike.com/a/images/t_prod_ss/w_960,c_limit,f_auto/uawxvnh1undj94govvic/sb50-nike-free-trainer-30-v4-metallic-gold.jpg" );
	ArrayList<Product> listProducts = new ArrayList<Product>();
	
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
