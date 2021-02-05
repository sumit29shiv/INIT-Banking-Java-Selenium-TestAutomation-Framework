package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.base.BaseTest;
import com.inetBanking.utils.Excelutil;

public class LoginPageTestDDT extends BaseTest {
	
	@Test(dataProvider = "LoginData")
	public void verifyLoginDDTest(String uname, String pwd) throws InterruptedException {
		homePage = loginPage.doLogin(uname,pwd);
		if(loginPage.checkLoginPageAlertPresence()) {
			Thread.sleep(4000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		
		else {
			Assert.assertTrue(true);
			Thread.sleep(4000);
			homePage.doLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
	}
	
	@DataProvider(name="LoginData")
	public Object[][] getTestData() {
		
		String path = "./src/main/java/com/inetBanking/testData/MyLoginData.xlsx";
		Object[][] loginData = Excelutil.getTestData(path,"Sheet1");
		return loginData;
	}

}
