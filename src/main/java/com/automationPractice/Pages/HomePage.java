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
	
	@FindBy(className = "logo")
	WebElement homePageLogo;
	
	@FindBy(id="search_query_top")
	WebElement searchProductField;
	
	@FindBy(name="submit_search")
	WebElement searchButton;
	
	public LoginPage clickSignInButton() {
		Utils.clickOnElement(signInButton, 10);
		return new LoginPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isLogoDisplayed() {
		return Utils.waitForElementToBeVisible(homePageLogo, 10).isDisplayed();
	}
	
	public SearchResultPage searchProduct(String productName) {
		Utils.sendData(searchProductField, productName);
		Utils.scrollIntoViewUsingJavaScript(searchProductField);
		Utils.clickOnElement(searchButton, 10);
		return new SearchResultPage();
	}
}
