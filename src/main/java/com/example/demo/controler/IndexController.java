package com.example.demo.controler;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("")
public class IndexController {
	@GetMapping
    public ModelAndView productsPage(){
    	ModelAndView view  = new ModelAndView("index");
        return view;
    }
}
