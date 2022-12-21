package pageUIs.nopCommerce.user;

public class ShoppingCardPageUI {
	public static final String SHOPPING_CARD_TITLE = "xpath=//h1[text()='Shopping cart']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//div[@class='table-wrapper']//thead//th[normalize-space(text())='%s']/preceding-sibling::th";
	public static final String VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]";
	public static final String ATTRIBUTE_VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]//input";
	public static final String NAME_PRODUCT_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]/a";
	public static final String PRODUCT_BY_NAME = "xpath=//div[@class='table-wrapper']//tbody//td[@class='product']/a[text()='%s']";
	public static final String ATTRIBUTE_BUILD_YOUR_OWN_COMPUTER = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]/div[@class='attributes']";
	public static final String EDIT_LINK = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]/div[@class='edit-item']/a";
	public static final String REMOVE_PRODUCT_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
	public static final String SHOPPING_CART_EMPTY_MESSAGE = "xpath=//div[normalize-space(text())='Your Shopping Cart is empty!']";
	public static final String UPDATE_SHOPPING_CART = "xpath=//button[text()='Update shopping cart']";
	public static final String GIFT_WRAPPING_DROPDOWN = "xpath=//label[normalize-space(text())='Gift wrapping']/parent::dt/following-sibling::dd/select";
	public static final String ESTIMATE_SHIPPING_BUTTON = "xpath=//a[normalize-space()='Estimate shipping']";
	public static final String ESTIMATE_SHIPPING_POPUP = "css=div#estimate-shipping-popup";
	public static final String SHIPPING_OPTION_LOADING = "css=div.shipping-options-loading";
	public static final String SHIP_TO_COUNTRY = "css=div#estimate-shipping-popup select#CountryId";
	public static final String SHIP_TO_PROVINCE = "css=div#estimate-shipping-popup select#StateProvinceId";
	public static final String SHIP_TO_ZIP = "css=div#estimate-shipping-popup input#ZipPostalCode";
	public static final String APPLY_BUTTON = "xpath=//button[text()='Apply']";
	public static final String TERM_SERVICE_CHECKBOX = "CSS=input#termsofservice";
	public static final String CHECKOUT_BUTTON = "CSS=button#checkout";
}
