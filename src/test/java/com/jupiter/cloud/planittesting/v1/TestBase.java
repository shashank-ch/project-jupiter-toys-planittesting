package com.jupiter.cloud.planittesting.v1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	public static RemoteWebDriver driver;
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	public void browserSetup() {
		
		String userPath = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver",
				userPath+"\\eclipse-workspace\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	public void openHomePage() {
		driver.get("https://jupiter.cloud.planittesting.com/");
		
	}
	
	@BeforeSuite
	public void loadObjectRepository() {
		
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			OR.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void click(String locator) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
	}

	public void type(String locator, String value) {

		if (locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}


	}
	
	public boolean isDisplayed(String xpath, String name) {
		 try   
		  {    
		    driver.findElement(By.xpath(xpath));
		    Reporter.log("<br>");
		    Reporter.log(name+" is Displayed");
		    return true;
		      
		  }      
		  catch(NoSuchElementException e)     
		  {
			  Reporter.log("<br>");
			  Reporter.log(name+" is not Displayed");
			  return false;     
		  } 		 
	
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterSuite
	public void tearDown() {

		if (driver != null) {
			driver.quit();
		}

	}
	

}
