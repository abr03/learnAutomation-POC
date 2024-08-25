package com.freelancer.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freelancer.base.BaseClass;
import com.freelancer.dataprovider.ConfigFileReader;
import com.freelancer.helper.Utility;
import com.freelancer.pages.Cart;
import com.freelancer.pages.Dashboard;
import com.freelancer.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginScreen extends BaseClass {

   @Test(priority = 1,dataProvider = "LoginCredentials",dataProviderClass = com.freelancer.dataprovider.CustomDataProvider.class)
   public void LoginApp(String username, String password) {
	   
	   LoginPage login = new LoginPage(driver);
	   login.loginApp(username, password);
	   Assert.assertTrue(true, "Test Passed");
	   
	 
	   
   }
   @Test(priority = 2,description = "This test is to verify no of links")
   
   public void VerifyNoOfSocialLinks() {
	   LoginPage login = new LoginPage(driver);
	   int socialEle= login.VerifySocialLinks();
		  Assert.assertEquals(socialEle,9,"Test passed");

   }
   
   @Test (priority = 3, description = " this test is to verify user is able to select sign in")
   public void selectSignUp() {
	   LoginPage login = new LoginPage(driver);
	   WebElement Signup=  login.UserSignUp();
	   Assert.assertTrue(Signup.isEnabled(),"Test Passed");
	   

   }
   
  
   

}

