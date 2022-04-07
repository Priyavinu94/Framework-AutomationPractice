package com.automationPractice.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automationPractice.BasePackage.TestBase;

public class Utils extends TestBase {

//	public static int IMPLICIT_WAIT = 10;
//	public static int PAGE_LOAD_TIMEOUT = 30;

	/**
	 * Pauses the execution of the script for the specified amount of time
	 * 
	 * @param timeOutInMilliSec
	 */
	public static void staticWait(long timeOutInMilliSec) {
		try {
			Thread.sleep(timeOutInMilliSec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create random email starting with suffix '@gmail.com'
	 * 
	 * @return a random String(email id)
	 */
	public static String generateRandomEmail() {
		String email = RandomStringUtils.randomNumeric(8);
		String emailID = email + "@gmail.com";
		return emailID;
	}

	/**
	 * Create random password starting with prefix 'user'
	 * 
	 * @return a random String(password)
	 */
	public static String generateRandomPassword() {
		String randomStringForPassword = RandomStringUtils.randomNumeric(4);
		String password = "user" + randomStringForPassword;
		return password;
	}
	
	/**
	 * Create random name
	 * 
	 * @param letterCount number of letters to be present in the name
	 * @return a random String
	 */
	public static String generateRandomName(int letterCount) {
		return RandomStringUtils.randomAlphabetic(letterCount);
	}
	
	/**
	 * Create random phone number
	 * 
	 * @param digitCount number of digits to be in the phone no
	 * @return a random String of numeric
	 */
	public static String generateRandomPhoneNo(int digitCount) {
		return RandomStringUtils.randomNumeric(10);
	}

	/**
	 * Takes the screenshot of a failed test case
	 * 
	 * @param nameOfTestCase the name of failed test case
	 */
	public static void takeScreenShotOfFailedTestCase(String nameOfTestCase) {

		// Format the current time in my system
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		// Capturing the screen shot
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// copying file
		try {
			FileUtils.copyFile(file,
					new File("./FailedScreenShot\\" + "_" + nameOfTestCase + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Click on a WebElement using JavaScriptExecutor
	 * 
	 * @param element The target WebElement to be clicked
	 */
	public static void javascriptClick(WebElement element) {
		jse.executeScript("arguments[0].click();", element);
	}

	/**
	 * Scroll through the web page until the WebElement is in the view port
	 * 
	 * @param element The target WebElement to be interacted with
	 */
	public static void scrollIntoViewUsingJavaScript(WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Apply explicit wait on a WebElement with an expected condition of being
	 * clickable
	 * 
	 * @param element      The target WebElement to be clicked
	 * @param timeOutInSec The maximum time to wait for the WebElement to meet the
	 *                     expected condition
	 * @return The same WebElement on which click action to be performed
	 */
	public static WebElement waitForElementToBeClickable(WebElement element, int timeOutInSec) {
		return new WebDriverWait(driver, timeOutInSec).until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Click on a WebElement upon which explicit wait condition to be clickable has
	 * been applied
	 * 
	 * @param element      the target WebElement to be clicked
	 * @param timeOutInSec the maximum time to wait for the WebElement to be in
	 *                     clickable state
	 */
	public static void clickOnElement(WebElement element, int timeOutInSec) {
		try {
			waitForElementToBeClickable(element, timeOutInSec).click();
		} catch (TimeoutException e) {
			System.out.println("Element " + element + " is not visible");
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			System.out.println("Not able to find such element : " + element);
			e.printStackTrace();
		}
	}

	/**
	 * Apply explicit wait on a WebElement with an expected condition of being
	 * visible
	 * 
	 * @param element      The target WebElement to be interacted with
	 * @param timeOutInSec The maximum time to wait for the WebElement to meet the
	 *                     expected condition
	 * @return The same WebElement on which Script needs to be interacted
	 */
	public static WebElement waitForElementToBeVisible(WebElement element, int timeOutInSec) {
		return new WebDriverWait(driver, timeOutInSec).until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Apply explicit wait on a WebElement with an expected condition of being not
	 * in a selected state
	 * 
	 * @param element      The target WebElement to be selected
	 * @param timeOutInSec The maximum time to wait for the WebElement to meet the
	 *                     expected condition
	 * @return The same WebElement to be selected
	 */
	public static boolean waitForElementToBeSelectable(WebElement element, int timeOutInSec) {
		return new WebDriverWait(driver, timeOutInSec)
				.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}

	/**
	 * Select an option from the drop down WebElement by index
	 * 
	 * @param element The WebElement with SELECT tag name
	 * @param index   The index of the option which needs to be selected. This is
	 *                the value of "index" attribute of the WebElement
	 */
	public static void selectFromDropDownByIndex(WebElement element, int index) {
		try {
			if (waitForElementToBeSelectable(element, 5)) {
				new Select(element).selectByIndex(index);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Select an option from the drop down WebElement by Visible text or Value
	 * 
	 * @param element            The WebElement with SELECT tag name
	 * @param visibleTextOrValue The visible text or the value of the option which
	 *                           needs to be selected. This is the value of "index"
	 *                           attribute of the WebElement
	 */
	public static void selectFromDropDownByVisibleTextOrValue(WebElement element, String visibleTextOrValue) {
		try {
			if (waitForElementToBeSelectable(element, 5)) {
				new Select(element).selectByVisibleText(visibleTextOrValue);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Move the mouse to WebElement after applying explicit wait for the element to
	 * be visible
	 * 
	 * @param element the target WebElement to move to
	 */
	public static void moveToElement(WebElement element) {
		try {
			new Actions(driver).moveToElement(waitForElementToBeVisible(element, 5)).build().perform();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Apply explicit wait for an Alert to be present
	 * 
	 * @param timeOutInSeconds the maximum time to wait for an Alert to be present
	 */
	public static Alert waitForAlertToBePresent(int timeOutInSeconds) {
		return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * Switch to and accept an Alert after applying explicit wait for it to be
	 * present
	 */
	public static void acceptAlert() {
		if (waitForAlertToBePresent(5) != null) {
			driver.switchTo().alert().accept();
		}
	}

	/**
	 * Switch to and dismiss an Alert after applying explicit wait for it to be
	 * present
	 */
	public static void dismissAlert() {
		if (waitForAlertToBePresent(5) != null) {
			driver.switchTo().alert().dismiss();
		}
	}

	/**
	 * Wait for a WebElement to be visible and clear the input area if this is a
	 * text entry element with tag INPUT or TEXT AREA
	 * 
	 * @param element text entry WebElement
	 */
	public static void clearInputArea(WebElement element) {
		waitForElementToBeVisible(element, 10).clear();
	}

	/**
	 * Wait for a WebElement to be visible and enable to provide input text for an
	 * element with tag INPUT or TEXT AREA
	 * 
	 * @param element text entry WebElement
	 * @param text    character sequence to send to the element
	 */
	public static void sendData(WebElement element, String text) {
		waitForElementToBeVisible(element, 10).sendKeys(text);
	}

	/**
	 * Switch to new Window by finding its unique ID(handle)
	 * 
	 * @param element The WebElement on which the action performed opens a new
	 *                Window
	 */
	public static void switchToWindow(WebElement element) {
		String parentHandle = driver.getWindowHandle();
		clickOnElement(element, 10);
		Set<String> getAllHandles = driver.getWindowHandles();
		for (String handle : getAllHandles) {
			if (!handle.equalsIgnoreCase(parentHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}

	/**
	 * Waits for the frame element to be visible and switches into frame
	 * 
	 * @param element The frame element to switch into from the current web page
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(waitForElementToBeVisible(element, 10));
		} catch (NoSuchFrameException e) {
			System.out.println("No Frame located");
			e.printStackTrace();
		}
	}

	/**
	 * Waits for the WebElement to be visible and get the visible text of the
	 * element
	 * 
	 * @param element      The WebElement whose visible text(content) needs to be
	 *                     retrieved
	 * @param timeOutInSec The maximum time to wait for the WebElement to be visible
	 * @return The visible text of the element
	 */
	public static String getTextFromElement(WebElement element, int timeOutInSec) {
		return waitForElementToBeVisible(element, timeOutInSec).getText();
	}

	/**
	 * Waits for the check box element to be in selectable state
	 * 
	 * @param element          The check box element which needs to be checked
	 * @param timeOutInSeconds The maximum time to wait for the element to be
	 *                         selectable
	 */
	public static void clickOnCheckBox(WebElement element, int timeOutInSeconds) {
		try {
			if (waitForElementToBeSelectable(element, timeOutInSeconds)) {
				element.click();
			}
		} catch (NoSuchElementException e) {
			System.out.println("No check box element found");
			e.printStackTrace();
		}
	}

}
