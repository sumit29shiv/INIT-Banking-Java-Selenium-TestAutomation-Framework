package com.inetBanking.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import com.inetBanking.base.BaseTest;
import com.inetBanking.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest() {
		logger.info("/n/nRunning testcase verifyLoginPageTitleTest");
		String actualTitle = loginPage.getLoginPageTitle();
		logger.info("Captured title: "+actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
		logger.info("Verified title with expected title..");
		
		
	}
	
	@Test(priority = 2)
	public void verifyLoginTest() {
		logger.info("Running testcase verifyLoginTest");
		homePage = loginPage.doLogin(prop.getProperty("uname"), prop.getProperty("pwd"));
	
		AssertJUnit.assertEquals(homePage.getHomePageTitle(),Constants.HOME_PAGE_TITLE);
	
	}

}
