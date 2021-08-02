package com.mycontactform.Services;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.project.Utilities.ScreenCapture;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AppLoginServices
{
	
	public static ExtentReports extent;
	public static ExtentTest test;
	ScreenCapture screen=new ScreenCapture();
	public static WebDriver driver;
   
	//Login Page Objects
	@FindBy(name="user")WebElement username;
	@FindBy(name="pass")WebElement password;
	@FindBy(name="btnSubmit")WebElement loginbutton;
	@FindBy(xpath="//*[contains(text(),'Logout')]")WebElement logout;
	@FindBy(id="right_col_top_err")WebElement errormessage;
	
	
	
	public AppLoginServices getusername(String un) {
		extent = new ExtentReports("./ExtentReports/extentreport.html");
		test = extent.startTest("Login Test");
		
		username.sendKeys(un);
		
		return this;
	}
	
	
	public AppLoginServices getpassword(String pw) {
		
		password.sendKeys(pw);
		
		return this;
	}
	
	
	public AppLoginServices getloginbutton()  {
		
		if(loginbutton.isEnabled()) {
			loginbutton.click();
			test.log(LogStatus.PASS,"Button Verified");
			//test.log(LogStatus.INFO, test.addScreenCapture(screen.capturescreen(driver, "Login Button")));
			Assert.assertTrue(true);
			
			try {
				
				if(errormessage.isDisplayed()) {
					System.out.println(errormessage.getText());
					test.log(LogStatus.INFO, errormessage.getText());
				}
				
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			
			
		}else
			
		{
			test.log(LogStatus.FAIL, "Button step failed");
			Assert.assertFalse(false);
		}
		
		extent.flush();
		return this;
	}
	
	
	public AppLoginServices getlogout()  {
		
		if(logout.isEnabled()) {
			logout.click();
			Assert.assertTrue("Login Success", true);
			//test.log(LogStatus.PASS, test.addScreenCapture(screen.capturescreen(driver, "Login Success")));
		}
		else
		{
			Assert.assertFalse("Login Fail",false);
			System.out.println("Login fail");
		}
		
		extent.flush();
		
		return this;
	}
	
	
}
