package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.inetBanking.base.BaseTest;
import com.inetBanking.utils.Constants;

public class EditCustomerPageTest extends BaseTest {
	
	@BeforeClass
	public void setUpEditCustomerPageTest() {
		homePage = loginPage.doLogin(prop.getProperty("uname"),prop.getProperty("pwd"));
		editCustPage = homePage.navigateToEditCustomerPage();
		
		
	}
	@Test
	public void verifyeditInvalidCustomerDataTest() {
		boolean flag =  editCustPage.editInvalidCustomerData(Constants.INVALID_CUST_ID);
		Assert.assertFalse(flag);
		
		
	}

}
