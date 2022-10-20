package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.SubMenuAtMyAccountPage;
import pageUIs.nopCommerce.user.AddressPageUI;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;

public class UserAddressPageObject extends SubMenuAtMyAccountPage {
	private WebDriver driver;
	
	public UserAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean isNoDataTitleDisplay() {
		waitForElementVisible(driver, AddressPageUI.NO_ADDRESS_TITLE);
		return isElementDisplayed(driver, AddressPageUI.NO_ADDRESS_TITLE);
	}
	
	public String selectValueInStateDropdownList(String dropdownName) {
		waitForElementInvisible(driver, AddressPageUI.LOADING_ICON_STATE_DROPDOWN);
		waitForElementVisible(driver, BasePageUINopCommerce.DROPDOWN_LIST_BY_NAME, dropdownName);
		return getSelectedItemDefaultDropdown(driver, BasePageUINopCommerce.DROPDOWN_LIST_BY_NAME, dropdownName);
	}
	
	public boolean isTitleByFullNameDisplay(String fullName) {
		waitForElementVisible(driver, AddressPageUI.TITLE_BY_FULL_NAME, fullName);
		return isElementDisplayed(driver, AddressPageUI.TITLE_BY_FULL_NAME, fullName);
	}
	
	public String getTextAtTextFieldByClassName(String className) {
		waitForElementVisible(driver, AddressPageUI.TEXT_FIELD_BY_CLASS_NAME, className);
		return getElementText(driver, AddressPageUI.TEXT_FIELD_BY_CLASS_NAME, className);
	}
}
