package com.jupiter.cloud.planittesting.v1;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jupiter.utilities.TestUtilities;

public class TestCase2 extends TestBase {
	
	@BeforeTest
	public void initialSetup() {
		browserSetup();
		openHomePage();
				
	}
	
	@Test
	public void testCase02() throws InterruptedException {
		// 1.	From the home page go to contact page
		click("contact_XPATH");
		Reporter.log("<br>");
		Reporter.log("1. From the home page go to contact page - Successful");
		
		// 2.	Populate mandatory fields
		//Forename 
		type("forename_ID","testforename");
		//email 
		type("email_ID","test@email.com");
		//message 
		type("message_ID","testMessage");
		Reporter.log("<br>");
		Reporter.log("2. Populate mandatory fields - Successful");	
		
		//3.	Click submit button		
		click("btn_submit_XPATH");
		Reporter.log("<br>");
		Reporter.log("3. Click submit button - Successful");	

		
		//4.	Validate successful submission message
		
		//Thread.sleep(4000L);
		Reporter.log("<br>");
		Reporter.log("4. Validate successful submission message");
		
		Assert.assertTrue(isDisplayed("//div[@class='alert alert-success']", "Success Message"));
		TestUtilities.instantScreenshot();
		
		Reporter.log("<br>");
		Reporter.log("Assert False to show a failed test validation");
		Assert.assertTrue(false);
		// inserted this to check the failure reporting in report
		
			
		
	}

}
