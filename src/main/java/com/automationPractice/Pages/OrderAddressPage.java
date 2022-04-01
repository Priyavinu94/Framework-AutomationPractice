package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class OrderAddressPage extends TestBase {

	public OrderAddressPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#ordermsg textarea")
	WebElement orderMessageBox;
	
	@FindBy(css = "p.cart_navigation button")
	WebElement proceedToCheckOutButton;
	
	public void enterOrderMessage(String message) {
		orderMessageBox.sendKeys(message);
	}
	
	public OrderShippingPage proceedToCheckOut() {
		proceedToCheckOutButton.click();
		return new OrderShippingPage();
	}
}
