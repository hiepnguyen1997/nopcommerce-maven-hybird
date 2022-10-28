package pageUIs.nopCommerce.user;

public class CompareListPageUI {
	public static final String PRODUCT_BY_NAME_AT_COMPARE_PAGE = "xpath=//tbody//label[text()='Name']/parent::td/following-sibling::td//a[text()='%s']";
	public static final String COLUMN_INDEX_BY_PRODUCT_NAME = "xpath=//tbody//a[text()='%s']/parent::td/preceding-sibling::td";
	public static final String ROW_INDEX_BY_ROW_NAME = "xpath=//tbody//label[text()='Price']/ancestor::tr/preceding-sibling::tr";
	public static final String VALUE_OF_PRODUCT_BY_NAME_AT_ROW_NAME = "xpath=//tbody/tr[%s]/td[%s]";
	public static final String CLEAR_LIST = "xpath=//a[@class='clear-list']";
	public static final String NO_IEM_MESSAGE_IN_COMPARE_PAGE = "xpath=//div[text()='You have no items to compare.']";
	public static final String REMOVE_BUTTON_BY_PRODUCT_INDEX = "xpath=//tr[@class='remove-product']/td[%s]/button";
}
