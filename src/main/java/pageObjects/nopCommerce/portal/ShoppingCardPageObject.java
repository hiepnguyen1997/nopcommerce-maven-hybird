package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;
import pageUIs.nopCommerce.user.ShoppingCardPageUI;

public class ShoppingCardPageObject extends BasePage{
	private WebDriver driver;
	
	public ShoppingCardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isShoppingCardTitleDisplay() {
		waitForElementVisible(driver, ShoppingCardPageUI.SHOPPING_CARD_TITLE);
		return isElementDisplayed(driver, ShoppingCardPageUI.SHOPPING_CARD_TITLE);
	}

	public String getProductValueAtRowNumberByColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getElementText(driver, ShoppingCardPageUI.VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
	}
	
	public String getAttributeValueAtRowNumberByColumnName(String rowNumber, String columnName, String attributeName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getElementAttribute(driver, ShoppingCardPageUI.ATTRIBUTE_VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME, attributeName, rowNumber, String.valueOf(columnIndex));
	}
	
	public String getProductNameAtRowNumberByColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getElementText(driver, ShoppingCardPageUI.NAME_PRODUCT_AT_ROW_NUMBER_BY_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
	}
	public String getProductAttributeAtRowNumberByColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getElementText(driver, ShoppingCardPageUI.ATTRIBUTE_BUILD_YOUR_OWN_COMPUTER, rowNumber, String.valueOf(columnIndex));
	}

	public ProductDetailPageObject clickOnEditProductAtRowNumberByColmnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		clickToElement(driver, ShoppingCardPageUI.EDIT_LINK, rowNumber, String.valueOf(columnIndex));
		return PageGeneratorManager.getProductPage(driver);
	}
	
	public float getTotalPriceAtShoppingCart(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		String price = getElementText(driver, ShoppingCardPageUI.VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
		float actualTotalPrice = Float.parseFloat(price.substring(1).replace(",", ""));
		System.out.println(actualTotalPrice);
		return actualTotalPrice;
	}

	public float totalPriceOfProduct(String price, String quantityProduct) {
		String newPrice = price.substring(1);
		float numberPrice = Float.parseFloat(newPrice.replace(",", "")) * Integer.parseInt(quantityProduct);
		System.out.println(numberPrice);
		return numberPrice;
	}

	public void clickOnRemoveButtonByProductName(String productName) {
		waitForElementClickabled(driver, ShoppingCardPageUI.REMOVE_PRODUCT_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ShoppingCardPageUI.REMOVE_PRODUCT_BY_PRODUCT_NAME, productName);
		
	}

	public boolean isShoppingCartEmptyMessage() {
		waitForElementVisible(driver, ShoppingCardPageUI.SHOPPING_CART_EMPTY_MESSAGE);
		return isElementDisplayed(driver, ShoppingCardPageUI.SHOPPING_CART_EMPTY_MESSAGE);
	}
	
	public boolean isProductByNameUnDisplay(String productName) {
		return isElementUnDisplay(driver, ShoppingCardPageUI.PRODUCT_BY_NAME, productName);
	}
}
