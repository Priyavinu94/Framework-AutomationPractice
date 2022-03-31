package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class OrderPage extends TestBase {
	
	public OrderPage() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table[@id='cart_summary']//tbody//tr[1]//td//a[@title='Delete']")
	WebElement productDeleteButton;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(id = "cart_title")
	WebElement cartTitle;
	
	@FindBy(className = "alert")
	WebElement shoppingCartEmptyAlert;
	
	public String getCartTitle() {
		return cartTitle.getText();
	}
	
	public String getTotalPrice() {
		return totalPrice.getText();
	}
	
	public OrderPage deleteProductFromCart() {
		productDeleteButton.click();
		return new OrderPage();
	}
	
	public String getAlertMessage() {
		return shoppingCartEmptyAlert.getText();
	}

}
