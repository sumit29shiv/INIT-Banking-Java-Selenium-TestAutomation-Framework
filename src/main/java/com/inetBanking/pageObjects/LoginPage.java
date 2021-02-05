package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.inetBanking.utils.ElementUtil;


public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//definig By locators
	private By unameField = By.xpath("//input[@name='uid']");
	private By pwdField = By.xpath("//input[@name='password']");
	private By lgnBtn = By.xpath("//input[@name='btnLogin']");
	
	
	//Page actions
	public String getLoginPageTitle() {
		return eleUtil.getPageTitle();
	}
	
	public HomePage doLogin(String uname, String pwd) {
		eleUtil.doClear(unameField);
		eleUtil.doSendKeys(unameField, uname);
		eleUtil.doClear(pwdField);
		eleUtil.doSendKeys(pwdField, pwd);
		eleUtil.doClick(lgnBtn);
		return new HomePage(driver);
	}
	
	public boolean checkLoginPageAlertPresence() throws InterruptedException {
		try {
			eleUtil.switchToAlert();
			eleUtil.hardSleep(3000);
			return true;
		}
		
		catch( NoAlertPresentException e) {
			eleUtil.hardSleep(3000);;
			return false;
		}
		
		
		
	}
	

}
