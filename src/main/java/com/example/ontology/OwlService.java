package com.example.ontology;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;

public class OwlService {
	
	public static void loadOwl() {
		String path = "src/main/resources/EP_WS_RDFXML.owl" ;
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		model.read(path);
		model.write(System.out);
	}
	
	public static OntModel getOwlModel() {
		String path = "src/main/resources/EP_WS_RDFXML.owl" ;
		OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
		model.read(path);
		return model;
	}
	
}
