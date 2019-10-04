package com.facebook.tests;

import org.openqa.selenium.By;

//import java.nio.file.FileSystems;
//import java.nio.file.Path;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import com.examples.config.GlobalDataStore;
import com.examples.pages.FaceBookHomePage;

public class FirefoxTest {
	
	WebDriver driver;
	String expectedTitle = "Facebook - Log In or Sign Up";
	String actualTitle = "";
	String HomePage="";
	String GecKoDriver="";
	
	@BeforeClass
	public  void init() {
		GlobalDataStore gds = new GlobalDataStore();
	    gds.initParameters();
	    GecKoDriver=GlobalDataStore.GeckoDriver_MAC;
		HomePage=GlobalDataStore.HomePage;
		System.out.println("The HomePage " +HomePage);
		System.out.println(" The GeckoDriver " +GecKoDriver);
		//System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		System.setProperty("webdriver.gecko.driver", GecKoDriver);
		driver = new FirefoxDriver();  
		
	}
	
	

	@Test(enabled=false)
	public  void basicTest() {
			 
		// launch Fire fox and direct it to the Base URL
		
		// get the actual value of the title
		driver.get(HomePage);
		actualTitle = driver.getTitle();
		String actualURL=driver.getCurrentUrl();
		System.out.println(" The URL "+actualURL);
		actualTitle=actualTitle.trim();

		 Assert.assertEquals(expectedTitle, actualTitle);
		// close Fire fox
		//driver.close();

	}


	@Test(enabled=false)
	public void testUserLogin() throws InterruptedException{
		
		
		driver.get(HomePage);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Hello");
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Helloworld");
		  Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("World");
	}
	
	@Test(enabled=false)
	@Parameters({"sUsername","sPassword"})
	public void testUserLoginParams(String sUserName,String sPassword){
		
		driver.get(HomePage);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(sUserName);
		
		driver.findElement(By.xpath(".//*[@id='pass']")).sendKeys(sPassword);
	}
	
	
	@Test(enabled=true)
	@Parameters({"sUsername","sPassword"})
	public void testUserLoginParamsUsinIdCss(String sUserName,String sPassword){
		
		driver.get(HomePage);
		driver.manage().window().maximize();
		//driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(sUserName);
		driver.findElement(By.id("email")).sendKeys(sUserName);
		driver.findElement(By.cssSelector("#pass")).sendKeys(sPassword);
	}

	  @Test(enabled=false)
	  @Parameters({"sFirstName","sLastName"})
	  public void testUserRegistration(String sFirstName, String sLastName) {
		driver.get(HomePage);
		driver.manage().window().maximize();
		  System.out.println(" The first Name " +sFirstName);
		  System.out.println("The Password "+sLastName);
	
		driver.findElement(By.name("firstname")).sendKeys(sFirstName);
		driver.findElement(By.name("lastname")).sendKeys(sLastName);
	    driver.findElement(By.name("reg_email__")).sendKeys("888-99-8888");
	   // driver.findElement(By.xpath("//button[contains(text(),'Sign Up')]")).click();
	    driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	}		
	    
	
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}