package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.ListAdminMenuPageByPageName;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminProductPageUI;

public class AdminProductPageObject extends ListAdminMenuPageByPageName{
	
	WebDriver driver;

	public AdminProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public int getNumberResultAtTableInAdminPage() {
		waitForElementVisible(driver, AdminProductPageUI.COUNTER_SEARCH_RESULT);
		return getElementSize(driver, AdminProductPageUI.COUNTER_SEARCH_RESULT);
	}
	
	public String getTextValueByColumnNameAtAdmniPage(String columnName) {
		waitForElementVisible(driver, AdminProductPageUI.INDEX_COLUMN_BY_TITLE, columnName);
		int columnIndex = getElementSize(driver, AdminProductPageUI.INDEX_COLUMN_BY_TITLE, columnName) + 1;
		return getElementText(driver, AdminProductPageUI.VALUE_COLUMN_BY_INDE_COLUMN, String.valueOf(columnIndex));
	}
	
	public void clickOnSearchButton() {
		waitForElementVisible(driver, AdminProductPageUI.SEARCH_BUTTON);
		waitForElementClickabled(driver, AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
		waitForElementInvisible(driver, AdminProductPageUI.LOADING_SEARCH_ICON);
		//delay(2);
	}
	
	public boolean isNoDataAvailableInfoDisplay() {
		waitForElementVisible(driver, AdminProductPageUI.NO_DATA_AVAILABLE_MESSAGE);
		return isElementDisplayed(driver, AdminProductPageUI.NO_DATA_AVAILABLE_MESSAGE);
	}

	public AdminProductDetailPageObject clickOnGoSKUButton() {
		waitForElementVisible(driver, AdminProductPageUI.GO_TO_PRODUCT_BY_SKU);
		waitForElementClickabled(driver, AdminProductPageUI.GO_TO_PRODUCT_BY_SKU);
		clickToElement(driver, AdminProductPageUI.GO_TO_PRODUCT_BY_SKU);
		return PageGeneratorManager.getAdminProductDetailPage(driver);
		
	}

}
