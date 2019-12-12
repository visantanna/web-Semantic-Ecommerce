package com.example.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.business.CartBusiness;
import com.example.demo.dto.Product;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/cart")
public class CartController {
	@Autowired
	private CartBusiness cartBussiness;
	
	@GetMapping
	public ModelAndView CartPage(){
		ModelAndView view  = new ModelAndView("cart");
		return view;
	}
}
