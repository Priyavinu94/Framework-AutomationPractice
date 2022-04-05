package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class MyStorePaymentPage extends TestBase{

	public MyStorePaymentPage() {
		
		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	@FindBy(className = "page-subheading")
	WebElement paymentPageSubheading;
	
	@FindBy(css = "#cart_navigation .button")
	WebElement confirmOrderButton;
	
	public String getSubheadingText() {
		return Utils.getTextFromElement(confirmOrderButton, 10);
	}
	
	public OrderConfirmationPage confirmPurchaseOrder() {
		Utils.clickOnElement(confirmOrderButton, 10);
		return new OrderConfirmationPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
