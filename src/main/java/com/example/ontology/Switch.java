package com.example.ontology;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Switch {
	boolean[] result = { false, false };
	InputStream inputStream;

	private boolean[] switchOn() throws IOException {

		try {
			File f = new File("");
			
	        Properties prop = new Properties();
			String propFileName = "src/main/queries/switchOn";

			inputStream = getClass().getClassLoader().getResourceAsStream(f.getAbsolutePath()+"/"+propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			boolean store = Boolean.parseBoolean(prop.getProperty("mockStore"));
			boolean prod = Boolean.parseBoolean(prop.getProperty("mockProduct"));
			result[0] = store;
			result[1] = prod;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return result;
	}

	public boolean prod() {
		try {
			return switchOn()[1];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean store() {
		try {
			return switchOn()[0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
