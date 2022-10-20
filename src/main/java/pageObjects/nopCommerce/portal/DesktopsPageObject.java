package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.ListPageAtTopMenu;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.DesktopsPageUI;

public class DesktopsPageObject extends ListPageAtTopMenu{
	private WebDriver driver;

	public DesktopsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public ProductPageObject clickOnProductByName(String productName) {
		waitForElementVisible(driver, DesktopsPageUI.PRODUCT_BY_NAME, productName);
		clickToElement(driver, DesktopsPageUI.PRODUCT_BY_NAME, productName);
		return PageGeneratorManager.getProductPage(driver);
	}

}
