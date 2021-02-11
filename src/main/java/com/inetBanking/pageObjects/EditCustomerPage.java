package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import com.inetBanking.utils.ElementUtil;

public class EditCustomerPage {
	
	WebDriver driver;
	ElementUtil eleUtil;
	
	//By locator
	By cusIdField = By.xpath("//input[@name='cusid']");
	By submitBtn = By.name("AccSubmit");
	
	//Constructor
	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
		
	}
	
	//page actions
	
	public boolean checkEditCustomerPageAlert() {
		try {
			eleUtil.switchToAlert();
			eleUtil.hardSleep(3000);
			return true;
		}
		catch (NoAlertPresentException e) {
			eleUtil.hardSleep(3000);
			return false;
		} 
		
	}
	
	public boolean editInvalidCustomerData(String cusId) {
		eleUtil.doSendKeys(cusIdField,cusId);
		eleUtil.hardSleep(3000);
		eleUtil.doClick(submitBtn);
		if(checkEditCustomerPageAlert()) {
			System.out.println(eleUtil.getAlertText());
			eleUtil.acceptAlert();
			return true;
		}
		else {
			return false;
		}
		
		
	}
}
