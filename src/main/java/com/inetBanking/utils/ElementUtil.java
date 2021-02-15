package com.inetBanking.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inetBanking.base.BaseTest;

public class ElementUtil extends BaseTest {

	private WebDriver driver; // declaring webdriver globally for the class
	
	
	public void hardSleep(int timeInMilliSec) {
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public ElementUtil(WebDriver driver) { // creating constr to get actual driver(any how)
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}


	public By getLocator(String value) {
		return By.id(value);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public WebElement getElement(By locator) {
		try {
			return driver.findElement(locator);
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}

	public void doSendKeys(By locator, String value) {
		doClear(locator);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		try {
			getElement(locator).click();
		}
		catch(ElementNotInteractableException e) {
			e.printStackTrace();
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	//***********************Alert Utils ***********************************
	
	public void switchToAlert() {
			
			driver.switchTo().alert();
			System.out.println("Switched to Alert successfully");

	
		}
	
	public void acceptAlert() {
		
		try {
			driver.switchTo().alert().accept();
			System.out.println("Alert accepted successfully");
		}
		catch(NoAlertPresentException e) {
			System.out.println("No alert Found");
			e.printStackTrace();
		}
		
	}
	
	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Alert dismissed successfully");
		}
		catch(NoAlertPresentException e) {
			System.out.println("No alert Found");
			e.printStackTrace();
		}
	}
	
	public String getAlertText() {
		try {
			System.out.println("Getting alert text..");
			return driver.switchTo().alert().getText();
			
		}
		catch(NoAlertPresentException e) {
			System.out.println("No alert Found");
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendValueToAlert(String value){
		
		try {
			driver.switchTo().alert().sendKeys(value);
			System.out.println("Value sent successfully");
		}
		catch(NoAlertPresentException e) {
			System.out.println("No alert Found");
			e.printStackTrace();
		}
		
	}
	
	//***********************Actions Utils ***********************************

	public void doActionsSendKeys(By locator, String value) {
		Actions action = new Actions(driver);
		action.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsClick(By locator) {
		Actions action = new Actions(driver);
		action.click(getElement(locator)).perform();
	}

	public void doSendKeysWithMoveToElement(By locator, String value) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).sendKeys(value).build().perform();
	}

	public void doClickWithMoveToElement(By locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(locator)).click().build().perform();
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public boolean doIsEnabled(By locator) {
		
		try {
			return getElement(locator).isEnabled();
		}
		catch (NoSuchElementException e) {
			System.out.println("Element not found.. "+locator);
			e.printStackTrace();
			return (Boolean) null;
		}
		catch(ElementNotVisibleException e){
			System.out.println("Element is not found.. "+locator);
			return (Boolean) null;
			
		}

		
	}

	public int getElementsCountUsingTagName(String tagName) {
		return driver.findElements(By.tagName(tagName)).size();
	}

	public List<String> getAttributeValueList(String tagName, String attributeName) {
		List<String> attrList = new ArrayList<String>();
		List<WebElement> elementList = driver.findElements(By.tagName(tagName));
		for (WebElement e : elementList) {
			String text = e.getAttribute(attributeName);
			attrList.add(text);
		}

		return attrList;
	}

	public void doClickFromList(By locator, String linkText) {
		List<WebElement> footerList = getElements(locator);
		for (int i = 0; i < footerList.size(); i++) {
			String text = footerList.get(i).getText();
			if (text.equals(linkText)) {
				footerList.get(i).click();
				break;
			}
		}
	}

	//***********************Drop Down Utils ***********************************

	public void doSelectDropDownByVisibleText(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);

	}

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	public void selectDropDownValueWithoutSelectClass(By locator, String value) {
		List<WebElement> optionsList = getElements(locator);

		for (WebElement e : optionsList) {

			String text = e.getText();

			if (text.equals(value)) {
				e.click();
				break;
			}

		}
	}

	// ***************************** wait utils ************************

	public List<WebElement> visibilityOfAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

//	public void getPageLinksText(By locator, int timeOut) {
//		visibilityOfAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
//	}

	public int getPageLinksCount(By locator, int timeOut) {
		return visibilityOfAllElements(locator, timeOut).size();
	}

	public String waitForTitlePresent(String titleValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public String waitForTitlePresent(String titleValue, int timeOut, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		wait.until(ExpectedConditions.titleIs(titleValue));
		return driver.getTitle();
	}

	public Alert waitForAlertToBePresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public boolean waitForUrl(String urlValue, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(urlValue));
	}

	public WebElement waitForElementToBeLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}

	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForElementWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This is custom dynamic wait to find the webelement
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement retryingElement(By locator) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < 30) {

			try {
				element = driver.findElement(locator);
				break;
			}

			catch (StaleElementReferenceException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

				}
			}

			catch (NoSuchElementException e) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

				}

				System.out.println("element is not found in attempt : " + (attempts + 1));
			}

			attempts++;
		}

		return element;

	}
	
	/**
	 * @author sumitshivhare
	 * This method will take the screenshot and return the path of screenshot
	 * @return It return path of screenshot
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots" + System.currentTimeMillis() +".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
			
		}
	
	
}
