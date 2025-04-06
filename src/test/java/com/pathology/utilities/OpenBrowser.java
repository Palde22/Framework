package com.pathology.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
	
	public static WebDriver startApp(WebDriver driver, String browserName, String url) {
		if(browserName.equals("Chrome")) {
			System.setProperty("websriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			System.setProperty("websriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("We don't support this browser");
	}
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get(url);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
	}
	
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
