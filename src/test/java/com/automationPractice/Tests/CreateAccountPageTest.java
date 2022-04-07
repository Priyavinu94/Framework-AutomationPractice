package com.automationPractice.Tests;

import org.testng.annotations.BeforeMethod;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;

public class CreateAccountPageTest extends TestBase {
	
	HomePage homePage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}
	
	
}
