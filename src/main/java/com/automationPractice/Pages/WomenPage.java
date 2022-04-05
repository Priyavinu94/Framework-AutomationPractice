package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class WomenPage extends TestBase {

	public WomenPage() {

		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
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
		return Utils.getTextFromElement(categoryTitle, 10);
	}

	public void clickOnProduct() {
		Utils.clickOnElement(firstProductQuickView, 10);
	}

	public void switchToIframe() {
		Utils.switchToFrame(firstProductIframe);
	}

	public void selectProductQuantityInIFrame(String quantity) {
		Utils.clearInputArea(quantityInput);
		Utils.sendData(quantityInput, quantity);
	}

	public void selectProductSizeInIframe(String size) {
		Utils.selectFromDropDownByVisibleTextOrValue(sizeSelectionBox, size);
	}

	public String getProductNameFromIframe() {
		return Utils.getTextFromElement(productNameDisplayIframe, 10);
	}

	public void productIframeAddtoCart() {
		Utils.clickOnElement(iframeAddToCartButton, 10);
	}

	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}

	public String getAddedToCartMessage() {
		return Utils.getTextFromElement(productAddedToCartMessage, 10);
	}

	public String getProductQuantityInCart() {
		return Utils.getTextFromElement(prodQuantityCart, 10);
	}

	public String getProductTitleInCart() {
		return Utils.getTextFromElement(productTitleCart, 10);
	}

	public String getTotalPrice() {
		return Utils.getTextFromElement(totalPrice, 10);
	}

	public OrderPage clickProceedToCheckOut() {
		Utils.clickOnElement(proceedToCheckoutButton, 10);
		return new OrderPage();
	}

	public void selectProductAndAddToCart(String quantity, String size) {
		
		Utils.clickOnElement(firstProductQuickView, 10);
		Utils.switchToFrame(firstProductIframe);
		Utils.clearInputArea(quantityInput);
		Utils.sendData(quantityInput, quantity);
		Utils.selectFromDropDownByVisibleTextOrValue(sizeSelectionBox, size);
		Utils.clickOnElement(iframeAddToCartButton, 10);
		
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

}
