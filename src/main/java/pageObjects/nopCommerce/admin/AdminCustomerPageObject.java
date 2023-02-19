package pageObjects.nopCommerce.admin;

import org.aeonbits.owner.Config.Key;
import org.openqa.selenium.WebDriver;

import commons.ListAdminMenuPageByPageName;
import pageUIs.nopCommerce.admin.AdminCustomerPageUI;

public class AdminCustomerPageObject extends ListAdminMenuPageByPageName{
	WebDriver driver;

	public AdminCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickOAddNewCustomerButton() {
		waitForElementVisible(driver, AdminCustomerPageUI.ADD_NEW_CUSTOMER_BUTTON);
		waitForElementClickabled(driver, AdminCustomerPageUI.ADD_NEW_CUSTOMER_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.ADD_NEW_CUSTOMER_BUTTON);
		
	}

	public void clickOnSaveAndContinueButton() {
		waitForElementVisible(driver, AdminCustomerPageUI.SAVE_AND_CONTINUE_BUTTON);
		waitForElementClickabled(driver, AdminCustomerPageUI.SAVE_AND_CONTINUE_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.SAVE_AND_CONTINUE_BUTTON);
	}

	public String getNewCustomerCreatedMessage() {
		waitForElementVisible(driver, AdminCustomerPageUI.NEW_CUSTOMER_CREATED_MESSAGE);
		return getElementText(driver, AdminCustomerPageUI.NEW_CUSTOMER_CREATED_MESSAGE);
	}

	public void inputToAdminCommentTextrea(String textValue) {
		waitForElementVisible(driver, AdminCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
		sendkeyToElement(driver, AdminCustomerPageUI.ADMIN_COMMENT_TEXTAREA, textValue);
		
	}
	
	public String getTextValueInAdminCommentTextArea() {
		waitForElementVisible(driver, AdminCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
		return getElementText(driver, AdminCustomerPageUI.ADMIN_COMMENT_TEXTAREA);
	}

	public void clickOnBackToCustomerList() {
		waitForElementVisible(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST);
		clickToElement(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST);
		
	}
	
	public void selectValueInCustomerRoleDropdown(String value) {
		waitForElementVisible(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		clickToElement(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		selectItemInCustomDropdown(driver, AdminCustomerPageUI.CUSTOMER_ROLE_DROPDOWN_LIST, AdminCustomerPageUI.LIST_CUSTOMER_ROLE, value);
	}
	
	public boolean isCustomerRoleByNameDisplay(String roleName) {
		waitForElementVisible(driver, AdminCustomerPageUI.CUSTOMER_ROLE_BY_NAME_IS_SELECTED, roleName);
		return isElementDisplayed(driver, AdminCustomerPageUI.CUSTOMER_ROLE_BY_NAME_IS_SELECTED, roleName);
	}

}
