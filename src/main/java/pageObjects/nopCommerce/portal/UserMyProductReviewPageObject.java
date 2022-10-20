package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.SubMenuAtMyAccountPage;
import pageUIs.nopCommerce.user.MyProductReviewPageUI;

public class UserMyProductReviewPageObject extends SubMenuAtMyAccountPage{
	private WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isMyProductReviewTitleDisplay(String pageTitle) {
		waitForElementVisible(driver, MyProductReviewPageUI.PAGE_TITLE_MY_PRODUCT_REVIEW, pageTitle);
		return isElementDisplayed(driver, MyProductReviewPageUI.PAGE_TITLE_MY_PRODUCT_REVIEW, pageTitle);
	}

	public boolean isReviewTitleByValueDisplay(String reviewTitle) {
		waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_BY_VALUE, reviewTitle);
		return isElementDisplayed(driver, MyProductReviewPageUI.REVIEW_TITLE_BY_VALUE, reviewTitle);
	}

	public boolean isRevieBodyByValueDisplay(String reviewBody) {
		waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_BODY_BY_VALUE, reviewBody);
		return isElementDisplayed(driver, MyProductReviewPageUI.REVIEW_BODY_BY_VALUE, reviewBody);
	}

	public boolean isProductByNameDisplay(String productName) {
		waitForElementVisible(driver, MyProductReviewPageUI.PRODUCT_BY_NAME, productName);
		return isElementDisplayed(driver, MyProductReviewPageUI.PRODUCT_BY_NAME, productName);
	}
}
