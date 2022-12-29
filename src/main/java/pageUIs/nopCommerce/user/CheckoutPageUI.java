package pageUIs.nopCommerce.user;

public class CheckoutPageUI {
	public static final String CONTINUE_BUTTON_BY_PAGE_TITLE = "xpath=//h2[text()='%s']/parent::div[@class='step-title']/following-sibling::div//button[text()='Continue']";
	public static final String BILLING_ADDRESS_INFOMATION_BY_NAME = "XPATH=//div[@class='billing-info']//li[@class='%s']";
	public static final String PAYMENT_METHOD = "xpath=//li[@class='payment-method']/span[@class='value']";
	public static final String SHIPPING_METHOD = "xpath=//li[@class='shipping-method']/span[@class='value']";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME ="xpath=//div[@class='table-wrapper']//thead//th[normalize-space(text())='%s']/preceding-sibling::th";
	public static final String TEXT_VALUE_AT_ROW_NUMBER_BY_COLUMN_INDEX = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]";
	public static final String PRICE_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[normalize-space(text())='%s']/parent::td/following-sibling::td/span[@class='product-unit-price']";
	public static final String QTY_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[normalize-space(text())='%s']/parent::td/following-sibling::td/span[@class='product-quantity']";
	public static final String TOTAL_PRICE_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[normalize-space(text())='%s']/parent::td/following-sibling::td/span[@class='product-subtotal']";
	public static final String GIFT_WAPPING_OPTION = "css=div.cart-options>div";
	public static final String TOTAL_INFOR_SUB_TOTAL = "xpath=//table[@class='cart-total']//label[text()='Sub-Total:']/parent::td/following-sibling::td/span";
	public static final String TOTAL_INFOR_SHIPPING_METHOD = "xpath=//table[@class='cart-total']//label[text()='Shipping:']/following-sibling::span";
	public static final String TOTAL_INFOR_SHIPPING = "xpath=//table[@class='cart-total']//label[text()='Shipping:']/parent::td/following-sibling::td/span";
	public static final String TOTAL_INFOR_TAX = "xpath=//table[@class='cart-total']//label[text()='Tax:']/parent::td/following-sibling::td/span";
	public static final String TOTAL_INFOR_TOTAL = "xpath=//table[@class='cart-total']//label[text()='Total:']/parent::td/following-sibling::td/span";
	public static final String CONFIRM_BUTTON = "xpath=//button[text()='Confirm']";
	public static final String ORDER_SUCCESSFULL_MESSAGE = "xpath=//strong[text()='Your order has been successfully processed!']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']/strong";
	
	
}
