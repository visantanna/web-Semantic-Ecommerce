package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ontology.SparqlService;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		loadOwl();
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	private static void loadOwl() {
		SparqlService.selectUsers();
		
	}

}
