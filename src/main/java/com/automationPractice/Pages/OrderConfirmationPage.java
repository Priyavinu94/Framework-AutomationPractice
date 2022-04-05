package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class OrderConfirmationPage extends TestBase {
	
	public OrderConfirmationPage() {
		
		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	@FindBy(className = "cheque-indent")
	WebElement confirmationMessage;
	
	public String getOrderConfirmation() {
		return Utils.getTextFromElement(confirmationMessage, 10);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
