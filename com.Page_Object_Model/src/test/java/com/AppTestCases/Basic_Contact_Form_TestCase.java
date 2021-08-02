package com.AppTestCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mycontactform.Services.Basic_Contact_Form_Service;
import com.project.Utilities.BrowserFactory;
import com.project.Utilities.ConfigReader;

public class Basic_Contact_Form_TestCase {
	
	public static ConfigReader read;
	public static WebDriver driver;
	public static Basic_Contact_Form_Service basiccontact;
	
	
	@BeforeSuite
	public void setupsuite() {
		
		read=new ConfigReader();
	}
	
	@BeforeClass
	public void runpageclass() {
		basiccontact=PageFactory.initElements(driver, Basic_Contact_Form_Service.class);
	}
	
	@BeforeTest
	public void launch_browser() {
		
		driver=BrowserFactory.startBrowser(read.getbrowsername(),read.getbrowserurl());
		
	}
	
	
	
	
	@Test(description = "verify basic contact form")
	public void insert_basic_contact_form_details() {
		
		basiccontact.samplelink().basiccontact().insert_yourname(read.getyourname()).insert_mail(read.getmail()).insert_message(read.getmessage()).click_button();
		System.out.println("verify contact form");
	}
	
	

	
	
	
	
	
	@AfterTest
	public void quitbrowser() {
		driver.quit();
		System.out.println("closing browser");
	}
	
	
	
	
	
	
	
	
	
	

}
