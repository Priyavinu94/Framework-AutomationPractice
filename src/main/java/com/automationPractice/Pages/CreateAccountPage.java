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

	@FindBy(id = "id_gender2")
	WebElement genderInput;

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

	@FindBy(id = "address1")
	WebElement addressLine1Input;

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

	@FindBy(id = "phone_mobile")
	WebElement phoneNumInput;

	@FindBy(id = "alias")
	WebElement aliasAddressInput;

	@FindBy(id = "submitAccount")
	WebElement registerButton;

	
}
