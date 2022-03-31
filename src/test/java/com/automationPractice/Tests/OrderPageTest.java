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
	}

	@Test
	public void verifyUserCanDeleteItemFromCart() {

		// Navigating to Login Page
		loginPage = homePage.clickSignInButton();

		loginPage.enterEmailId(prop.getProperty("userEmail"));
		loginPage.enterPassword(prop.getProperty("userPassword"));

		// Navigating to My Account Page
		myAccountPage = loginPage.clickSignInButton();

		String customerFullname = myAccountPage.getUserFullName();
		String welcomeText = myAccountPage.getWelcomeMessage();

		// Login successful assertions:
		Assert.assertEquals(customerFullname, prop.getProperty("userFullname"));
		Assert.assertEquals(welcomeText.contains("Welcome to your account."), true);

		// Navigating to Women Page
		womenPage = myAccountPage.clickWomenCategory();
		Assert.assertEquals(womenPage.getCategoryTitle(), "WOMEN");
		
		womenPage.addFirstProductToCart();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String SuccessMessage = womenPage.getAddedToCartMessage();
		String totalPriceWomenPage = womenPage.getTotalPrice();
		Assert.assertEquals(SuccessMessage, "Product successfully added to your shopping cart");
		
		orderPage = womenPage.clickProceedToCheckOut();
		String cartTitle = orderPage.getCartTitle();
		Assert.assertEquals(cartTitle.contains("SHOPPING-CART SUMMARY"), true);
		Assert.assertEquals(totalPriceWomenPage, orderPage.getTotalPrice());
		
		orderPage = orderPage.deleteProductFromCart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(orderPage.getAlertMessage(), "Your shopping cart is empty.");
	
	}
	
	public void closeBrowser() {
		tearDown();
	}

}
