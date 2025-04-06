package com.pathology.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		this.driver=ldriver;
		}

	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//*[(text()= 'Login')]") WebElement lbutton;
	
	
	public void loginToLab(String appUsername, String appPassword)
	{
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		uname.sendKeys(appUsername);
		pass.sendKeys(appPassword);
		lbutton.click();
		
	}
	
}
