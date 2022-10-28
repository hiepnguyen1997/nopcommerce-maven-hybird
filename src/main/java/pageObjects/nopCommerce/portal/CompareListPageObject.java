package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.FooterListMenuPage;
import pageUIs.nopCommerce.user.CompareListPageUI;

public class CompareListPageObject extends FooterListMenuPage{
	private WebDriver driver;

	public CompareListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean removeButtonForProductByNameDisplay(String productName) {
		int columnProductIndex = getElementSize(driver, CompareListPageUI.COLUMN_INDEX_BY_PRODUCT_NAME, productName) + 1;
		waitForElementVisible(driver, CompareListPageUI.REMOVE_BUTTON_BY_PRODUCT_INDEX, String.valueOf(columnProductIndex));
		return isElementDisplayed(driver, CompareListPageUI.REMOVE_BUTTON_BY_PRODUCT_INDEX, String.valueOf(columnProductIndex));
	}

	public boolean isProductByNameDisplay(String productName) {
		waitForElementVisible(driver, CompareListPageUI.PRODUCT_BY_NAME_AT_COMPARE_PAGE, productName);
		return isElementDisplayed(driver, CompareListPageUI.PRODUCT_BY_NAME_AT_COMPARE_PAGE, productName);
	}

	public String getValueAtRowNameByProductNameDisplay(String rowName, String productName) {
		int columnProductIndex = getElementSize(driver, CompareListPageUI.COLUMN_INDEX_BY_PRODUCT_NAME, productName) + 1;
		int rowIndex = getElementSize(driver, CompareListPageUI.ROW_INDEX_BY_ROW_NAME, rowName) + 1;
		waitForElementVisible(driver, CompareListPageUI.VALUE_OF_PRODUCT_BY_NAME_AT_ROW_NAME, String.valueOf(rowIndex), String.valueOf(columnProductIndex));
		return getElementText(driver, CompareListPageUI.VALUE_OF_PRODUCT_BY_NAME_AT_ROW_NAME, String.valueOf(rowIndex), String.valueOf(columnProductIndex));
	}

}
