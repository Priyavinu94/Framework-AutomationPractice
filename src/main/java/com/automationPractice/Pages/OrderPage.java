package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class OrderPage extends TestBase {
	
	public OrderPage() {

		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	@FindBy(xpath="//table[@id='cart_summary']//tbody//tr[1]//td//a[@title='Delete']")
	WebElement productDeleteButton;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(id = "cart_title")
	WebElement cartTitle;
	
	@FindBy(className = "alert")
	WebElement shoppingCartEmptyAlert;
	
	@FindBy(css = "p.cart_navigation a:first-child")
	WebElement proceedToCheckOutButton;
	
	public String getCartTitle() {
		return Utils.getTextFromElement(cartTitle, 10);
	}
	
	public String getTotalPrice() {
		return Utils.getTextFromElement(totalPrice, 10);
	}
	
	public OrderPage deleteProductFromCart() {
		Utils.clickOnElement(productDeleteButton, 10);
		return new OrderPage();
	}
	
	public String getAlertMessage() {
		return Utils.getTextFromElement(shoppingCartEmptyAlert, 10);
	}
	
	public OrderAddressPage proceedToCheckOut() {
		Utils.clickOnElement(proceedToCheckOutButton, 10);
		return new OrderAddressPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
