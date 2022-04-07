package com.automationPractice.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.Pages.HomePage;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;
import com.automationPractice.util.ExcelUtils;

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

		sf = new SoftAssert();
	}

	@Test(dataProvider = "signUpDataProvider")
	public void verifyUserCanSuccessfullyLogin(String email, String password) {

		// Navigating to My Account Page
		myAccountPage = loginPage.loginToMyAccount(email, password);

//		String customerFullname = myAccountPage.getUserFullName();
		String welcomeText = myAccountPage.getWelcomeMessage();

		// Login successful assertions:
//		sf.assertEquals(customerFullname, prop.getProperty("userFullname"), "Username does not match");
		sf.assertEquals(welcomeText, prop.getProperty("welcomeText"), "Welcome text is not as expected");

		sf.assertAll();
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

//	@DataProvider(name = "accountCreationDataProvider")
//	public void readAndFeedNewUserDataToCreateAccount() throws IOException {
//		String filePath = "C:\\Users\\VINOD\\Desktop\\PIVOT\\TestDataAutomationPractice.xlsx";
//		int rows = ExcelUtils.getRowCount(filePath, "AccountCreationData");
//		int columns = ExcelUtils.getCellCount(filePath, "AccountCreationData", rows);
//
//		String[][] createAccountData = new String[rows][columns];
//
//		for (int i = 1; i < rows; i++) {
//			for (int j = 0; j < columns; j++) {
//				createAccountData[i-1][j] = ExcelUtils.getCellData(filePath, "AccountCreationData", i, j);
//			}
//		}
//	}

	@DataProvider(name = "signUpDataProvider")
	public String[][] readAndFeedLoginData() throws IOException {
		String filePath = "C:\\Users\\VINOD\\Desktop\\PIVOT\\TestDataAutomationPractice.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "LoginCredentials");
		int columns = ExcelUtils.getCellCount(filePath, "LoginCredentials", rows);

		String[][] loginData = new String[rows][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellData(filePath, "LoginCredentials", i, j);
			}
		}
		return loginData;
	}
}
