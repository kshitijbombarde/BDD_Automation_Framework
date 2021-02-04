package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC00_DashboardObjects {

private WebDriver driver;
	
	//By Locators
	private By customers = By.xpath("//*[@class='panel-body']//div[5]");
	
	//Constructors
	public TC00_DashboardObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//PageActions
	public TC02_CustomerObjects clickCustomers() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(customers).click();
		return new TC02_CustomerObjects(driver);
	}
	
}
