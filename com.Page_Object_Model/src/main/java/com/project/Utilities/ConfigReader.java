package com.project.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static File file;
	public static Properties prop;
	
	public ConfigReader() {
		
		
		try {
			file = new File("./com.AppFiles/login.properties");
			FileInputStream fis = new FileInputStream(file);
			
			prop = new Properties();
			prop.load(fis);			
			
			
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}finally {
			//logic for our exception
			if(file.exists()) {
				System.out.println("Exception created");
			}
			else
			{
				System.out.println("Fails to create exception");
			}
			
			//Exception for loading properties
			
			if(prop != null) {
				System.out.println("Prop exception created");
			}
			else
			{
				System.out.println("Prop exception did not created");
			}
			
			
			
		}
		
	}
	
	//Create a methods for properties
	
	public String getbrowsername() {
		return prop.getProperty("chromebrowser");
	}
	
	
	public String getbrowserurl() {
		return prop.getProperty("browserurl");
	}
	
	public String getinvalidusername() {
		return prop.getProperty("invalidusername");
	}
	
	public String getvalidusername() {
		return prop.getProperty("validusername");
	}
	
	public String getpassword() {
		return prop.getProperty("password");
	}
	
	
	//Basic contact form details
	public String getyourname() {
		return prop.getProperty("yourname");
	}
	
	public String getmail() {
		return prop.getProperty("mail");
	}
	
	public String getmessage() {
		return prop.getProperty("message");
	}
	
	
	

}
