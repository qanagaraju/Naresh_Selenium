package com.project.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenCapture {
	
public  String capturescreen(WebDriver driver,String screename) throws IOException {
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File file = element.getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		File dest = new File("./TestReports/"+screename+dateName+".png");
		
		String destpath = dest.getAbsolutePath();
		FileUtils.copyFile(file, dest);
		return destpath;
		
		
	}

}
