package com.project.Utilities;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.managers.EdgeDriverManager;

public class BrowserFactory 
{
	
	public static WebDriver driver;
	//public static ChromeDriver driver;
	
	public static  WebDriver startBrowser(String browsertype,String appurl) {
		
		
		
		/*
		switch(browsertype) {
		
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--chrome");
			options.addArguments("--start-fullscreen");
			 driver = new ChromeDriver();
			 break;
		
		case "firefox":
			 driver = new FirefoxDriver();
			 break;
			 
			 
		case "edge":
			EdgeDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			 break;
		}
		*/
		
		
		if(browsertype.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--chrome");
			options.addArguments("--start-fullscreen");
			 driver = new ChromeDriver();
			
		}else if(browsertype.equals("firefox")) {
			
			 driver = new FirefoxDriver();
			
		}else if(browsertype.equals("edge")) {
			EdgeDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
			
		}
		
		
		
		
		driver.get(appurl);
		
		if(appurl.equals(driver.getCurrentUrl())) {
			//Assert.assertTrue("URL verified", true);
			
			System.out.println("URL step verified");
			System.out.println(driver.getCurrentUrl());
		}
		else
		{
			//Assert.assertFalse(false);
			System.out.println("URL Does not verified");
		}
		
		
		
		
		return driver;
		
	}
	
	
	//To close the browser
	public static void quitBrowser() {
		driver.quit();
	}
	
	
	
    
}
