package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC03_ContactPage {

	public WebDriver driver;
	
	//By Locators
	By firstName = By.id("ContactUsFrm_first_name");
	By eMail = By.id("ContactUsFrm_email");
	By enQuery = By.id("ContactUsFrm_enquiry"); 
	By submitBtn = By.xpath("//*[@class='btn btn-primary lock-on-click']");
	By successMsg = By.xpath("//*[text()='Your enquiry has been successfully sent to the store owner!']");
	
	//Constructors
	public TC03_ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Page Actions
	public void setName(String name) {
		driver.findElement(firstName).sendKeys(name);
	}
	
	public void setEmail(String email) {
		driver.findElement(eMail).sendKeys(email);
	}
	
	public void setEnquiry(String message) {
		driver.findElement(enQuery).sendKeys(message);
	}
	
	public void clickSubmit() {
		driver.findElement(submitBtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
