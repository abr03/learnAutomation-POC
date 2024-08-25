package com.freelancer.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {
	
	
	
	
	public static String getProperty(String key) {
		Properties prop= new Properties();
		try {
			File src= new File("./Configuration/Config");
            FileInputStream fis= new FileInputStream(src);
			prop.load(fis);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found please check location "+e.getMessage());
		}
		catch (IOException e ) {
			System.out.println("Could not read the  file " +e.getMessage());

		}
		String value=prop.getProperty(key);

		
		 return value; 

	}
}
	

