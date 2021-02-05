package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//definig By locators
	private By unameField = By.xpath("//input[@name='uid']");
	private By pwdField = By.xpath("//input[@name='password']");
	private By lgnBtn = By.xpath("//input[@name='btnLogin']");
	
	
	//Page actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage doLogin(String uname, String pwd) {
		driver.findElement(unameField).clear();
		driver.findElement(unameField).sendKeys(uname);
		driver.findElement(pwdField).clear();
		driver.findElement(pwdField).sendKeys(pwd);
		driver.findElement(lgnBtn).click();
		return new HomePage(driver);
	}
	
	public boolean checkLoginPageAlertPresence() throws InterruptedException {
		try {
			driver.switchTo().alert();
			Thread.sleep(4000);
			return true;
		}
		
		catch( NoAlertPresentException e) {
			Thread.sleep(4000);
			return false;
		}
		
		
		
	}
	

}
