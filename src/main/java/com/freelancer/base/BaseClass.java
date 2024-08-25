package com.freelancer.base;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.freelancer.dataprovider.ConfigFileReader;
import com.freelancer.factory.BrowserFactory;
import com.freelancer.helper.Utility;

public class BaseClass {
	
	 public WebDriver driver;

	 @BeforeClass
		public void setup()
		{
			System.out.println("******** LOG:INFO- Running Setup ********");
			
			System.out.println("******** LOG:INFO- Application will be running on "+ ConfigFileReader.getProperty("browser")+" ********");
			
			driver=BrowserFactory.startBrowser(ConfigFileReader.getProperty("browser"),ConfigFileReader.getProperty("appURL"));
		}
		
		@AfterClass
		public void tearDown()
		{
			System.out.println("******** LOG:INFO- Running TearDown ********");
			
			BrowserFactory.closeAllSession(driver);
		}
		

}
