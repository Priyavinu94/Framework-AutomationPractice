package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class OrderShippingPage extends TestBase{
	
	public OrderShippingPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "cgv")
	WebElement checkBox;
	
	@FindBy(css = "p.cart_navigation button")
	WebElement proceedToCheckOutButton;
	
	public void clickCheckBox() {
		if(!checkBox.isSelected()) {
			checkBox.click();
		}
	}
	
	public OrderPaymentSelectionPage proceedToCheckOut() {
		proceedToCheckOutButton.click();
		return new OrderPaymentSelectionPage();
	}
}
