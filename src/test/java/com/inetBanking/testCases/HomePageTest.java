package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.inetBanking.base.BaseTest;
import com.inetBanking.utils.Constants;

public class HomePageTest extends BaseTest {
	
	SoftAssert softAssert = new SoftAssert(); 
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("uname"),prop.getProperty("pwd"));
	}
	
	@Test
	public void verifyHeaderText() {
		String actualText = homePage.getHomePageHeaderText();
		softAssert.assertEquals(actualText, Constants.HOME_PAGE_HEADER_TEXT);
		softAssert.assertAll();
		
	}
	

}
