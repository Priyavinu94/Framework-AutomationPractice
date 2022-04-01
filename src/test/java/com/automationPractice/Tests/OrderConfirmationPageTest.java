package com.automationPractice.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;
import com.automationPractice.Pages.MyStorePaymentPage;
import com.automationPractice.Pages.OrderAddressPage;
import com.automationPractice.Pages.OrderConfirmationPage;
import com.automationPractice.Pages.OrderPage;
import com.automationPractice.Pages.OrderPaymentSelectionPage;
import com.automationPractice.Pages.OrderShippingPage;
import com.automationPractice.Pages.WomenPage;

public class OrderConfirmationPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	WomenPage womenPage;
	OrderPage orderPage;
	OrderAddressPage addressPage;
	OrderShippingPage shippingPage;
	OrderPaymentSelectionPage paymentPage;
	MyStorePaymentPage payConfirmationPage;
	OrderConfirmationPage orderConfirmationPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}

	@Test
	public void verifyUserCanComlpeteOrder() {

		//navigating to login page
		loginPage = homePage.clickSignInButton();

		loginPage.enterEmailId(prop.getProperty("userEmail"));
		loginPage.enterPassword(prop.getProperty("userPassword"));

		//navigating to my account page and asserting
		myAccountPage = loginPage.clickSignInButton();

		String customerFullname = myAccountPage.getUserFullName();
		String welcomeText = myAccountPage.getWelcomeMessage();

		Assert.assertEquals(customerFullname, prop.getProperty("userFullname"));
		Assert.assertEquals(welcomeText, prop.getProperty("welcomeText"));
		
		// navigates to women category and asserting
		womenPage = myAccountPage.clickWomenCategory();
		Assert.assertEquals(womenPage.getCategoryTitle(), prop.getProperty("category"));

		// select product
		womenPage.clickOnProduct();
		womenPage.switchToIframe();
		womenPage.selectProductQuantityInIFrame(prop.getProperty("productQuantity"));
		womenPage.selectProductSizeInIframe(prop.getProperty("productSize"));

		String productNameDisplay = womenPage.getProductNameFromIframe();

		womenPage.productIframeAddtoCart();
		womenPage.switchToParentPage();

		try {
			Thread.sleep(4000); // Thread to pause until all texts are displayed in the browser
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Asserting cart details with previous page
		Assert.assertEquals(womenPage.getAddedToCartMessage(), prop.getProperty("AddedToCartMessage"));
		Assert.assertEquals(womenPage.getProductTitleInCart(), productNameDisplay);
		Assert.assertEquals(womenPage.getProductQuantityInCart(), prop.getProperty("productQuantity"));

		String totalPriceInCart = womenPage.getTotalPrice();

		// navigates to order summary page, asserting total price with previous page
		orderPage = womenPage.clickProceedToCheckOut();
		Assert.assertEquals(orderPage.getTotalPrice(), totalPriceInCart);

		// navigates to address details page, enter order message
		addressPage = orderPage.proceedToCheckOut();
		addressPage.enterOrderMessage(prop.getProperty("orderMessage"));

		// navigates to shipping details, click on the check box
		shippingPage = addressPage.proceedToCheckOut();
		shippingPage.clickCheckBox();

		// selecting payment method and navigating to confirm payment & checkout
		paymentPage = shippingPage.proceedToCheckOut();
		payConfirmationPage = paymentPage.selectPayByBank();
		Assert.assertEquals(payConfirmationPage.getSubheadingText(), prop.getProperty("paymentMethodConfirmationText"));

		// click on final checkout to navigate to order confirmation page
		orderConfirmationPage = payConfirmationPage.confirmPurchaseOrder();
		Assert.assertEquals(orderConfirmationPage.getOrderConfirmation(), prop.getProperty("orderConfirmationText"));

	}
	
	public void closeBrowser() {
		tearDown();
	}
}
