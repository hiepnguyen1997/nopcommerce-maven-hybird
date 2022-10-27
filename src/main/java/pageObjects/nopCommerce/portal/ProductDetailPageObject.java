package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage{
	private WebDriver driver;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductPreviewPageObject clickOnAddYourReviewLink() {
		waitForElementVisible(driver, ProductDetailPageUI.ADD_YOUR_REVIEW);
		clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW);
		return PageGeneratorManager.getProductReviewPage(driver);
		
	}

	public WishlistPageObject clickOnAddToWishlistButton() {
		waitForElementClickabled(driver, ProductDetailPageUI.ADD_TO_WISHLIST);
		clickToElement(driver, ProductDetailPageUI.ADD_TO_WISHLIST);
		return PageGeneratorManager.getWishlistPage(driver);
		
	}

	public String getAddWishlistMessageDisplay() {
		waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_WISHLIST_MESSAGE);
		return getElementText(driver, ProductDetailPageUI.ADD_TO_WISHLIST_MESSAGE);
	}

	public void closeAddWishlistMessage() {
		waitForElementClickabled(driver, ProductDetailPageUI.CLOSE_ADD_TO_WISHLIST_MESSAGE);
		clickToElement(driver, ProductDetailPageUI.CLOSE_ADD_TO_WISHLIST_MESSAGE);
		
	}

}
