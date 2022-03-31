package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class MyAccountPage extends TestBase{
	
	public MyAccountPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "account")
	WebElement userFullname;
	
	@FindBy(xpath = "//a[@title='Women']")
	WebElement womenCategory;
	
	@FindBy(className = "info-account")
	WebElement welcomeMessage;
	
	public String getUserFullName() {
		return userFullname.getText();
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage.getText();
	}
	
	public WomenPage clickWomenCategory() {
		womenCategory.click();
		return new WomenPage();
	}
	
}
