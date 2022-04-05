package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class LoginPage extends TestBase {

	public LoginPage() {

		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	
	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "passwd")
	WebElement passwordInput;
	
	@FindBy(id= "SubmitLogin")
	WebElement signInButton;
	
	public void enterEmailId(String email) {
		Utils.sendData(emailInput, email);
	}
	
	public void enterPassword(String password) {
		Utils.sendData(passwordInput, password);
	}
	
	public MyAccountPage clickSignInButton() {
		Utils.clickOnElement(signInButton, 10);
		return new MyAccountPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public MyAccountPage loginToMyAccount(String email, String password) {
		Utils.sendData(emailInput, email);
		Utils.sendData(passwordInput, password);
		Utils.clickOnElement(signInButton, 10);
		return new MyAccountPage();
	}
}
