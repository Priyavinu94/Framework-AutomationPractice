package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class OrderConfirmationPage extends TestBase {
	
	public OrderConfirmationPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "cheque-indent")
	WebElement confirmationMessage;
	
	public String getOrderConfirmation() {
		return confirmationMessage.getText();
	}

}
