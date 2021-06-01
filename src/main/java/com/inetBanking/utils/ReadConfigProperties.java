package com.inetBanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReadConfigProperties {
	
	public static Properties prop;
	
	public static Properties ReadConfigPropertiesFile() {
		
		File propfilePath = new File("./src/main/java/com/inetBanking/configuration/config.properties");
		try {
			FileInputStream fis = new  FileInputStream(propfilePath);
			prop = new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	


	

}
