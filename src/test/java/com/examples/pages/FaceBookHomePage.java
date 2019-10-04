package com.examples.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FaceBookHomePage {
	
	WebDriver driver;
	
	public FaceBookHomePage(WebDriver driver){

        this.driver = driver;

    }
	
	public void launchHomePage(String HomePage){
		driver.get(HomePage);
		driver.manage().window().maximize();
	}
	
	public void loginToFaceBook(String UserName,String PassWord) {
		driver.findElement(By.id("email")).sendKeys(UserName);
		driver.findElement(By.id("pass")).sendKeys(PassWord);
		//driver.findElement(By.xpath(".//input[@name='pass']")).sendKeys(PassWord);
		//driver.findElement(By.name("email")).sendKeys(UserName);
	}
	
	//Get the title of Login Page

    public String getLoginTitle(){
    	
     return    driver.getTitle();
    }

    
}
