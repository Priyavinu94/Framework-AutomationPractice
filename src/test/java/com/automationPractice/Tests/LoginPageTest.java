package com.automationPractice.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.LoginPage;

public class LoginPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}

	@Test
	public void verifyClickOnCreateAccountWithoutEmailGivesError() {

		loginPage = homePage.clickSignInButton();

		loginPage.createNewAccount("");
		Assert.assertEquals(
				loginPage.getErrorAtCreateAccount().contains(prop.getProperty("createAccountErrorMessageText")), true,
				"Error not displayed");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
