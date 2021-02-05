package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCustomerDataPage {
	
	public WebDriver driver;
	
	//constructor 
	public AddCustomerDataPage(WebDriver driver) {
		this.driver = driver;
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
		
		driver.findElement(addCustomerBtn).click();
		driver.findElement(custNameField).sendKeys(cusName);
		if(cusGender.equalsIgnoreCase("male")) {
			driver.findElement(genderMRadiobtn);
		}
		else if(cusGender.equalsIgnoreCase("female")) {
			driver.findElement(genderFRadioBtn);
		}
		else {
			System.out.println("Gender not provided");
		}
		driver.findElement(dobField).sendKeys(day);
		driver.findElement(dobField).sendKeys(month);
		driver.findElement(dobField).sendKeys(year);
		driver.findElement(addrField).sendKeys(address);
		driver.findElement(cityField).sendKeys(city);
		driver.findElement(stateField).sendKeys(state);
		driver.findElement(pinField).sendKeys(pin);
		driver.findElement(mobField).sendKeys(mobNo);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(pwdField).sendKeys(pwd);
		driver.findElement(submitbtn).click();
		Thread.sleep(4000);
		if(driver.findElement(msgSuccess).isDisplayed()) {
			return driver.findElement(msgSuccess).getText();
		}
		else {
			return null;
		}
	
	}

}
