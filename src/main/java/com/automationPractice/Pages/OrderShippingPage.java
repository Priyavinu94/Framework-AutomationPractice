package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class OrderShippingPage extends TestBase{
	
	public OrderShippingPage() {
		
		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	@FindBy(id = "cgv")
	WebElement checkBox;
	
	@FindBy(css = "p.cart_navigation button")
	WebElement proceedToCheckOutButton;
	
	public void clickCheckBox() {
		Utils.clickOnCheckBox(checkBox, 10);
	}
	
	public OrderPaymentSelectionPage proceedToCheckOut() {
		Utils.clickOnCheckBox(checkBox, 10);
		return new OrderPaymentSelectionPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
