package pageUIs.nopCommerce.user;

public class ListProductPageUI {
	public static final String PRODUCT_BY_NAME = "xpath=//h2[@class='product-title']/a[text()='%s']";
	public static final String SORT_BY_DROPDOWN = "css=select#products-orderby";
	public static final String DISPLAY_DROPDOWN = "css=select#products-pagesize";
	public static final String NEXT_PAGE_ICON = "css=li.next-page";
	public static final String PREVIOUS_PAGE_ICON = "css=li.previous-page";
	public static final String PRODUCT_NAME = "css=div.product-item h2.product-title>a";
	public static final String PRODUCT_PRICE = "css=div.product-item div.add-info>div.prices";
	public static final String PRODUCT_PRICE_BY_NAME = "xpath=//div[@class='product-item']//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']/div[@class='prices']";
	public static final String ADD_COMPARE_LIST_BUTTON_BY_PRODUCT_NAME = "xpath=//div[@class='product-item']//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//button[text()='Add to compare list']";
	public static final String ADD_COMPARE_LIST_MESSAGE = "css=div.bar-notification.success>p";
	public static final String CLOSE_ADD_COMPARE_LIST_MESSAGE = "css=div.bar-notification.success>span.close";
	public static final String PRODUCT_ITEM = "css=div.product-item";
	public static final String PRODUCT_PAGER = "css=div.pager";
}
