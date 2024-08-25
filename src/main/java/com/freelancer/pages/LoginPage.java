package com.freelancer.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.freelancer.dataprovider.ExcelReader;
import com.freelancer.helper.Utility;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	private By Emailid= By.id("email1");
	private By password= By.id("password1");
	private By Button= By.xpath("//button");
	private By ErrorMessage= By.xpath("//h2[normalize-space()='Email and Password is required']");
	private By socialLinks= By.xpath("//div[@class='social-btns']/a");
	private By signUp= By.xpath("//a[normalize-space()=\"New user? Signup\"]");
	
	
	public void loginApp(String username, String pass) {
		Utility.getElement(driver, Emailid).sendKeys(username);
		
		Utility.getElement(driver, password).sendKeys(pass);
		
		Utility.getElement(driver, Button).click();
		
	
	}
	
	public void GetErrorOnInvalidLogin() {
	WebElement ele=	Utility.getElement(driver, ErrorMessage);
	System.out.println("Messge is :"+ele.getText());
	}
	
	public int VerifySocialLinks() {
		
		int buttons =Utility.GetAllElements(driver, socialLinks, "href");
		return buttons;
	}
	
	public WebElement UserSignUp() {
		
    WebElement SignUp=  Utility.getElement(driver, signUp);
    
    return SignUp;
		
	}
}
