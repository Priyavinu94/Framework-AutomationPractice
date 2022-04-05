package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class OrderAddressPage extends TestBase {

	public OrderAddressPage() {
		
		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	@FindBy(css = "#ordermsg textarea")
	WebElement orderMessageBox;
	
	@FindBy(css = "p.cart_navigation button")
	WebElement proceedToCheckOutButton;
	
	public void enterOrderMessage(String message) {
		Utils.sendData(orderMessageBox, message);
	}
	
	public OrderShippingPage proceedToCheckOut() {
		Utils.clickOnElement(proceedToCheckOutButton, 10);
		return new OrderShippingPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
