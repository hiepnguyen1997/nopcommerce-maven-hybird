package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.ProductPreviewPageUI;

public class ProductPreviewPageObject extends BasePage{
	private WebDriver driver;
	
	public ProductPreviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String isDateUploadReviewDisplay() {
		waitForElementVisible(driver, ProductPreviewPageUI.DATE_REVIEW);
		return getElementText(driver, ProductPreviewPageUI.DATE_REVIEW);
	}

	public boolean isTitlePageReviewByProductNameDisplay(String value) {
		waitForElementVisible(driver, ProductPreviewPageUI.PRODUCT_PAGE_TITLE_BY_NAME, value);
		return isElementDisplayed(driver, ProductPreviewPageUI.PRODUCT_PAGE_TITLE_BY_NAME, value);
	}

	public void inputToReviewTextArea(String reviewBody) {
		waitForElementVisible(driver, ProductPreviewPageUI.REVIEW_TEXT_AREA);
		sendkeyToElement(driver, ProductPreviewPageUI.REVIEW_TEXT_AREA, reviewBody);
		
	}

	public boolean isReviewAddedMessageDisplay() {
		waitForElementVisible(driver, ProductPreviewPageUI.PREVIEW_ADDED_MESSAGE);
		return isElementDisplayed(driver, ProductPreviewPageUI.PREVIEW_ADDED_MESSAGE);
	}

	public boolean isReviewTitleByValueDisplay(String reviewTitle) {
		waitForElementVisible(driver, ProductPreviewPageUI.REVIEW_TITLE, reviewTitle);
		return isElementDisplayed(driver, ProductPreviewPageUI.REVIEW_TITLE, reviewTitle);
	}

	public boolean isReviewBodyByValueDisplay(String reviewBody) {
		waitForElementVisible(driver, ProductPreviewPageUI.REVIEW_BODY, reviewBody);
		return isElementDisplayed(driver, ProductPreviewPageUI.REVIEW_BODY, reviewBody);
	}

	public boolean isReviewUploadByAuthor(String firstName) {
		waitForElementVisible(driver, ProductPreviewPageUI.USER_BY_FIRST_NAME, firstName);
		return isElementDisplayed(driver, ProductPreviewPageUI.USER_BY_FIRST_NAME, firstName);
	}
}
