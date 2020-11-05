package com.jupiter.cloud.planittesting.v1;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jupiter.utilities.TestUtilities;

public class TestCase4 extends TestBase {
	
	@BeforeTest
	public void initialSetup() {
		browserSetup();
		openHomePage();
		
	}
	
	@Test
	public void testCase04() throws InterruptedException {
		// 1.	1.	From the home page go to shop page
		click("shop_ID");
		Reporter.log("<br>");
		Reporter.log("1. From the home page go to shop page - Successful");
		
		// 2.	Click buy button 2 times on “Funny Cow”
		click("funnycow_XPATH");
		click("funnycow_XPATH");
		Reporter.log("<br>");
		Reporter.log("2. Click buy button 2 times on Funny Cow - Successful");
		
		//3.	Click buy button 1 time on “Fluffy Bunny” 
		click("fluffybunny_XPATH");
		Reporter.log("<br>");
		Reporter.log("3. Click buy button 1 time on Fluffy Bunny - Successful");
		
		//4.	Click the cart menu 
		click("cart_ID");
		Reporter.log("<br>");
		Reporter.log("4. Click the cart menu - Successful");
		
		//5.	Verify the items are in the cart
		Reporter.log("<br>");
		Reporter.log("5. Verifing the items in the cart");

		if(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText().trim().equals("Funny Cow")) {
			//System.out.println("Funny Cow is displayed");
			Reporter.log("<br>");
			Reporter.log("Funny Cow is displayed");
		}
		else if(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText().trim().equals("Fluffy Bunny")) {
			//System.out.println("Fluffy Bunny is displayed");
			Reporter.log("<br>");
			Reporter.log("Fluffy Bunny is displayed");
		}
		
		if(driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText().trim().equals("Funny Cow")) {
			//System.out.println("Funny Cow is displayed");
			Reporter.log("<br>");
			Reporter.log("Funny Cow is displayed");
		}
		else if(driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).getText().trim().equals("Fluffy Bunny")) {
			//System.out.println("Fluffy Bunny is displayed");
			Reporter.log("<br>");
			Reporter.log("Fluffy Bunny is displayed");
		}
		
		TestUtilities.instantScreenshot();
	
		
	}

}
