package com.ns.utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.ns.testBase.TestBaseClass;

public class CommonClass extends TestBaseClass {
	
	public void screenshot(String filename)
	{
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\user\\Desktop\\NeostoxRepo1\\NeostoxRepo1\\Neostox1\\Screenshot"+filename+".png"+System.currentTimeMillis());
		try 
		{
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}

}
