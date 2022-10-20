package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.ProductPageUI;

public class ProductPageObject extends BasePage{
	private WebDriver driver;
	
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public ProductPreviewPageObject clickOnAddYourReviewLink() {
		waitForElementVisible(driver, ProductPageUI.ADD_YOUR_REVIEW);
		clickToElement(driver, ProductPageUI.ADD_YOUR_REVIEW);
		return PageGeneratorManager.getProductReviewPage(driver);
		
	}
}
