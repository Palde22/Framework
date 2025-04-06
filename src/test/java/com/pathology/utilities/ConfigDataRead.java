package com.pathology.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataRead {
	
	Properties prop;
	public ConfigDataRead() {
	
		File fl= new File("./Configurations/Config.properties");
		try {
			FileInputStream fi=new FileInputStream(fl);
			prop = new Properties();
			prop.load(fi);
		} catch (Exception e) {
			System.out.println("Not able to load config file"+e.getMessage());
		}
	
	}
	
	public String getKey(String key)
	{
		return prop.getProperty(key);
	}
	
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	public String getUrl()
	{
		return prop.getProperty("Url");
	}

}
