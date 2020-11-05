package com.jupiter.cloud.planittesting.v1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jupiter.utilities.TestUtilities;

public class TestCase1 extends TestBase {
	
	@BeforeTest
	public void initialSetup() {
		browserSetup();
		openHomePage();
				
	}
	
	@Test
	public void testCase01() {
		// 1.	From the home page go to contact page
		click("contact_XPATH");
		Reporter.log("<br>");
		Reporter.log("1. From the home page go to contact page - Successful");
		
		// 2.	Click submit button
		click("btn_submit_XPATH");
		Reporter.log("<br>");
		Reporter.log("2. Click submit button - Successful");
		
		// 3.	Validate errors
		Reporter.log("<br>");
		Reporter.log("3. Validate errors");		
		Assert.assertTrue(isDisplayed("//span[@id='forename-err']", "ForeName Error"));
		Assert.assertTrue(isDisplayed("//span[@id='email-err']", "Email Error"));
		Assert.assertTrue(isDisplayed("//span[@id='message-err']", "Message Error"));
		TestUtilities.instantScreenshot();
	
		// 4.	Populate mandatory fields
		
		//Forename 
		type("forename_ID","testforename");
		//email 
		type("email_ID","test@email.com");
		//message 
		type("message_ID","testMessage");
		Reporter.log("<br>");
		Reporter.log("4. Populate mandatory fields - Successful");	
		
		//5.	Validate errors are gone
		Reporter.log("<br>");
		Reporter.log("5. Validate errors are gone");	
		Assert.assertFalse(isDisplayed("//span[@id='forename-err']", "ForeName Error"));
		Assert.assertFalse(isDisplayed("//span[@id='email-err']", "Email Error"));
		Assert.assertFalse(isDisplayed("//span[@id='message-err']", "Message Error"));
		TestUtilities.instantScreenshot();
		
						
		
	}

}
