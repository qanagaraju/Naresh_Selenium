package com.mycontactform.Services;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Basic_Contact_Form_Service {
	
	@FindBy(xpath="//*[contains(text(),\"Sample Forms\")]")
	WebElement samplelink;
	
	@FindBy(xpath="//*[@id=\"left_col_top\"]/ul[1]/li[1]/a")
	WebElement basicontact;
	
	@FindBy(name="q[1]")WebElement yourname;
	@FindBy(name="email")WebElement email;
	@FindBy(name="q[2]")WebElement message;
	@FindBy(name="submit")WebElement button;
	
	
	public Basic_Contact_Form_Service samplelink() {
		
		if(samplelink.isEnabled()) {
			samplelink.click();
			//Assert.assertTrue(true);
		}
		else
		{
			//Assert.assertFalse(false);
		}
		
		return this;
	}
	
	public Basic_Contact_Form_Service basiccontact() {
		
		if(basicontact.isEnabled()) {
			basicontact.click();
			
			//Assert.assertTrue(true);
		}
		else
		{
			//Assert.assertFalse(false);
		}
		
		return this;
	}
	
	public Basic_Contact_Form_Service insert_yourname(String yname) {
		
		yourname.sendKeys(yname);
		
		return this;
	}
	
	public Basic_Contact_Form_Service insert_mail(String mail) {
		email.sendKeys(mail);
		return this;
	}
	
	public Basic_Contact_Form_Service insert_message(String msg) {
		message.sendKeys(msg);
		return this;
	}

	public Basic_Contact_Form_Service click_button() {
		
		button.click();
		return this;
	}
		
	
}
