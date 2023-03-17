package pageObjects.nopCommerce.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.ListAdminMenuPageByPageName;
import commons.PageGeneratorManager;
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

	public void clickOnBackToCustomerList() {
		waitForElementVisible(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST);
		clickToElement(driver, AdminCustomerPageUI.BACK_TO_CUSTOMER_LIST);
	}
	
	public void selectValueInCustomerRoleDropdownCreate(String value) {
		waitForElementVisible(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		waitForElementClickabled(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		clickToElement(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		selectItemInCustomDropdown(driver, AdminCustomerPageUI.CUSTOMER_ROLE_DROPDOWN_LIST_CREATE, AdminCustomerPageUI.LIST_CUSTOMER_ROLE, value);
	}
	
	public void removeCustomerRoleByName(String customerRole) {
		waitForElementVisible(driver, AdminCustomerPageUI.REMOVE_CUSTOMER_ROLE_BY_NAME, customerRole);
		waitForElementClickabled(driver, AdminCustomerPageUI.REMOVE_CUSTOMER_ROLE_BY_NAME, customerRole);
		clickToElement(driver, AdminCustomerPageUI.REMOVE_CUSTOMER_ROLE_BY_NAME, customerRole);
	}
	
	public boolean isCustomerRoleByNameDisplay(String roleName) {
		waitForElementVisible(driver, AdminCustomerPageUI.CUSTOMER_ROLE_BY_NAME_IS_SELECTED, roleName);
		return isElementDisplayed(driver, AdminCustomerPageUI.CUSTOMER_ROLE_BY_NAME_IS_SELECTED, roleName);
	}

	public void clickOnSearchCustomerButton() {
		waitForElementVisible(driver, AdminCustomerPageUI.SEARCH_CUSTOMER_BUTTON);
		waitForElementClickabled(driver, AdminCustomerPageUI.SEARCH_CUSTOMER_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.SEARCH_CUSTOMER_BUTTON);
		waitForElementInvisible(driver, AdminCustomerPageUI.LOADING_SEARCH_ICON);
		
	}

	public void selectValueInCustomerRoleDropdownSearch(String value) {
		waitForElementVisible(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		waitForElementClickabled(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		clickToElement(driver, AdminCustomerPageUI.REMOVE_REGISTER_ROLE);
		selectItemInCustomDropdown(driver, AdminCustomerPageUI.CUSTOMER_ROLE_DROPDOWN_LIST_SEARCH, AdminCustomerPageUI.LIST_CUSTOMER_ROLE, value);
	}
	
	public String getAndConvertFormatDateOfBirth(String date) {
		String newDateString = "";
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate;
		try {
			startDate = df.parse(date);
			newDateString = df.format(startDate);
			return newDateString;
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDateString;
	}
	
	public boolean isCustomerInformationDisplayAtTable(String customerInfo) {
		ArrayList<String> allValue = new ArrayList<String>();
		waitForAllElementPresent(driver, AdminCustomerPageUI.ALL_RESULT_AT_SEARCH_TABLE);
		List<WebElement> allLine = getListWebElement(driver, AdminCustomerPageUI.ALL_RESULT_AT_SEARCH_TABLE);
		for(WebElement row : allLine) {
			allValue.add(row.getText().trim());
		}
		System.out.println(customerInfo);
		for (String value : allValue) {
			if (value.equals(customerInfo)){
				return true;
			}
		}
		return false;
	}

	public int getNumberOfLineResult() {
		waitForAllElementPresent(driver, AdminCustomerPageUI.ALL_RESULT_AT_SEARCH_TABLE);
		return getElementSize(driver, AdminCustomerPageUI.ALL_RESULT_AT_SEARCH_TABLE);
	}
	
	public AdminEditCustomerPageObject clickOnEditCustomerButton() {
		waitForElementVisible(driver, AdminCustomerPageUI.EDIT_BUTTON);
		waitForElementClickabled(driver, AdminCustomerPageUI.EDIT_BUTTON);
		clickToElement(driver, AdminCustomerPageUI.EDIT_BUTTON);
		return PageGeneratorManager.getAdminEditCustomerPage(driver);
	}

}
