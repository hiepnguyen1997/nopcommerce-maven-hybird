package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage{
	private WebDriver driver;
	
	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnContinueButtonByStepTitle(String pageTitle) {
		waitForElementClickabled(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_PAGE_TITLE, pageTitle);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_PAGE_TITLE, pageTitle);
	}
	
	public void clickOnEditButtonOfBillingAdress() {
		waitForElementClickabled(driver, CheckoutPageUI.EDIT_BUTTON_AT_BILLING_ADDRESS);
		clickToElement(driver, CheckoutPageUI.EDIT_BUTTON_AT_BILLING_ADDRESS);
	}
	
	public void clickOnSaveButtonOfBillingAdress() {
		waitForElementClickabled(driver, CheckoutPageUI.SAVE_BUTTON_AT_BILLING_ADDRESS);
		clickToElement(driver, CheckoutPageUI.SAVE_BUTTON_AT_BILLING_ADDRESS);
	}
	
	public String getBillingAddressAtCheckoutPageByClassName(String className) {
		waitForElementVisible(driver, CheckoutPageUI.BILLING_ADDRESS_INFOMATION_BY_NAME, className);
		return getElementText(driver, CheckoutPageUI.BILLING_ADDRESS_INFOMATION_BY_NAME, className);
	}
	
	public String getTextValueAtRowNumberByColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, CheckoutPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, CheckoutPageUI.TEXT_VALUE_AT_ROW_NUMBER_BY_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		return getElementText(driver, CheckoutPageUI.TEXT_VALUE_AT_ROW_NUMBER_BY_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	
	public String getPriceCheckoutByProductName(String productName) {
		waitForElementVisible(driver, CheckoutPageUI.PRICE_BY_PRODUCT_NAME, productName);
		return getElementText(driver, CheckoutPageUI.PRICE_BY_PRODUCT_NAME, productName);
	}
	
	public String getQtyProductCheckoutByProductName(String productName) {
		waitForElementVisible(driver, CheckoutPageUI.QTY_BY_PRODUCT_NAME, productName);
		return getElementText(driver, CheckoutPageUI.QTY_BY_PRODUCT_NAME, productName);
	}
	
	public float convertToNumberTotalPriceCheckoutByProductName(String productName) {
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_PRICE_BY_PRODUCT_NAME, productName);
		String subTotalPrice = getElementText(driver, CheckoutPageUI.TOTAL_PRICE_BY_PRODUCT_NAME, productName);
		float convertSubTotalPrice = Float.parseFloat(subTotalPrice.substring(1).replace(",", ""));
		return convertSubTotalPrice;
	}
	
	public float caculateTotalPrice(String productPrice, String productQty) {
		float total = Float.parseFloat(productPrice.substring(1).replace(",", "")) * Integer.parseInt(productQty);
		return total;
	}
	
	public String getGiftWappingOption() {
		waitForElementVisible(driver, CheckoutPageUI.GIFT_WAPPING_OPTION);
		return getElementText(driver, CheckoutPageUI.GIFT_WAPPING_OPTION);
	}
	
	public String getSubTotalAtTotalInfo() {
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_INFOR_SUB_TOTAL);
		return getElementText(driver, CheckoutPageUI.TOTAL_INFOR_SUB_TOTAL);
	}
	
	public String getShippingMethodAtTotalInfo() {
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_INFOR_SHIPPING_METHOD);
		return getElementText(driver, CheckoutPageUI.TOTAL_INFOR_SHIPPING_METHOD);
	}
	
	public String getShippingAtTotalInfo() {
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_INFOR_SHIPPING);
		return getElementText(driver, CheckoutPageUI.TOTAL_INFOR_SHIPPING);
	}
	
	public String getTaxAtTotalInfo() {
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_INFOR_TAX);
		return getElementText(driver, CheckoutPageUI.TOTAL_INFOR_TAX);
	}
	
	public String getTotalAtTotalInfo() {
		waitForElementVisible(driver, CheckoutPageUI.TOTAL_INFOR_TOTAL);
		return getElementText(driver, CheckoutPageUI.TOTAL_INFOR_TOTAL);
	}
	
	public UserHomePageObject clickOnConfirmButton() {
		waitForElementVisible(driver, CheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public void acceptAlertPresenceWhenReOrder() {
		waitForAlertPresence(driver);
		acceptAlert(driver);
		delay(10);
	}
	
}
