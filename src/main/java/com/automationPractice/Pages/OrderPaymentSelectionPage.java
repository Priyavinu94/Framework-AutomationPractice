package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class OrderPaymentSelectionPage extends TestBase {

	public OrderPaymentSelectionPage() {

		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}

	
	@FindBy(className = "bankwire")
	WebElement payByBankOption;
	
	public MyStorePaymentPage selectPayByBank() {
		Utils.clickOnElement(payByBankOption, 10);
		return new MyStorePaymentPage();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
}
