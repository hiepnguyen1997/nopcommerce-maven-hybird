package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminEditCustomerPageUI;

public class AdminEditCustomerPageObject extends BasePage{
	
	WebDriver driver;
	
	public AdminEditCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminCustomerPageObject clickOnSaveButton() {
		waitForElementVisible(driver, AdminEditCustomerPageUI.SAVE_EDIT_CUSTOMER_BUTTON);
		waitForElementClickabled(driver, AdminEditCustomerPageUI.SAVE_EDIT_CUSTOMER_BUTTON);
		clickToElement(driver, AdminEditCustomerPageUI.SAVE_EDIT_CUSTOMER_BUTTON);
		return PageGeneratorManager.getAdminCustomerPage(driver);
	}
	
	public AdminAddNewAddressPageObject clickOnAddNewAddressButton() {
		waitForElementVisible(driver, AdminEditCustomerPageUI.ADDRESS_BUTTON);
		waitForElementClickabled(driver, AdminEditCustomerPageUI.ADDRESS_BUTTON);
		clickToElement(driver, AdminEditCustomerPageUI.ADDRESS_BUTTON);
		waitForElementVisible(driver, AdminEditCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
		waitForElementClickabled(driver, AdminEditCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
		clickToElement(driver, AdminEditCustomerPageUI.ADD_NEW_ADDRESS_BUTTON);
		return PageGeneratorManager.getAdminAddNewAddressPage(driver);
	}
	
	public String getValueAtColumnByNameAtAddressSection(String coumnName) {
		int columnIndex = 0;
		if(isElementUnDisplay(driver, AdminEditCustomerPageUI.COLUMN_INDEX_BY_NAME_AT_ADDRESS_SECTION, coumnName)) {
			columnIndex = 1;
		} else {
			columnIndex = getElementSize(driver, AdminEditCustomerPageUI.COLUMN_INDEX_BY_NAME_AT_ADDRESS_SECTION, coumnName) + 1 ;
		}
		return getElementText(driver, AdminEditCustomerPageUI.VALUE_BY_COLUMN_INDEX_AT_ADDRESS_SECTION, String.valueOf(columnIndex));
	}
	
}
