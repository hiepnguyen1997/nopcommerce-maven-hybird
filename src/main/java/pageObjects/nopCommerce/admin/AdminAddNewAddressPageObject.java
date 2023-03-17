package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminAddNewAddressPageUI;

public class AdminAddNewAddressPageObject extends BasePage{
	
	WebDriver driver;
	
	public AdminAddNewAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnSaveNewAddressButton() {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.SAVE_NEW_ADDRESS);
		waitForElementClickabled(driver, AdminAddNewAddressPageUI.SAVE_NEW_ADDRESS);
		clickToElement(driver, AdminAddNewAddressPageUI.SAVE_NEW_ADDRESS);
	}
	
	public AdminEditCustomerPageObject clickOnBackToCustomerDetail() {
		waitForElementVisible(driver, AdminAddNewAddressPageUI.BACK_TO_CUSTOMER_DETAIL);
		waitForElementClickabled(driver, AdminAddNewAddressPageUI.BACK_TO_CUSTOMER_DETAIL);
		clickToElement(driver, AdminAddNewAddressPageUI.BACK_TO_CUSTOMER_DETAIL);
		return PageGeneratorManager.getAdminEditCustomerPage(driver);
	}
}
