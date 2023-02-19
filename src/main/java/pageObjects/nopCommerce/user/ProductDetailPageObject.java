package pageObjects.nopCommerce.user;

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
		waitForElementVisible(driver, ProductDetailPageUI.BAR_NOITIFICATION);
		return getElementText(driver, ProductDetailPageUI.BAR_NOITIFICATION);
	}

	public void closeNoitificationMessage() {
		waitForElementClickabled(driver, ProductDetailPageUI.CLOSE_BAR_NOITIFICATION);
		clickToElement(driver, ProductDetailPageUI.CLOSE_BAR_NOITIFICATION);
		delay(2);
		
	}

	public void seclectItemInProcesserDropdown(String processer) {
		waitForElementVisible(driver, ProductDetailPageUI.PROCESSER_DROPDOWN_LIST);
		waitForElementClickabled(driver, ProductDetailPageUI.PROCESSER_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, ProductDetailPageUI.PROCESSER_DROPDOWN_LIST, processer);
		
	}

	public void seclectItemInRAMDropdown(String RAM) {
		waitForElementVisible(driver, ProductDetailPageUI.RAM_DROPDOWN_LIST);
		waitForElementClickabled(driver, ProductDetailPageUI.RAM_DROPDOWN_LIST);
		selectItemInDefaultDropdown(driver, ProductDetailPageUI.RAM_DROPDOWN_LIST, RAM);
	}

	public void checkToHDDRadioButton(String HDD) {
		waitForElementVisible(driver, ProductDetailPageUI.HDD_RADIO_BUTTON, HDD);
		waitForElementClickabled(driver, ProductDetailPageUI.HDD_RADIO_BUTTON, HDD);
		checkToDefaultCheckboxRadio(driver, ProductDetailPageUI.HDD_RADIO_BUTTON, HDD);
		
	}

	public void checkOSRadioButton(String OS) {
		waitForElementVisible(driver, ProductDetailPageUI.OS_RADIO_BUTTON, OS);
		waitForElementClickabled(driver, ProductDetailPageUI.OS_RADIO_BUTTON, OS);
		checkToDefaultCheckboxRadio(driver, ProductDetailPageUI.OS_RADIO_BUTTON, OS);
		
	}

	public void checkToSoftwareCheckbox(String softwareOption) {
		waitForElementVisible(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareOption);
		waitForElementClickabled(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareOption);
		checkToDefaultCheckboxRadio(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareOption);
		delay(1);
		
	}
	
	public void unCheckToSoftwareCheckbox(String softwareOption) {
		waitForElementVisible(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareOption);
		waitForElementClickabled(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareOption);
		unCheckToDefaultCheckbox(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareOption);
		delay(1);
		
	}

	public boolean isSoftwareCheckSelectedByDefault(String softwareOption) {
		return isElementSelected(driver, ProductDetailPageUI.SOFTWARE_CHECKBOX, softwareOption);
	}

	public String getTotalPrice() {
		waitForElementVisible(driver, ProductDetailPageUI.PRODUCT_PRICE);
		return getElementText(driver, ProductDetailPageUI.PRODUCT_PRICE);
	}

	public void clickOnAddToCartButton() {
		waitForElementVisible(driver, ProductDetailPageUI.ADD_TO_CART);
		waitForElementClickabled(driver, ProductDetailPageUI.ADD_TO_CART);
		clickToElement(driver, ProductDetailPageUI.ADD_TO_CART);
	}

	public String getProductAddToCartMessage() {
		waitForElementVisible(driver, ProductDetailPageUI.BAR_NOITIFICATION);
		return getElementText(driver, ProductDetailPageUI.BAR_NOITIFICATION);
	}

	public void inputToNumberQuantityProduct(String numberProduct) {
		waitForElementVisible(driver, ProductDetailPageUI.NUMBER_PRODUCT);
		sendkeyToElement(driver, ProductDetailPageUI.NUMBER_PRODUCT, numberProduct);
	}

	public void clickOnUpdateButton() {
		waitForElementVisible(driver, ProductDetailPageUI.UPDATE_BUTTON);
		waitForElementClickabled(driver, ProductDetailPageUI.UPDATE_BUTTON);
		clickToElement(driver, ProductDetailPageUI.UPDATE_BUTTON);
	}

}
