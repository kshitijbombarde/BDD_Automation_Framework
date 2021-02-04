package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC01_LoginObjects {

	private WebDriver driver;
	
	//By Locators
		private By username = By.xpath("//*[@id='loginFrm_username']");
		private By password = By.xpath("//*[@id='loginFrm_password']");
		private By loginBtn = By.cssSelector("#loginFrm > div:nth-child(3) > button");
		private By adminBtn = By.xpath("//*[text()='admin']");
		private By logoutBtn = By.xpath("//*[text()='Logout']");
		
	//Constructors
		public TC01_LoginObjects(WebDriver driver) {
			this.driver = driver;
		}
		
	//Page Actions
		public void enterUsername(String userid) {
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys(userid);
		}
		
		public void enterPasswd(String passwd) {
			driver.findElement(password).clear();
			driver.findElement(password).sendKeys(passwd);
		}
		
		public void clickLoginBtn() {
			driver.findElement(loginBtn).click();
		}
		
		public void clickAdminCaret() {
			driver.findElement(adminBtn).click();
		}
		
		public void clickLogoutBtn() {
			driver.findElement(logoutBtn).click();
		}
		
		public TC00_DashboardObjects doLogin(String userid, String passwd) {
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys(userid);
			driver.findElement(password).clear();
			driver.findElement(password).sendKeys(passwd);
			driver.findElement(loginBtn).click();
			return new TC00_DashboardObjects(driver);
		}
}
