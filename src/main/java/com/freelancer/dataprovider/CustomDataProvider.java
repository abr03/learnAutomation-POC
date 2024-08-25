package com.freelancer.dataprovider;

import org.testng.annotations.DataProvider;


public class CustomDataProvider {

	
	@DataProvider(name="LoginCredentials")
	public static Object[][] getLoginCredentials()
	{
		System.out.println("******** LOG:INFO- Setting up test data ********");
		
		Object[][]arr= ExcelReader.getDataFromExcel("Login");
		
		System.out.println("******** LOG:INFO- Test data setup completed ********");
	
		return arr;
	}
	
	
	
}
