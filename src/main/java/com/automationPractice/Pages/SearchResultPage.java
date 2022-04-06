package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BasePackage.TestBase;
import com.automationPractice.util.Utils;

public class SearchResultPage extends TestBase {
	
	public SearchResultPage() {
		
		PageFactory.initElements(driver, this);
		waitForDocumentReadyState(10);
	}
	
	@FindBy(css = "ul.product_list a.product-name")
	WebElement productResult;
	
	public boolean isProductAvailable()  {
		return Utils.waitForElementToBeVisible(productResult, 10).isDisplayed();
	}
	
	public String getProductTitle() {
		return Utils.getTextFromElement(productResult, 10);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
}
