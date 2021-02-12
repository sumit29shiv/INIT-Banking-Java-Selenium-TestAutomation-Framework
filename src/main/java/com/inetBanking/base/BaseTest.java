package com.inetBanking.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetBanking.pageObjects.AddCustomerDataPage;
import com.inetBanking.pageObjects.EditCustomerPage;
import com.inetBanking.pageObjects.HomePage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utils.ReadConfigProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	public static WebDriver driver;
	public static Logger logger;
	public  Properties prop;
	private ChromeOptions chromeOption;
	private FirefoxOptions firefoxOption;
	public LoginPage loginPage;
	public HomePage homePage;
	public AddCustomerDataPage addcustDataPage;
	public EditCustomerPage editCustPage;
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browser) {
		
		logger = Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("./src/main/java/com/inetBanking/configuration/log4j.properties");
		prop = ReadConfigProperties.ReadConfigPropertiesFile();
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			if(prop.getProperty("headless").trim().equals("true")) {
				System.out.println("Starting test in Headless mode..");
				chromeOption = new ChromeOptions();
				chromeOption.addArguments("--headless");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(chromeOption);
			}

			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			if(prop.getProperty("headless").trim().equals("true")) {
				firefoxOption = new FirefoxOptions();
				firefoxOption.addArguments("--headless");
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(firefoxOption);
			}

			else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else {
			System.out.println("Please provide correct browser.. "+browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseURL"));
		loginPage = new LoginPage(driver);
	
	
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
	
	/**
	 * @author sumitshivhare
	 * This method will take the screenshot and return the path of screenshot
	 * @return It return path of screenshot
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//String path = System.getProperty("user.dir") + "/screenshots" + System.currentTimeMillis() +".png";
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
			
		}
	
	
	

}
