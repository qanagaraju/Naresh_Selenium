package com.AppTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mycontactform.Services.AppLoginServices;
import com.project.Utilities.BrowserFactory;
import com.project.Utilities.ConfigReader;
import com.project.Utilities.ScreenCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class App_Login_Test {
  
	public static BrowserFactory browser;
	public static WebDriver driver;
	public static AppLoginServices loginservice;
	public static ConfigReader reader;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ScreenCapture screen;
	
	
	@BeforeSuite
	public void setupsuite() {
		browser=new BrowserFactory();
		reader=new ConfigReader();
		extent = new ExtentReports("./ExtentReports/extentreport.html");
		test = extent.startTest("Login Test");
		screen=new ScreenCapture();
	}
	
	@BeforeTest
	public void startBrowser() {
		
		driver=BrowserFactory.startBrowser(reader.getbrowsername(), reader.getbrowserurl());
	}
	
	
	@Test(priority=2,description="Valid Login")
	//@Parameters({"validusername","password"})
  public void verify_valid_user_credentials() throws IOException {
	  
	  loginservice=PageFactory.initElements(driver, AppLoginServices.class);
	  loginservice.getusername(reader.getvalidusername()).getpassword(reader.getpassword()).getloginbutton().getlogout();
	  //screen.capturescreen(driver,"login window");
	  
	  
  }
	
	
	@Test(priority=1,description="verify invalid login")
	//@Parameters({"invalidusername","password"})
	public void verify_invalid_user_credentials() throws IOException {
		loginservice=PageFactory.initElements(driver, AppLoginServices.class);
		loginservice.getusername(reader.getinvalidusername()).getpassword(reader.getpassword()).getloginbutton();
		 //screen.capturescreen(driver,"invalid login window");
	}
	
	
	
	@AfterTest
	public void generateExtentReport() {
		extent.flush();
	}
	
	
}
