package com.pathology.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pathology.pages.Base;
import com.pathology.pages.LoginPage;
import com.pathology.utilities.OpenBrowser;

public class LoginTest extends Base{
	
	
	LoginPage lp;
	
	@Test
	public void login() {
		
		String dashboardTitle="GOR Pathology Web Portal";
		
		logger = report.createTest("Login to GOR");
		lp=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		
		lp.loginToLab(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		Assert.assertEquals(driver.getTitle(), dashboardTitle);
		logger.pass("Login Success");
		
	}
	
	
}
