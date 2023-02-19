package pageObjects.nopCommerce.user;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

import commons.PageGeneratorManager;
import commons.SubMenuAtMyAccountPage;
import pageUIs.nopCommerce.user.OrderPageUI;

public class OrderPageObject extends SubMenuAtMyAccountPage{
	private WebDriver driver;
	
	public OrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickOnDetailButtonOfOrderNumber(String ordertNumber) {
		waitForElementVisible(driver, OrderPageUI.DETAIL_BUTTON_BY_NUMBER_ORDER, ordertNumber);
		clickToElement(driver, OrderPageUI.DETAIL_BUTTON_BY_NUMBER_ORDER, ordertNumber);
	}
	
	public boolean isOrderByNumberDisplayed(String ordertNumber) {
		waitForElementVisible(driver, OrderPageUI.ORDER_BY_NUMBER_DISPLAY, ordertNumber);
		return isElementDisplayed(driver, OrderPageUI.ORDER_BY_NUMBER_DISPLAY, ordertNumber);
	}

	public boolean isOrderIDByOrderNumberDisplayed(String orderNumber) {
		waitForAllElementsVisible(driver, OrderPageUI.ORDER_ID_BY_ORDER_NUMBER, orderNumber);
		return isElementDisplayed(driver, OrderPageUI.ORDER_ID_BY_ORDER_NUMBER, orderNumber);
	}

	public boolean isOrderDateByDateDisplayed(String orderDate) {
		waitForAllElementsVisible(driver, OrderPageUI.ORDER_DATE_BY_DATE, orderDate);
		return isElementDisplayed(driver, OrderPageUI.ORDER_DATE_BY_DATE, orderDate);
	}
	
	public String getOrderDate() {
		waitForElementVisible(driver, OrderPageUI.ORDER_DATE);
		String fullOrderDate = getElementText(driver, OrderPageUI.ORDER_DATE);
		String [] orderDate = fullOrderDate.split(":");
		return orderDate[1].trim();
	}

	public boolean isOrderStatusByStatusDisplayed(String orderStatus) {
		waitForAllElementsVisible(driver, OrderPageUI.ORDER_STATUS_BY_STATUS, orderStatus);
		return isElementDisplayed(driver, OrderPageUI.ORDER_STATUS_BY_STATUS, orderStatus);
	}

	public boolean isOrderTotalByTotalDislayed(String subTotal) {
		waitForAllElementsVisible(driver, OrderPageUI.ORDER_TOTAL_BY_SUB_TOTAL, subTotal);
		return isElementDisplayed(driver, OrderPageUI.ORDER_TOTAL_BY_SUB_TOTAL, subTotal);
	}
	
	public String getFullLocationDate() {
		Locale local = new Locale("en");
		Date date  = new Date();
		DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL, local);
		return dateInstance.format(date);
	}
	
	public String getTheTimeZone(String location, String zoneID) {
		Locale local = new Locale(location);
		ZoneId zoneId = ZoneId.of(zoneID);
		LocalDate localDate = LocalDate.now(zoneId);
		Date date = Date.from(localDate.atStartOfDay(zoneId).toInstant());
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, local);
		return dateFormat.format(date);
	}
	
	public String getBillingAddressAtOrderPageByClassName(String className) {
		waitForElementVisible(driver, OrderPageUI.BILLING_ADDRESS_INFOMATION_BY_NAME, className);
		return getElementText(driver, OrderPageUI.BILLING_ADDRESS_INFOMATION_BY_NAME, className);
	}
	
	public String getTextValueAtRowNumberByColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(driver, OrderPageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisible(driver, OrderPageUI.TEXT_VALUE_AT_ROW_NUMBER_BY_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		return getElementText(driver, OrderPageUI.TEXT_VALUE_AT_ROW_NUMBER_BY_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
	}
	
	public String getGiftWappingOption() {
		waitForElementVisible(driver, OrderPageUI.GIFT_WAPPING_OPTION);
		return getElementText(driver, OrderPageUI.GIFT_WAPPING_OPTION);
	}
	
	public String getSubTotalAtTotalInfo() {
		waitForElementVisible(driver, OrderPageUI.TOTAL_INFOR_SUB_TOTAL);
		return getElementText(driver, OrderPageUI.TOTAL_INFOR_SUB_TOTAL);
	}
	
	public String getShippingAtTotalInfo() {
		waitForElementVisible(driver, OrderPageUI.TOTAL_INFOR_SHIPPING);
		return getElementText(driver, OrderPageUI.TOTAL_INFOR_SHIPPING);
	}
	
	public String getTaxAtTotalInfo() {
		waitForElementVisible(driver, OrderPageUI.TOTAL_INFOR_TAX);
		return getElementText(driver, OrderPageUI.TOTAL_INFOR_TAX);
	}
	
	public String getTotalAtTotalInfo() {
		waitForElementVisible(driver, OrderPageUI.ORDER_TOTAL_INFOR_TOTAL);
		return getElementText(driver, OrderPageUI.ORDER_TOTAL_INFOR_TOTAL);
	}

	public ShoppingCardPageObject clickOnReOrderButton() {
		waitForElementVisible(driver, OrderPageUI.RE_ORDER_BUTTON);
		clickToElement(driver, OrderPageUI.RE_ORDER_BUTTON);
		return PageGeneratorManager.getShoppingCardPage(driver);
	}
}
