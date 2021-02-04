package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC02_CustomerObjects {

	private WebDriver driver;
	
	//By Locators
	By addIcon = By.xpath("//*[@class='panel-heading col-xs-12']/div/div[1]");
	By approveSwitch = By.xpath("//*[@id='cgFrm_approved_layer']");
	By loginName = By.xpath("//*[@name='loginname']");
	By firstName = By.xpath("//*[@name='firstname']");
	By lastName = By.xpath("//*[@name='lastname']");
	By eMail = By.xpath("//*[@name='email']");
	By pass = By.xpath("//*[@name='password']");
	By cpass = By.xpath("//*[@name='password_confirm']");
	By saveBtn = By.xpath("//*[@class='btn btn-primary lock-on-click']");
	By txnTab = By.linkText("Transactions");
	By customersLink = By.xpath("//*[@id='menu_customer']");
	By deleteBtn = By.xpath("//*[@class='fa fa-trash-o fa-lg']");
	By cDltBtn = By.xpath("//*[@id='dData']");
	
	//Constructors
	public TC02_CustomerObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//PageActions
	public void clickAddBtn() {
		driver.findElement(addIcon).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void switchApproved() {
		driver.findElement(approveSwitch).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterLoginName(String lName) {
		driver.findElement(loginName).sendKeys(lName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterFirstName(String fName) {
		driver.findElement(firstName).sendKeys(fName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterLastName(String lsName) {
		driver.findElement(lastName).sendKeys(lsName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterEmail(String email) {
		driver.findElement(eMail).sendKeys(email);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword(String passwd) {
		driver.findElement(pass).sendKeys(passwd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void confirmPassword(String cpasswd) {
		driver.findElement(cpass).sendKeys(cpasswd);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSaveBtn() {
		driver.findElement(saveBtn).click();
	}

	public boolean isTxnTabVisible() {
		return driver.findElement(txnTab).isDisplayed();
	}
		
	public void clickCustomersLnk() {
		driver.findElement(customersLink).click();
	}
	
	public void deleteUser(String id) {
		driver.findElement(By.xpath("//*[@id='"+id+"']/td[10]/a[3]")).click();
	}
	
	public void confirmDelete() {
		driver.findElement(cDltBtn).click();
	}
}
