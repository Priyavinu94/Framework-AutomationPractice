package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class WomenPage extends TestBase{

	
	public WomenPage() {

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "h2.title_block")
	WebElement categoryTitle;
	
	@FindBy(xpath = "//a[@title='Add to cart' and @data-id-product='1']")
	WebElement firstProductAddToCartButton;
	
	@FindBy(css = "#layer_cart div.layer_cart_product h2")
	WebElement productAddedToCartMessage;
	
	@FindBy(css = "div.layer_cart_row span.ajax_block_cart_total")
	WebElement totalPrice;
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCheckoutButton;
	
	
	
	public String getCategoryTitle() {
		return categoryTitle.getText();
	}
	
	public void addFirstProductToCart() {
		firstProductAddToCartButton.click();
	}
	
	public String getAddedToCartMessage() {
		return productAddedToCartMessage.getText();
	}
	
	public String getTotalPrice() {
		return totalPrice.getText();
	}
	
	public OrderPage clickProceedToCheckOut() {
		proceedToCheckoutButton.click();
		return new OrderPage();
	}
	
}
