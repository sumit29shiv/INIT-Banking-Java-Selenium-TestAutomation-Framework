package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.inetBanking.utils.ElementUtil;
import com.inetBanking.utils.JavaScriptUtil;


public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private JavaScriptUtil jsUtil;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		jsUtil = new JavaScriptUtil(this.driver);
	}
	
	//By locators
	By logOutBtn = By.linkText("Log out");
	By advertisementFrame = By.xpath("//iframe[@id='aswift_0']");
	By advertisementBtn = By.xpath("//div[@id='cbb']");
	By addCustomerBtn = By.xpath("//a[text()='New Customer']");
	
	
	
	//Page actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	


	public void doLogout() {
		jsUtil.scrollPageDown();
		//driver.switchTo().frame(driver.findElement(advertisementFrame));
		//driver.findElement(advertisementBtn).click();
		//HomePage..doClick(advertisementBtn);
		eleUtil.hardSleep(3000);
		//driver.findElement(logOutBtn);
		eleUtil.doClick(logOutBtn);
		eleUtil.hardSleep(3000);
		
	}
	
	
 public AddCustomerDataPage clickAddNewCustomerButton() {
		driver.findElement(addCustomerBtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new AddCustomerDataPage(driver);
	}
}

	
	
	
	
	
	
	
	
	
	
	

	
	
	
	


