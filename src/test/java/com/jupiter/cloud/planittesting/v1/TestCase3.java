package com.jupiter.cloud.planittesting.v1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jupiter.utilities.TestUtilities;

public class TestCase3 extends TestBase {
	
	@BeforeTest
	public void initialSetup() {
		browserSetup();
		openHomePage();
		
	}
	
	@Test
	public void testCase03() throws InterruptedException {
		// 1.	From the home page go to contact page
		click("contact_XPATH");
		Reporter.log("1. From the home page go to contact page - Successful");
		
		// 2.	Populate mandatory fields with invalid data
		
		//Forename 
		type("forename_ID","123");
		//email 
		type("email_ID","123");
		//message 
		type("message_ID","%^&");

		Reporter.log("<br>");
		Reporter.log("2. Populated mandatory fields with invalid data");

		
		//3.	3.	Validate errors	

		Reporter.log("<br>");
		Reporter.log("3. Validate errors");
		
		Assert.assertTrue(isDisplayed("//*[@class='alert alert-error ng-scope']", "Error Notification - Header"));
		Assert.assertTrue(isDisplayed("//span[@id='email-err']", "Email Error - Alert"));
		TestUtilities.instantScreenshot();
		
				
		
	}
	
	
	
}


