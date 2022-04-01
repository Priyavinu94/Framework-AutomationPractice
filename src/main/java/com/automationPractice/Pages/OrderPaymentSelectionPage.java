package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;

public class OrderPaymentSelectionPage extends TestBase {

	public OrderPaymentSelectionPage() {

		PageFactory.initElements(driver, this);
	}

	
	@FindBy(className = "bankwire")
	WebElement payByBankOption;
	
	public MyStorePaymentPage selectPayByBank() {
		payByBankOption.click();
		return new MyStorePaymentPage();
	}

}
