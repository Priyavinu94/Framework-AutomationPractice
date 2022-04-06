package com.automationPractice.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
	SoftAssert sf;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		sf = new SoftAssert();
		homePage = new HomePage();
		loginPage = homePage.clickSignInButton();
	}

	@Test
	public void verifyUserCanComlpeteOrder() {

		// navigating to my account page
		myAccountPage = loginPage.loginToMyAccount(prop.getProperty("userEmail"), prop.getProperty("userPassword"));

		// navigates to women category and asserting
		womenPage = myAccountPage.clickWomenCategory();

		// select product
		womenPage.selectProductAndAddToCart(prop.getProperty("productQuantity"),
				prop.getProperty("productSize"));
		womenPage.switchToParentPage();
		orderPage = womenPage.clickProceedToCheckOut();
		

		// navigates to address details page, enter order message
		addressPage = orderPage.proceedToCheckOut();
		addressPage.enterOrderMessage(prop.getProperty("orderMessage"));

		// navigates to shipping details, click on the check box
		shippingPage = addressPage.proceedToCheckOut();
		shippingPage.clickCheckBox();

		// selecting payment method and navigating to confirm payment & checkout
		paymentPage = shippingPage.proceedToCheckOut();
		payConfirmationPage = paymentPage.selectPayByBank();

		// click on final checkout to navigate to order confirmation page
		orderConfirmationPage = payConfirmationPage.confirmPurchaseOrder();
		Assert.assertEquals(orderConfirmationPage.getOrderConfirmation(), prop.getProperty("orderConfirmationText"),
				"Order confirmation message not received as expected");

	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
