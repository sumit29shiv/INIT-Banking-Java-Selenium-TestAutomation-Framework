package com.inetBanking.testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import com.inetBanking.base.BaseTest;
import com.inetBanking.utils.Constants;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority = 0)
	public void verifyLoginPageTitleTest() {
		logger.info("Running testcase verifyLoginPageTitleTest");
		String actualTitle = loginPage.getLoginPageTitle();
		logger.info("Captured title: "+actualTitle);
		Assert.assertEquals(actualTitle, Constants.LOGIN_PAGE_TITLE);
		logger.info("Verified title with expected title..");
		
		
	}
	
	@Test(priority = 3)
	public void verifyLoginTest() {
		logger.info("Running testcase verifyLoginTest");
		homePage = loginPage.doLogin(prop.getProperty("uname"), prop.getProperty("pwd"));
	
		Assert.assertEquals(homePage.getHomePageTitle(),Constants.HOME_PAGE_TITLE);
	
	}
	
	@Test(priority = 1)
	public void verifyLoginBtnVisibilityTest() {
		logger.info(addcustDataPage);
		Assert.assertEquals(loginPage.isLoginBtnVisible(), true);
	}
	
	
	@Test(priority = 2 )
	public void verifyResetBtnEnabledTest() {
		Assert.assertEquals(loginPage.isResetBtnEnabled(), true);
		
	}

}
