package com.facebook.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SelenimPractice {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		System.setProperty("webdriver.gecko.driver", "/Users/nayasr01/SQA-Automation/SeleniumProject/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		//useSelectDropDown(driver);
		//useByLinkText(driver);
		useByPartialText(driver);
		//advancedActions(driver);
		//dragDrop(driver);
		//scrollByPageElement(driver);
		
		//scrollThePageDown(driver);
		//usingSiblingAndParent(driver);
		

	}
	

	public static void useSelectDropDown(WebDriver driver) {
		String baseURL = "http://demo.guru99.com/test/newtours/register.php";
		 
		driver.get(baseURL);
		

		Select drpCountry = new Select(driver.findElement(By.name("country")));
		drpCountry.selectByVisibleText("ANTARCTICA");
		drpCountry.selectByIndex(2);
		
		driver.quit();
	}

	public static void useByLinkText(WebDriver driver) {
		//By Links and Partial text.
		  String baseUrl = "http://demo.guru99.com/test/link.html";						 					        		
	        driver.get(baseUrl);					
	        driver.findElement(By.linkText("click here")).click();					
	        System.out.println("title of page is: " + driver.getTitle());
	        driver.quit();	
	        		
	}
	public static void useByPartialText(WebDriver driver) {
		String baseUrl = "http://demo.guru99.com/test/link.html";						 					        		
        driver.get(baseUrl);
		driver.findElement(By.partialLinkText("here")).click();					
        System.out.println("Title of page is: " + driver.getTitle());							
        driver.quit();	
	}
	
	public static void mouseHover(WebDriver driver) {
		
		 // Launch the URL 
	     driver.get("http://demoqa.com/menu/");
	     System.out.println("demoqa webpage Displayed");
	        
	     //Maximise browser window
	 driver.manage().window().maximize();
	     
	 //Adding wait 
	 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	                
	        //Instantiate Action Class        
	        Actions actions = new Actions(driver);
	        //Retrieve WebElement 'Music' to perform mouse hover 
	     WebElement menuOption = driver.findElement(By.xpath("//div[contains(text(),'Music')]"));
	     //Mouse hover menuOption 'Music'
	     actions.moveToElement(menuOption).perform();
	     System.out.println("Done Mouse hover on 'Music' from Menu");
	     driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
	     
		 
		 
	}

	public static void dragDrop(WebDriver driver) {
		
		 String URL = "https://demoqa.com/droppable/"; 
		 driver.get(URL);
	 
	 // It is always advisable to Maximize the window before performing DragNDrop action 
	 driver.manage().window().maximize();
	 
	 driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	 
	 //Actions class method to drag and drop 
	 Actions builder = new Actions(driver);
	 
	 WebElement from = driver.findElement(By.id("draggable"));
	 
	 WebElement to = driver.findElement(By.id("droppable")); 
	 //Perform drag and drop
	 builder.dragAndDrop(from, to).perform();
	 
	 //verify text changed in to 'Drop here' box 
	 String textTo = to.getText();
	 
	 if(textTo.equals("Dropped!")) {
	 System.out.println("PASS: Source is dropped to target as expected");
	 }else {
	 System.out.println("FAIL: Source couldn't be dropped to target as expected");
	 }
	 
	 //driver.close();
	     
		 
		 
	}

	public static void scrollByPageElement(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launch the application		
        driver.get("http://demo.guru99.com/test/guru99home/");

        //Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.linkText("Linux"));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
	}

	public static void scrollThePageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application		
        driver.get("http://demo.guru99.com/test/guru99home/");

        //This will scroll the web page till end.		
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
    public static void usingSiblingAndParent(WebDriver driver) {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/guru99home/");

        //Search element inside 'Popular course' which are sibling of control 'SELENIUM' ,Here first we will find a h2 whose text is ''A few of our most popular courses' ,then we move to its parent element which is a 'div' , inside this div we will find a link whose text is 'SELENIUM' then at last we will find all of the sibling elements of this link('SELENIUM')
        
        List <WebElement> dateBox = driver.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[@class='rt-grid-2 rt-omega']"));

        //Print all the which are sibling of the the element named as 'SELENIUM' in 'Popular course'
        for (WebElement webElement : dateBox) {
            System.out.println(webElement.getText());
        }     

       // driver.close();
    }

}
	


        
