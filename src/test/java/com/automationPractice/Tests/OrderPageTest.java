package com.automationPractice.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;
import com.automationPractice.Pages.OrderPage;
import com.automationPractice.Pages.WomenPage;
import com.automationPractice.util.UtilityClass;

public class OrderPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	WomenPage womenPage;
	OrderPage orderPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
		loginPage = homePage.clickSignInButton();
	}

	@Test
	public void verifyUserCanDeleteItemFromCart() {

		// Navigating to My Account Page
		myAccountPage = loginPage.loginToMyAccount(prop.getProperty("userEmail"), prop.getProperty("userPassword"));

		String customerFullname = myAccountPage.getUserFullName();
		String welcomeText = myAccountPage.getWelcomeMessage();

		// Login successful assertions:
		Assert.assertEquals(customerFullname, prop.getProperty("userFullname"), "Username does not match");
		Assert.assertEquals(welcomeText, prop.getProperty("welcomeText"), "Welcome text is not as expected");

		// Navigating to Women Page
		womenPage = myAccountPage.clickWomenCategory();
		Assert.assertEquals(womenPage.getCategoryTitle(), prop.getProperty("category"),
				"Category title for Women Page not as expected");

		womenPage.clickOnProduct();
		womenPage.switchToIframe();
		womenPage.productIframeAddtoCart();
		womenPage.switchToParentPage();

		UtilityClass.staticWait(5000);
		String totalPriceWomenPage = womenPage.getTotalPrice();
		Assert.assertEquals(womenPage.getAddedToCartMessage(), prop.getProperty("AddedToCartMessage"),
				"Added to cart message is not as expected");

		orderPage = womenPage.clickProceedToCheckOut();
		String cartTitle = orderPage.getCartTitle();
		Assert.assertEquals(cartTitle.contains(prop.getProperty("cartTitle")), true, "Cart title not as expected");
		Assert.assertEquals(totalPriceWomenPage, orderPage.getTotalPrice(), "Price does not match with previous page");

		orderPage = orderPage.deleteProductFromCart();
		UtilityClass.staticWait(5000);
		Assert.assertEquals(orderPage.getAlertMessage(), prop.getProperty("cartEmptyMessage"),
				"Items deleted message not as expected");

	}

	public void closeBrowser() {
		tearDown();
	}

}
