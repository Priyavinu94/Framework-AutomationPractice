package com.automationPractice.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;

public class MyAccountPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	SoftAssert sf;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
		loginPage = homePage.clickSignInButton();
	}

	@Test
	public void verifyUserCanSuccessfullyLogin() {

		// Navigating to My Account Page
		myAccountPage = loginPage.loginToMyAccount(prop.getProperty("userEmail"), prop.getProperty("userPassword"));

		String customerFullname = myAccountPage.getUserFullName();
		String welcomeText = myAccountPage.getWelcomeMessage();
		
		sf = new SoftAssert();
		// Login successful assertions:
		sf.assertEquals(customerFullname, prop.getProperty("userFullname"), "Username does not match");
		sf.assertEquals(welcomeText, prop.getProperty("welcomeText"), "Welcome text is not as expected");
		
		sf.assertAll();
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
