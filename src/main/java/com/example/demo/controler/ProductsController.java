package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.business.ProductsBusiness;
import com.example.demo.business.StoreBusiness;
import com.example.demo.dto.Product;
import com.example.demo.dto.Store;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/product")
public class ProductsController {
	@Autowired
	private ProductsBusiness productBusiness;
	
	@PostMapping
    public Product createNewProduct(@RequestBody  Product product){
           return productBusiness.createNewProduct(product);
    }
    @GetMapping
    public ModelAndView productsPage(){
    	ModelAndView view  = new ModelAndView("products");
        return view;
    }
    @GetMapping(value = "list")
    public List<Product> listProductsFromStore(@RequestParam(value = "id", required = true)  String id){
    	List<Product> productsList = productBusiness.listProductsFromStore(id);
    	return productsList;
    }
}
