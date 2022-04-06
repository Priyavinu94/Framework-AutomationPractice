package com.automationPractice.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.SearchResultPage;

public class SearchResultPageTest extends TestBase {

	HomePage homePage;
	SearchResultPage searchResultPage;
	SoftAssert sf;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}

	@Test
	public void verifyIfSearchedProductIsDisplayed() {
		
		searchResultPage = homePage.searchProduct(prop.getProperty("productName"));

		// multiple assertions using SoftAssert
		
		sf = new SoftAssert();
		
		sf.assertEquals(searchResultPage.getPageTitle(), prop.getProperty("searchPageTitle"),
				"Page title is not as expected");

		sf.assertEquals(searchResultPage.isProductAvailable(), true, "Entered product is expected to be available");

		//Utils.staticWait(5000);
		sf.assertEquals(searchResultPage.getProductTitle(), prop.getProperty("productName"),
				"Not the expected product");

		sf.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
