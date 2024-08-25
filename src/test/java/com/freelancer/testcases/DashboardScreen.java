package com.freelancer.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.freelancer.base.BaseClass;
import com.freelancer.pages.Dashboard;

public class DashboardScreen extends BaseClass{
	
	@Test(priority=1)
	public void  AddCoursetoDashboard() {
		
		Dashboard dashashabord = new Dashboard(driver);
		dashashabord.getWelcomeMessage();
		dashashabord.doAddCourse();
		int count=dashashabord.doShowCourseCount();
		Assert.assertEquals(count, 1);
	}

}
