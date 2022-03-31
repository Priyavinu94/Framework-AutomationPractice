package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "login")
	WebElement signInButton;
	
	public LoginPage clickSignInButton() {
		signInButton.click();
		return new LoginPage();
	}
}
