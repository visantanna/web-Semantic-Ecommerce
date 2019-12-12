package com.example.ontology;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

import com.example.demo.business.ProductsBusiness;
import com.example.demo.business.StoreBusiness;
import com.example.demo.controler.StoreController;
import com.example.demo.dto.Product;
import com.example.demo.dto.Store;

public class SparqlService {
	
	static private String readQuery(String filename) {
    	StringBuffer sb = new StringBuffer();
    	File f = new File("");
		
        try (FileReader reader = new FileReader(f.getAbsolutePath()+"/"+filename);
             BufferedReader br = new BufferedReader(reader)) {
        	
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
            	sb.append(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        return sb.toString();
   }
	
	static private  OntModel model = OwlService.getOwlModel();
	
	private static String queryUser() {
		return readQuery("src/main/queries/users");	
	}
	
	private static String queryStore() {
		return readQuery("src/main/queries/store");		
	}
		
	private static String queryProductByStore() {
		return readQuery("src/main/queries/productByStore");	
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
	
	public static ArrayList<Store> selectStore() {
		String queryString = queryStore();
		Query query = QueryFactory.create(queryString);
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			return loadListStore(results);
		}		
	}
	
	public static ArrayList<Store>  loadListStore(ResultSet results) {
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, results);
		String json = new String(outputStream.toByteArray());
		JSONObject obj = new JSONObject(json);
		
		JSONArray arr = obj.getJSONObject("results").getJSONArray("bindings");
		ArrayList<Store>  owlStores = new ArrayList<Store>();
		//if (new	Switch().store()==true) {
			owlStores.addAll(StoreBusiness.mockStores());
		//}

		for (int i = 0; i < arr.length(); i++)
		{
			String id = arr.getJSONObject(i).getJSONObject("storeID").getString("value");
			String type = arr.getJSONObject(i).getJSONObject("CategoryName").getString("value");
			String name = arr.getJSONObject(i).getJSONObject("storeName").getString("value");
			String description = arr.getJSONObject(i).getJSONObject("storeDesc").getString("value");
			String store_photo = arr.getJSONObject(i).getJSONObject("storePhoto").getString("value");
			String location = arr.getJSONObject(i).getJSONObject("isLocatedIn").getString("value");
			Store store = new Store(id, type, name, description, store_photo, location);
			owlStores.add(store);
			
		}
		return owlStores;
	}
	
	public static ArrayList<Product>  loadProduct() {
		String queryString = queryProductByStore();
		Query query = QueryFactory.create(queryString);
		try (QueryExecution qexec = QueryExecutionFactory.create(query, model)) {
			ResultSet results = qexec.execSelect();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			ResultSetFormatter.outputAsJSON(outputStream, results);
			String json = new String(outputStream.toByteArray());
			JSONObject obj = new JSONObject(json);
			
			JSONArray arr = obj.getJSONObject("results").getJSONArray("bindings");
			ArrayList<Product>  owlProducts = new ArrayList<Product>();
			//if (new	Switch().prod()==true) {
				owlProducts.add(ProductsBusiness.tenisNike);
			//}
			for (int i = 0; i < arr.length(); i++)
				{	
					String id = arr.getJSONObject(i).getJSONObject("productID").getString("value");
					double price = Double.parseDouble(arr.getJSONObject(i).getJSONObject("unitPrice").getString("value"));
					String name = arr.getJSONObject(i).getJSONObject("productName").getString("value");
					String idStore = arr.getJSONObject(i).getJSONObject("storeID").getString("value");
					String brand = arr.getJSONObject(i).getJSONObject("brandName").getString("value");
					String productPhoto = arr.getJSONObject(i).getJSONObject("productPhoto").getString("value");
					Product product = new Product(id, price, name, idStore, brand, productPhoto);
				
					owlProducts.add(product);
				}
			return owlProducts;
		}
		
	}

}
