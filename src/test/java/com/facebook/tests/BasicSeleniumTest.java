package com.facebook.tests;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class BasicSeleniumTest {
	

	@Test
	public static void basicTest() {
		
	//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
	System.setProperty("webdriver.gecko.driver", "/Users/nayasr01/SQA-Automation/SeleniumProject/drivers/geckodriver");
	WebDriver driver = new FirefoxDriver();
    String baseUrl = "http://facebook.com";
	String expectedTitle = "Facebook - Log In or Sign Up";
	String actualTitle = "";
         
		// launch Fire fox and direct it to the Base URL
	driver.get(baseUrl);

		// get the actual value of the title
	actualTitle = driver.getTitle();
	String actualURL=driver.getCurrentUrl();
	System.out.println(" The URL "+actualURL);
	actualTitle=actualTitle.trim();
	System.out.println(" The actual Title " +actualTitle);
    Assert.assertEquals(expectedTitle, actualTitle);
		

		// close Fire fox
		driver.close();

	}

}