package com.freelancerJavaScript;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.freelancer.base.BaseClass;


public class TestJavaScript extends BaseClass {
	
    
	public  void  testJavaScript() throws InterruptedException {
		/*
		 * By email = By.id("email1");
		 * 
		 * By password = By.id("password1"); By button = By.xpath("//button");
		 */
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * 
		 * // Ensure elements are visible and ready for interaction
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(email));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		 * 
		 * // JavaScript to send value
		 * js.executeScript("document.getElementById('email1').value='admin@email.com'")
		 * ; System.out.println("Email set via JavaScript");
		 * 
		 * js.executeScript("document.getElementById('password1').value ='admin@123'");
		 * System.out.println("Password set via JavaScript");
		 * 
		 * // Ensure button is ready to be clicked WebElement clickButton =
		 * wait.until(ExpectedConditions.elementToBeClickable(button));
		 * 
		 * // JavaScript to click using xpath js.executeScript("arguments[0].click()",
		 * clickButton); System.out.println("Button clicked via JavaScript");
		 */
	        getAllElements(driver);
	}
	

	

	
	
	public static void main(String[] args) {
		
		TestJavaScript driver= new TestJavaScript();
		driver.setup();
		try {
			driver.testJavaScript();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static WebElement ExplicitWait(WebDriver driver,By locator) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	public static WebElement getElement(WebDriver driver, By Locator) {
		WebElement ele=ExplicitWait(driver, Locator);
		return ele;
       	
		
		
}
	public static void getAllElements(WebDriver driver) {
		
		List<WebElement> ele=driver.findElements(By.xpath("//div[@class='social-btns']/a"));
		
		for(WebElement element: ele) {
			
		String name=	element.getAttribute("href");
		System.out.println("value is "+name);
		}
	}
 
	
}