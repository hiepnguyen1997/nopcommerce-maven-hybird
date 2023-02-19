package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.WishlistShareLinkPageUI;

public class WishlistShareLinkPageObject extends BasePage{
	private WebDriver driver;
	
	public WishlistShareLinkPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isWishlistByUserNameDisplay(String fullName) {
		waitForElementVisible(driver, WishlistShareLinkPageUI.WISHLIST_TITLE_FOR_USER, fullName);
		return isElementDisplayed(driver, WishlistShareLinkPageUI.WISHLIST_TITLE_FOR_USER, fullName);
	}


}
