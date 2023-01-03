package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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
		return actualTotalPrice;
	}

	public float totalPriceOfProduct(String price, String quantityProduct) {
		String newPrice = price.substring(1);
		float numberPrice = Float.parseFloat(newPrice.replace(",", "")) * Integer.parseInt(quantityProduct);
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

	public void inputToQtyByProductName(String quantityProduct2, String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, ShoppingCardPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, ShoppingCardPageUI.ATTRIBUTE_VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, ShoppingCardPageUI.ATTRIBUTE_VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME, quantityProduct2,rowNumber, String.valueOf(columnIndex));
		
	}

	public void clickOnUpdateShoppingCart() {
		waitForElementClickabled(driver, ShoppingCardPageUI.UPDATE_SHOPPING_CART);
		clickToElement(driver, ShoppingCardPageUI.UPDATE_SHOPPING_CART);
	}

	public void selectValueInGiftWrapping(String wrappingOption) {
		waitForElementClickabled(driver, ShoppingCardPageUI.GIFT_WRAPPING_DROPDOWN);
		selectItemInDefaultDropdown(driver, ShoppingCardPageUI.GIFT_WRAPPING_DROPDOWN, wrappingOption);
	}

	public void clickOnEstimateShippingButton() {
		waitForElementClickabled(driver, ShoppingCardPageUI.ESTIMATE_SHIPPING_BUTTON);
		clickToElement(driver, ShoppingCardPageUI.ESTIMATE_SHIPPING_BUTTON);
	}

	public void selectCountryInShipToPopup(String country) {
		waitForElementVisible(driver, ShoppingCardPageUI.ESTIMATE_SHIPPING_POPUP);
		waitForElementClickabled(driver, ShoppingCardPageUI.SHIP_TO_COUNTRY);
		waitForElementVisible(driver, ShoppingCardPageUI.SHIP_TO_COUNTRY);
		selectItemInDefaultDropdown(driver, ShoppingCardPageUI.SHIP_TO_COUNTRY, country);
	}

	public void selectProvinceInShipToPopup(String province) {
		waitForElementVisible(driver, ShoppingCardPageUI.ESTIMATE_SHIPPING_POPUP);
		waitForElementClickabled(driver, ShoppingCardPageUI.SHIP_TO_PROVINCE);
		waitForElementVisible(driver, ShoppingCardPageUI.SHIP_TO_PROVINCE);
		selectItemInDefaultDropdown(driver, ShoppingCardPageUI.SHIP_TO_PROVINCE, province);
	}

	public void inputToZipCodeInShipToPopup(String zipCode) {
		waitForElementVisible(driver, ShoppingCardPageUI.ESTIMATE_SHIPPING_POPUP);
		waitForElementVisible(driver, ShoppingCardPageUI.SHIP_TO_ZIP);
		sendkeyToElement(driver, ShoppingCardPageUI.SHIP_TO_ZIP, zipCode);
		sleepInSecond(2);
	}

	public void clickOnApplyButton() {
		waitForElementVisible(driver, ShoppingCardPageUI.ESTIMATE_SHIPPING_POPUP);
		waitForElementClickabled(driver, ShoppingCardPageUI.APPLY_BUTTON);
		clickToElement(driver, ShoppingCardPageUI.APPLY_BUTTON);
	}

	public void checkToAgreeConditionCheckbox() {
		waitForElementVisible(driver, ShoppingCardPageUI.TERM_SERVICE_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, ShoppingCardPageUI.TERM_SERVICE_CHECKBOX);
	}

	public CheckoutPageObject clickOnCheckoutButton() {
		waitForElementClickabled(driver, ShoppingCardPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, ShoppingCardPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getCheckoutPage(driver);
	}
}
