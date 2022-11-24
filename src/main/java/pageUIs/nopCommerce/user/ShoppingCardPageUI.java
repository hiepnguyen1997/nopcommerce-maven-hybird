package pageUIs.nopCommerce.user;

public class ShoppingCardPageUI {
	public static final String SHOPPING_CARD_TITLE = "xpath=//h1[text()='Shopping cart']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//div[@class='table-wrapper']//thead//th[text()='%s']/preceding-sibling::th";
	public static final String VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]";
	public static final String ATTRIBUTE_VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]//input";
	public static final String NAME_PRODUCT_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]/a";
	public static final String PRODUCT_BY_NAME = "xpath=//div[@class='table-wrapper']//tbody//td[@class='product']/a[text()='%s']";
	public static final String ATTRIBUTE_BUILD_YOUR_OWN_COMPUTER = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]/div[@class='attributes']";
	public static final String EDIT_LINK = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]/div[@class='edit-item']/a";
	public static final String REMOVE_PRODUCT_BY_PRODUCT_NAME = "xpath=//div[@class='table-wrapper']//tbody//a[text()='%s']/parent::td/following-sibling::td[@class='remove-from-cart']/button";
	public static final String SHOPPING_CART_EMPTY_MESSAGE = "xpath=//div[normalize-space(text())='Your Shopping Cart is empty!']";
}
