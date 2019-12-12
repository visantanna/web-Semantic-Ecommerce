package com.example.ontology;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.demo.controler.StoreController;
import com.example.demo.dto.Store;

public class SparqlService {
	static private  OntModel model = OwlService.getOwlModel();
	
	private static String queryUser() {
		return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" + 
				"PREFIX foaf:  <http://xmlns.com/foaf/0.1#>\n" + 
				"PREFIX ep:  <http://www.semanticweb.org/ACH2098/>\n" + 
				"PREFIX eps:  <http://www.semanticweb.org/ACH2098>\n" + 
				"PREFIX epsx:  <http://www.semanticweb.org/ACH2098#>\n" + 
				"PREFIX epx:  <http://www.semanticweb.org/ACH2098/#>\n" + 
				"\n" + 
				"SELECT   ?ind ?name ?id ?on ?login ?pass ?birth ?gen    \n" + 
				"{\n" + 
				"?ind rdf:type epx:User;\n" + 
				"ep:userName ?name;\n" + 
				"ep:userID ?id;\n" + 
				"epsx:loggedIn ?on;\n" + 
				"epsx:userLogin ?login;\n" + 
				"ep:password ?pass;\n" + 
				"ep:dateOfBirth ?birth;\n" + 
				"ep:gender ?gen\n" + 
				"}\n" + 
				"ORDER BY ASC(?ind)";
	}
	
	private static String queryStore() {
		return "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
				"PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" + 
				"PREFIX foaf:  <http://xmlns.com/foaf/0.1#>\n" + 
				"PREFIX ep:  <http://www.semanticweb.org/ACH2098/>\n" + 
				"PREFIX epsx:  <http://www.semanticweb.org/ACH2098#>\n" + 
				"PREFIX epx:  <http://www.semanticweb.org/ACH2098/#>\n" + 
				"\n" + 
				"SELECT   ?store ?activity ?isLocatedIn ?offers ?represents ?storeLink ?storePhoto ?storeID ?storeName\n" + 
				"{\n" + 
				"?store rdf:type epx:Store;\n" + 
				"epsx:activity ?activity;\n" + 
				"ep:isLocatedIn ?isLocatedIn;\n" + 
				"ep:offers ?offers;\n" + 
				"ep:represents ?represents;\n" + 
				"epsx:storeLink ?storeLink;\n" + 
				"epsx:storePhoto ?storePhoto;\n" + 
				"ep:storeID ?storeID;\n" + 
				"ep:storeName ?storeName;\n" + 
				"}\n" + 
				"ORDER BY ASC(?ind)";
	}
	public static void query1() {

		String queryString = queryUser();
		Query query = QueryFactory.create(queryString);
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {
				QuerySolution soln = results.nextSolution();
				RDFNode user = soln.get("?ind"); // Get a result variable by name.
				Literal userName = soln.getLiteral("?name");
				Literal userID = soln.getLiteral("?id");
				Literal loggedIn = soln.getLiteral("?on");
				Literal userLogin = soln.getLiteral("?login");
				Literal password = soln.getLiteral("?pass");
				Literal dateOfBirth = soln.getLiteral("?birth");
				Literal gender = soln.getLiteral("?gen");
				//System.out.println(x.toString());
				//Resource g = soln.getResource("?gen"); 
				//Literal l = soln.getLiteral("VarL"); // Get a result variable - must be a literal
			}
		}
	}
	
	public static void selectUsers() {

		String queryString = queryUser();
		Query query = QueryFactory.create(queryString);
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			userResultsToJson(results);
		}
	}
	
	
	public static JSONObject userResultsToJson(ResultSet results) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, results);
		String json = new String(outputStream.toByteArray());
		JSONObject obj = new JSONObject(json);
		
		//String user1 = obj.getJSONObject("results").getJSONArray("bindings").getJSONObject(0).getJSONObject("name").getString("value");
		//String typeInd = obj.getJSONObject("results").getJSONArray("bindings").getJSONObject(0).getJSONObject("ind").getString("type");
		
		JSONArray arr = obj.getJSONObject("results").getJSONArray("bindings");
		for (int i = 0; i < arr.length(); i++)
		{
			String user = arr.getJSONObject(i).getJSONObject("name").getString("value");
		    System.out.println(user);
		    String ind = arr.getJSONObject(i).getJSONObject("ind").getString("value");
		    System.out.println(ind);
		    String indT = arr.getJSONObject(i).getJSONObject("ind").getString("type");
		    System.out.println(indT);
		    String login = arr.getJSONObject(i).getJSONObject("login").getString("value");
		    System.out.println(login);
		}
		return obj;
	}
	
	private static void printingResults(ResultSet results) {
		for (; results.hasNext();) {
			// write to a ByteArrayOutputStream
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ResultSetFormatter.outputAsJSON(outputStream, results);
			String json = new String(outputStream.toByteArray());
			System.out.println(json);
		}
	}
	public static ArrayList<Store> selectStore() {
		String queryString = queryStore();
		Query query = QueryFactory.create(queryString);
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			return loadStore(results);
		}
		
	}
	
	public static ArrayList<Store>  loadStore(ResultSet results) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, results);
		String json = new String(outputStream.toByteArray());
		JSONObject obj = new JSONObject(json);
		
		JSONArray arr = obj.getJSONObject("results").getJSONArray("bindings");
		ArrayList<Store>  owlStores = new ArrayList<Store>();
		for (int i = 0; i < arr.length(); i++)
		{
			 String id = arr.getJSONObject(i).getJSONObject("storeID").getString("value");
			 String type = arr.getJSONObject(i).getJSONObject("activity").getString("value");
			 String name = arr.getJSONObject(i).getJSONObject("storeName").getString("value");
			 String description = "store : "+ arr.getJSONObject(i).getJSONObject("store").getString("value")+"\n"+
					 				"Represents : "+ arr.getJSONObject(i).getJSONObject("represents").getString("value")+"\n"+
					 				"Offers : "+ arr.getJSONObject(i).getJSONObject("offers").getString("value")+"\n"+
					 				"storeLink : "+ arr.getJSONObject(i).getJSONObject("storeLink").getString("value")+"\n";
			String store_photo = arr.getJSONObject(i).getJSONObject("storePhoto").getString("value");
			String location = arr.getJSONObject(i).getJSONObject("isLocatedIn").getString("value");
			Store store = new Store(id, type, name, description, store_photo, location);
			owlStores.add(store);
		}
		return owlStores;
	}

}
