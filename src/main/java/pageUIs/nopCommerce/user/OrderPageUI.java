package pageUIs.nopCommerce.user;

public class OrderPageUI {
	public static final String DETAIL_BUTTON_BY_NUMBER_ORDER = "xpath=//strong[text()='Order Number: %s']/parent::div/following-sibling::div[@class='buttons']/button[text()='Details']";
	public static final String ORDER_BY_NUMBER_DISPLAY = "xpath=//strong[text()='Order Number: %s']";
	public static final String ORDER_ID_BY_ORDER_NUMBER = "xpath=//strong[text()='Order #%s']";
	public static final String ORDER_DATE_BY_DATE = "xpath=//li[@class='order-date' and text()='Order Date: %s']";
	public static final String ORDER_STATUS_BY_STATUS = "xpath=//li[@class='order-status' and text()='Order Status: %s']";
	public static final String ORDER_TOTAL_BY_SUB_TOTAL = "xpath=//li[@class='order-total']/strong[text()='%s']";
	public static final String BILLING_ADDRESS_INFOMATION_BY_NAME = "XPATH=//div[@class='billing-info']//li[@class='%s']";
	public static final String PAYMENT_METHOD = "xpath=//li[@class='payment-method']/span[@class='value']";
	public static final String SHIPPING_METHOD = "xpath=//li[@class='shipping-method']/span[@class='value']";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME ="xpath=//div[@class='table-wrapper']//thead//th[normalize-space(text())='%s']/preceding-sibling::th";
	public static final String TEXT_VALUE_AT_ROW_NUMBER_BY_COLUMN_INDEX = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]";
	public static final String PRICE_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[normalize-space(text())='%s']/parent::td/following-sibling::td/span[@class='product-unit-price']";
	public static final String QTY_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[normalize-space(text())='%s']/parent::td/following-sibling::td/span[@class='product-quantity']";
	public static final String TOTAL_PRICE_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[normalize-space(text())='%s']/parent::td/following-sibling::td/span[@class='product-subtotal']";
	public static final String GIFT_WAPPING_OPTION = "css=div.section.options>div";
	public static final String TOTAL_INFOR_SUB_TOTAL = "xpath=//table[@class='cart-total']//label[text()='Sub-Total:']/parent::td/following-sibling::td/span";
	public static final String TOTAL_INFOR_SHIPPING = "xpath=//table[@class='cart-total']//label[text()='Shipping:']/parent::td/following-sibling::td/span";
	public static final String TOTAL_INFOR_TAX = "xpath=//table[@class='cart-total']//label[text()='Tax:']/parent::td/following-sibling::td/span";
	public static final String ORDER_TOTAL_INFOR_TOTAL = "xpath=//table[@class='cart-total']//label[text()='Order Total:']/parent::td/following-sibling::td/span";
	
}
