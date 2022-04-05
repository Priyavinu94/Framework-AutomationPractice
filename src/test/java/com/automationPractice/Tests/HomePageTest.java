package com.automationPractice.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}

	@Test
	public void verifyHomePageTitle() {
		
		Assert.assertEquals(homePage.getPageTitle(), prop.getProperty("HomepageTitle"), "Title not displayed as expected.");
	}
	
		
	public void closeBrowser() {
		tearDown();
	}
}
