package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.inetBanking.base.BaseTest;

public class AddCustomeDataPageTest extends BaseTest {
	
	
	
	@Test
	public void verifyaddNewCustomerDatatest() throws InterruptedException {
		homePage = loginPage.doLogin(prop.getProperty("uname"),prop.getProperty("pwd"));
		addcustDataPage = homePage.clickAddNewCustomerButton();
		String actualMsg = addcustDataPage.addNewCustomer("Sumit","male","10","05","1998","Gandhi Nagar","Blr","KA","560102",
				"9821114112","sumsmart123@gmail.com","123456");
		Assert.assertEquals(actualMsg, "Customer Registered Successfully!!!");
	}
	
	

}
