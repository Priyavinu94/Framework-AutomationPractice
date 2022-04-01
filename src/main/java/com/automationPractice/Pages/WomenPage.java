package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractice.BasePackage.TestBase;

public class WomenPage extends TestBase {

	public WomenPage() {

		PageFactory.initElements(driver, this);
	}

	Actions act = new Actions(driver);
	Select select;

	@FindBy(css = "h2.title_block")
	WebElement categoryTitle;

	@FindBy(xpath = "//a[@class='product_img_link' and @title='Faded Short Sleeve T-shirts']")
	WebElement firstProductQuickView;

	@FindBy(className = "fancybox-iframe")
	WebElement firstProductIframe; // iframe

	@FindBy(xpath = "//h1[@itemprop='name']")
	WebElement productNameDisplayIframe; // iframe

	@FindBy(css = "#quantity_wanted_p input.text")
	WebElement quantityInput; // iframe element

	@FindBy(id = "group_1")
	WebElement sizeSelectionBox; // iframe element

	@FindBy(id = "add_to_cart")
	WebElement iframeAddToCartButton;

	@FindBy(css = "#layer_cart div.layer_cart_product>h2")
	WebElement productAddedToCartMessage;

	@FindBy(id = "layer_cart_product_title")
	WebElement productTitleCart;
	
	@FindBy(id = "layer_cart_product_quantity")
	WebElement prodQuantityCart;

	@FindBy(css = "div.layer_cart_row span.ajax_block_cart_total")
	WebElement totalPrice;

	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	WebElement proceedToCheckoutButton;

	public String getCategoryTitle() {
		return categoryTitle.getText();
	}

	public void clickOnProduct() {
		firstProductQuickView.click();
	}

	public void switchToIframe() {
		driver.switchTo().frame(firstProductIframe);
	}

	public void selectProductQuantityInIFrame(String quantity) {
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
	}

	public void selectProductSizeInIframe(String size) {
		select = new Select(sizeSelectionBox);
		select.selectByVisibleText(size);
	}

	public String getProductNameFromIframe() {
		return productNameDisplayIframe.getText();
	}

	public void productIframeAddtoCart() {
		iframeAddToCartButton.click();
	}
	
	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}

	public String getAddedToCartMessage() {
		return productAddedToCartMessage.getText();
	}

	public String getProductQuantityInCart() {
		return prodQuantityCart.getText();
	}
	
	public String getProductTitleInCart() {
		return productTitleCart.getText();
	}

	public String getTotalPrice() {
		return totalPrice.getText();
	}

	public OrderPage clickProceedToCheckOut() {
		proceedToCheckoutButton.click();
		return new OrderPage();
	}

}
