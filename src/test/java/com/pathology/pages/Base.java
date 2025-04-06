package com.pathology.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pathology.utilities.ConfigDataRead;
import com.pathology.utilities.ExcelRead;
import com.pathology.utilities.Helper;
import com.pathology.utilities.OpenBrowser;

public class Base {
	
	public WebDriver driver;
	public ExcelRead excel;
	public ConfigDataRead config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setUp()
	{
		
		Reporter.log("Test Started", true);
		excel= new ExcelRead();
		config= new ConfigDataRead();
		
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/GOR_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be started", true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser and getting application ready", true);
		driver= OpenBrowser.startApp(driver, config.getBrowser(), config.getUrl());
		Reporter.log("Browser and Application is up and running", true);
	}
	
	
	@AfterClass
	public void close()
	{
		OpenBrowser.quitBrowser(driver);
	}
	
	@AfterMethod
	public void failTestcaseScreenshot(ITestResult result) throws Exception
	{
		Reporter.log("Test is about to end", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
		report.flush();
		Reporter.log("Test Completed >>> Reports Generated", true);
				
	}

}
