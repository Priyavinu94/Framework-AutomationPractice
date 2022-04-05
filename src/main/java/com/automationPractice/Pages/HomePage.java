package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class HomePage extends TestBase {
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	@FindBy(className = "login")
	WebElement signInButton;
	
	public LoginPage clickSignInButton() {
		Utils.clickOnElement(signInButton, 10);
		return new LoginPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
