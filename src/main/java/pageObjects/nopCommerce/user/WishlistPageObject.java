package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.NopCommercePageUIUser;
import pageUIs.nopCommerce.user.WishlistPageUI;

public class WishlistPageObject extends BasePage{
	private WebDriver driver;
	
	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getValueAtRowNumberByColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, WishlistPageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;
		return getElementText(driver, WishlistPageUI.VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME, rowNumber, String.valueOf(columnIndex));
	}

	public boolean isShareWishlistLinkDisplay() {
		waitForElementVisible(driver, WishlistPageUI.WISHLIST_SHARE_LINK);
		return isElementDisplayed(driver, WishlistPageUI.WISHLIST_SHARE_LINK);
	}

	public WishlistShareLinkPageObject clickOnShareWishlistLink() {
		waitForElementClickabled(driver, WishlistPageUI.WISHLIST_SHARE_LINK);
		clickToElement(driver, WishlistPageUI.WISHLIST_SHARE_LINK);
		return PageGeneratorManager.getWishlistShareLinkPage(driver);
	}

	public void clickOnCheckboxOfProductByName(String productName) {
		waitForElementClickabled(driver, WishlistPageUI.ADD_TO_CARD_CHECKBOX_BY_PRODUCT_NAME, productName);
		clickToElement(driver, WishlistPageUI.ADD_TO_CARD_CHECKBOX_BY_PRODUCT_NAME, productName);
		
	}
	
	public ShoppingCardPageObject clickOnAddToCardButton() {
		waitForElementVisible(driver, WishlistPageUI.ADD_TO_CARD_BUTTON);
		clickToElement(driver, WishlistPageUI.ADD_TO_CARD_BUTTON);
		delay(2);
		return PageGeneratorManager.getShoppingCardPage(driver);
	}

	public void clickOnRemoveButtonByProductName(String productName) {
		waitForAllElementsVisible(driver, WishlistPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
		clickToElement(driver, WishlistPageUI.REMOVE_BUTTON_BY_PRODUCT_NAME, productName);
		
	}

	public boolean isPageEmptyMessageDisplay() {
		waitForAllElementsVisible(driver, WishlistPageUI.WISHLIST_PAGE_EMPTY_MESSAGE);
		return isElementDisplayed(driver, WishlistPageUI.WISHLIST_PAGE_EMPTY_MESSAGE);
	}

}
