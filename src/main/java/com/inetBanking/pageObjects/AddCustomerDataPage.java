package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.inetBanking.utils.ElementUtil;

public class AddCustomerDataPage {
	
	ElementUtil eleUtil;
	
	public WebDriver driver;
	
	//constructor 
	public AddCustomerDataPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(this.driver);
	}
	
	//By locators
	By addCustomerBtn = By.xpath("//a[text()='New Customer']");
	By custNameField = By.xpath("//input[@name='name']");
	By genderMRadiobtn = By.xpath("//input[@value='m']");
	By genderFRadioBtn = By.xpath("//input[@value='f']");
	By dobField = By.id("dob");
	By addrField = By.xpath("//textarea[@name='addr']");
	By cityField = By.xpath("//input[@name='city']");
	By stateField =  By.xpath("//input[@name='state']");
	By pinField = By.xpath("//input[@name='pinno']");
	By mobField = By.xpath("//input[@name='telephoneno']");
	By emailField = By.xpath("//input[@name='emailid']");
	By pwdField = By.xpath("//input[@name='password']");
	By submitbtn = By.xpath("//input[@name='sub']");
	By msgSuccess = By.xpath("//p[@class='heading3']");
	
	
	public String addNewCustomer(String cusName,String cusGender,String day, String month, String year
			,String address,String city,String state,String pin,String mobNo,String email,String pwd ) throws InterruptedException {
		
		eleUtil.doClick(addCustomerBtn);
		driver.findElement(custNameField).sendKeys(cusName);
		eleUtil.doSendKeys(custNameField, cusName);
		if(cusGender.equalsIgnoreCase("male")) {
			eleUtil.doClick(genderMRadiobtn);
		}
		else if(cusGender.equalsIgnoreCase("female")) {
			eleUtil.doClick(genderFRadioBtn);
		}
		else {
			System.out.println("Gender not provided");
		}
		eleUtil.doSendKeys(dobField, day);
		eleUtil.doSendKeys(dobField, month);
		eleUtil.doSendKeys(dobField, year);
		eleUtil.doSendKeys(addrField, address);
		eleUtil.doSendKeys(cityField, city);
		eleUtil.doSendKeys(stateField, state);
		eleUtil.doSendKeys(pinField, pin);
		eleUtil.doSendKeys(mobField, mobNo);
		eleUtil.doSendKeys(emailField, email);
		eleUtil.doSendKeys(pwdField, pwd);
		eleUtil.doClick(submitbtn);
		Thread.sleep(4000);
		if(eleUtil.doIsDisplayed(msgSuccess)) {
			return eleUtil.doGetText(msgSuccess);
		}
		else {
			return null;
		}
	
	}

}
