package com.ns.testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("Framework for Neostox1");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Framework Execution Started");
	}
	
	@AfterClass
	public void end()
	{
		logger.info("Framework Executin Completed");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
		if(br.equalsIgnoreCase("chrome"))
		{
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		}
		
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else
		{
			System.out.println("Please Provide Correct Browser");
		}
		
		driver.get("");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
																				
