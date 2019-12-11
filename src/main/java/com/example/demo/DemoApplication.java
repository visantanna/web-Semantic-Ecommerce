package com.example.demo;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		loadOwl();
		SpringApplication.run(DemoApplication.class, args);
		
	}
	
	private static void loadOwl() {
		String path = "src/main/resources/EP_WS_RDFXML.owl" ;
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		model.read(path);
		model.write(System.out);
	}

}
