package com.automationPractice.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.CreateAccountPage;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;
import com.automationPractice.util.ExcelUtils;

public class LoginPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	MyAccountPage myAccountPage;
	CreateAccountPage createAccPage;

	@BeforeMethod
	public void openBrowser() {
		intialiseDriver();
		homePage = new HomePage();
	}

	@Test
	public void verifyClickOnCreateAccountWithoutEmailGivesError() {

		loginPage = homePage.clickSignInButton();

		createAccPage = loginPage.createNewAccount(" ");
		Assert.assertEquals(
				loginPage.getErrorAtInvalidSignIn().contains(prop.getProperty("createAccountErrorMessageText")), true,
				"Error not displayed");
	}

	@Test(dataProvider = "InvalidSignUpDataProvider")
	public void verifyUserNotAbleToSignInWithInvalidCredentials(String email, String password) {

		loginPage = homePage.clickSignInButton();
		myAccountPage = loginPage.loginToMyAccount(email, password);
		Assert.assertEquals(
				loginPage.getErrorAtInvalidSignIn().contains(prop.getProperty("invalidSignUpErrorMessageText")), true,
				"Error not displayed");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@DataProvider(name = "InvalidSignUpDataProvider")
	public String[][] readAndFeedInvalidLoginData() throws IOException {
		String filePath = "C:\\Users\\VINOD\\Desktop\\PIVOT\\TestDataAutomationPractice.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "InvalidLoginCredentials");
		int columns = ExcelUtils.getCellCount(filePath, "InvalidLoginCredentials", rows);

		String[][] loginData = new String[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				loginData[i][j] = ExcelUtils.getCellData(filePath, "InvalidLoginCredentials", i + 1, j);

			}
		}
		return loginData;
	}
}
