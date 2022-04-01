package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class MyStorePaymentPage extends TestBase{

	public MyStorePaymentPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "page-subheading")
	WebElement paymentPageSubheading;
	
	@FindBy(css = "#cart_navigation .button")
	WebElement confirmOrderButton;
	
	public String getSubheadingText() {
		return paymentPageSubheading.getText();
	}
	
	public OrderConfirmationPage confirmPurchaseOrder() {
		confirmOrderButton.click();
		return new OrderConfirmationPage();
	}
}
