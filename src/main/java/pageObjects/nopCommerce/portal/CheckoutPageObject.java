package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage{
	private WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnContinueButton(String pageTitle) {
		waitForElementClickabled(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_PAGE_TITLE, pageTitle);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_PAGE_TITLE, pageTitle);
	}
}
