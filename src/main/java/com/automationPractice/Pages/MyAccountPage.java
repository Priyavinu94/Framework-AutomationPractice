package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {

		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}

	@FindBy(className = "account")
	WebElement userFullname;
	
	@FindBy(xpath = "//a[@title='Women']")
	WebElement womenCategory;
	
	@FindBy(className = "info-account")
	WebElement welcomeMessage;
	
	public String getUserFullName() {
		return Utils.getTextFromElement(userFullname, 10);
	}
	
	public String getWelcomeMessage() {
		return Utils.getTextFromElement(welcomeMessage, 10);
	}
	
	public WomenPage clickWomenCategory() {
		Utils.clickOnElement(womenCategory, 10);
		return new WomenPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
