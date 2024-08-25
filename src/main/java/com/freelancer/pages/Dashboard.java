package com.freelancer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.freelancer.helper.Utility;

import groovyjarjarantlr4.v4.runtime.misc.ParseCancellationException;

public class Dashboard {
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
	}
	
	private By TestScriptAddToCart = By.xpath("(//h2[text()='TESTSCRIPT']//following::button)[1]");
	
//	private By Cart= By.xpath("//button[@class='cartBtn']");
	
	private By CartCount= By.xpath("//span[@class='count']");

	private By welcomeMsg=By.xpath("//h4[@class='welcomeMessage']");
	
	
	public String getWelcomeMessage() {
		String welcomeText=Utility.getElement(driver, welcomeMsg).getText();
		return welcomeText;
	}
	

	 public void doAddCourse() {
		 Utility.clickElement(driver, TestScriptAddToCart);
	 }
	
	 public int doShowCourseCount() {
		WebElement courseCount= Utility.getElement(driver, CartCount);
		String countText=courseCount.getText();
		System.out.println("count of the Text is :"+countText);
		int coursecount=Integer.parseInt(countText);
		System.out.println("Count of the course--"+coursecount);
		return coursecount;
	 }


}

