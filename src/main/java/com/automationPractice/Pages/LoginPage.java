package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "passwd")
	WebElement passwordInput;
	
	@FindBy(id= "SubmitLogin")
	WebElement signInButton;
	
	public void enterEmailId(String email) {
		emailInput.sendKeys(email); 
	}
	
	public void enterPassword(String password) {
		passwordInput.sendKeys(password); 
	}
	
	public MyAccountPage clickSignInButton() {
		signInButton.click();
		return new MyAccountPage();
	}
	
	public MyAccountPage loginToMyAccount(String email, String password) {
		emailInput.sendKeys(email); 
		passwordInput.sendKeys(password); 
		signInButton.click();
		return new MyAccountPage();
	}
}
