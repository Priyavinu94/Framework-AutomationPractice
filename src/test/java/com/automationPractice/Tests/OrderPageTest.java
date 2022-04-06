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
import com.automationPractice.Pages.OrderPage;
import com.automationPractice.Pages.WomenPage;
import com.automationPractice.util.Utils;

public class OrderPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	WomenPage womenPage;
	OrderPage orderPage;
	SoftAssert sf;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		sf = new SoftAssert();
		homePage = new HomePage();
		loginPage = homePage.clickSignInButton();
	}

	@Test
	public void verifyUserCanDeleteItemFromCart() {

		// Navigating to My Account Page
		myAccountPage = loginPage.loginToMyAccount(prop.getProperty("userEmail"), prop.getProperty("userPassword"));

		// Navigating to Women Page
		womenPage = myAccountPage.clickWomenCategory();
		Assert.assertEquals(womenPage.getCategoryTitle(), prop.getProperty("category"),
				"Category title for Women Page not as expected");

		womenPage.clickOnProduct();
		womenPage.switchToIframe();
		womenPage.productIframeAddtoCart();
		womenPage.switchToParentPage();

		Utils.staticWait(5000);
		String totalPriceWomenPage = womenPage.getTotalPrice();
		sf.assertEquals(womenPage.getAddedToCartMessage(), prop.getProperty("AddedToCartMessage"),
				"Added to cart message is not as expected");

		orderPage = womenPage.clickProceedToCheckOut();
		String cartTitle = orderPage.getCartTitle();
		sf.assertEquals(cartTitle.contains(prop.getProperty("cartTitle")), true, "Cart title not as expected");
		sf.assertEquals(totalPriceWomenPage, orderPage.getTotalPrice(), "Price does not match with previous page");

		orderPage = orderPage.deleteProductFromCart();
		Utils.staticWait(5000);
		sf.assertEquals(orderPage.getAlertMessage(), prop.getProperty("cartEmptyMessage"),
				"Items deleted message not as expected");

		sf.assertAll();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
