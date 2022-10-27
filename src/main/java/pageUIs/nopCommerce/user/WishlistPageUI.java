package pageUIs.nopCommerce.user;

public class WishlistPageUI {
	public static final String WISHLIST_PAGE_TITLE = "xpath=//h1[text()='Wishlist']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//div[@class='table-wrapper']//thead//th[text()='%s']/preceding-sibling::th";
	public static final String VALUE_AT_ROW_NUMBER_BY_COLUMN_NAME = "xpath=//div[@class='table-wrapper']//tbody/tr[%s]/td[%s]";
	public static final String WISHLIST_SHARE_LINK = "xpath=//span[text()='Your wishlist URL for sharing:']/following-sibling::a";
}
