package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class CreateAccountPage extends TestBase {

	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}

	@FindBy(id = "id_gender1")
	WebElement genderInputMr;
	
	@FindBy(id = "id_gender2")
	WebElement genderInputMrs;

	@FindBy(id = "customer_firstname")
	WebElement firstNameInput;

	@FindBy(id = "customer_lastname")
	WebElement lastNameInput;

	@FindBy(id = "passwd")
	WebElement passwordInput;

	@FindBy(id = "days")
	WebElement dateInput;

	@FindBy(id = "months")
	WebElement monthInput;

	@FindBy(id = "years")
	WebElement yearInput;

	@FindBy(id = "newsletter")
	WebElement newsletterCheckbox;

	@FindBy(id = "optin")
	WebElement receiveOfferCheckbox;

	@FindBy(id = "company")
	WebElement companyInput;
	
	@FindBy(id = "address1")
	WebElement addressLine1Input;
	
	@FindBy(id = "address2")
	WebElement addressLine2Input;

	@FindBy(id = "city")
	WebElement addressCityInput;

	@FindBy(id = "id_state")
	WebElement addressStateInput;

	@FindBy(id = "postcode")
	WebElement addressZipcodeInput;

	@FindBy(id = "id_country")
	WebElement addressCountryInput;

	@FindBy(id = "other")
	WebElement additionalInfoInput;

	@FindBy(id = "phone")
	WebElement homePhoneInput;
	
	@FindBy(id = "phone_mobile")
	WebElement phoneNumInput;

	@FindBy(id = "alias")
	WebElement aliasAddressInput;

	@FindBy(id = "submitAccount")
	WebElement registerButton;

	public void selectGender(String gender) {
		if (gender.equalsIgnoreCase("Mr")) {
			Utils.clickOnElement(genderInputMr, 10);
		} else if (gender.equalsIgnoreCase("Mrs")) {
			Utils.clickOnElement(genderInputMrs, 10);
		} 
	}
	
	public void enterFirstName(String firstName) {
		Utils.sendData(firstNameInput, firstName);
	}
	
	public void enterLastName(String lastName) {
		Utils.sendData(lastNameInput, lastName);
	}
	
	public void enterPassword(String password) {
		Utils.sendData(passwordInput, password);
	}
	
	public void enterDOB(String date, String month, String year) {
		Utils.selectFromDropDownByVisibleTextOrValue(dateInput, date);
		Utils.selectFromDropDownByVisibleTextOrValue(monthInput, month);
		Utils.selectFromDropDownByVisibleTextOrValue(yearInput, year);
	}
	
	public void selectCheckbox() {
		Utils.clickOnCheckBox(newsletterCheckbox, 10);
		Utils.clickOnCheckBox(receiveOfferCheckbox, 10);
	}
	
	
	public void enterCompanyName(String phoneNo) {
		Utils.sendData(companyInput, phoneNo);
	}
	
	public void enterStreetAddress(String streetAdd) {
		Utils.sendData(addressLine1Input, streetAdd);
	}
	
	public void enterAddressLine2(String phoneNo) {
		Utils.sendData(addressLine2Input, phoneNo);
	} 
	
	public void enterCity(String city) {
		Utils.sendData(addressCityInput, city);
	}
	
	public void selectState(String state) {
		Utils.selectFromDropDownByVisibleTextOrValue(addressStateInput, state);
	}
	
	public void enterZip(String zip) {
		Utils.sendData(addressZipcodeInput, zip);
	}
	
	public void selectCountry(String country) {
		Utils.selectFromDropDownByVisibleTextOrValue(addressCountryInput, country);
	}
	
	public void enterAdditionalInfo(String phoneNo) {
		Utils.sendData(additionalInfoInput, phoneNo);
	}
	
	public void enterHomePhoneNo(String phoneNo) {
		Utils.sendData(homePhoneInput, phoneNo);
	}
	
	public void enterPhoneNo(String phoneNo) {
		Utils.sendData(phoneNumInput, phoneNo);
	}
	
	public void enterAliasAddress(String aliasInfo) {
		Utils.sendData(aliasAddressInput, aliasInfo);
	}


	public MyAccountPage createNewAccount(String email) {
		Utils.clickOnElement(registerButton, 10);
		return new MyAccountPage();
	}

}
