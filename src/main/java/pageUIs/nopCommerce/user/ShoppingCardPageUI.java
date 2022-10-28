package pageUIs.nopCommerce.user;

public class ShoppingCardPageUI {
	public static final String SHOPPING_CARD_TITLE = "xpath=//h1[text()='Shopping cart']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//div[@class='table-wrapper']//thead//th[text()='%s']/preceding-sibling::th";
	public static final String VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]";
}
