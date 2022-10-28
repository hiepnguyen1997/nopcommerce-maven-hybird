package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;
import pageUIs.nopCommerce.user.ShoppingCardPageUI;

public class ShoppingCardPageObject extends BasePage{
	private WebDriver driver;
	
	public ShoppingCardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getWislistQuantity() {
		waitForElementVisible(driver, BasePageUINopCommerce.WISHLIST_QUANTITY);
		return getElementText(driver, BasePageUINopCommerce.WISHLIST_QUANTITY);
	}

	public boolean isShoppingCardTitleDisplay() {
		waitForElementVisible(driver, ShoppingCardPageUI.SHOPPING_CARD_TITLE);
		return isElementDisplayed(driver, ShoppingCardPageUI.SHOPPING_CARD_TITLE);
	}

	public String getProductAtRowNumberByName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getElementText(driver, ShoppingCardPageUI.VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
	}
}
