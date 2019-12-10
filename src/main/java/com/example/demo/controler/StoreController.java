package com.example.demo.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.business.StoreBusiness;
import com.example.demo.dto.Store;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/stores")
public class StoreController {
	@Autowired
	private StoreBusiness storeBusiness;
	
	@PostMapping
    public Store createProfissional(@RequestBody  Store store){
           return storeBusiness.createNewStore(store);
    }
	
    @GetMapping
    public List<Store> listStores(){
        return storeBusiness.listStores();
    }
}
