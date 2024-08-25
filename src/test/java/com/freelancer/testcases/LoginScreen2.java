package com.freelancer.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.freelancer.base.BaseClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginScreen2  {
	WebDriver driver;
	@Test
	public void LoginApp() {
		WebDriver driver=launchBrowser("https://freelance-learn-automation.vercel.app/login", "Chrome");
		driver.findElement(By.id("email1")).sendKeys("admin@email.com");
		driver.findElement(By.id("password1")).sendKeys("admin@123");
		driver.findElement(By.xpath("//button")).click();
		int coursecount=getCourseCount(driver);
    	System.out.println("count of the course---"+coursecount);
    	Assert.assertEquals(coursecount, 1);

		driver.quit();

	}
 
	
public static WebDriver launchBrowser(String url, String browser) {
		
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
			
		}
		else if (browser.equalsIgnoreCase("Edge")) {
			
			driver= new EdgeDriver();
			
		}
		else if (browser.equalsIgnoreCase("FireFox")) {
			
			driver= new FirefoxDriver();
		}
		else {
			System.out.println("Launch ChromeByDefault");
			driver= new ChromeDriver();
		}
	
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get(url);		
		return driver;

	}

public static int getCourseCount(WebDriver driver) {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element = driver.findElement(By.xpath("(//h2[text()='TESTSCRIPT']//following::button)[1]"));
	js.executeScript("arguments[0].scrollIntoView();", element);
    js.executeScript("window.scrollBy(0, -50);"); // Adjust the scroll position slightly if needed

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 element = wait.until(ExpectedConditions.elementToBeClickable(element));
	 //js.executeScript("window.scrollBy(0, -100);"); // Adjust the scroll position slightly

	 try {
		 element.click();

	 }
	 catch(ElementClickInterceptedException e) {
		 System.out.println("unable to do normal click");
	    js.executeScript("arguments[0].click();", element);
	 }
    // Click the button
 //   element.click();
    
    // Corrected XPath for the count element
    WebElement count = driver.findElement(By.xpath("//span[@class='count']"));
    
    // Get the text of the count element
    String countText = count.getText();
    int coursecount=Integer.parseInt(countText);
    System.out.println("no of course added---"+coursecount);
    
    return coursecount;
}


   
}


