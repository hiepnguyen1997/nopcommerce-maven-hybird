package pageUIs.nopCommerce.admin;

public class AdminProductPageUI {
	
	public static final String SEARCH_BUTTON = "css=button#search-products";
	public static final String INDEX_COLUMN_BY_TITLE = "xpath=//div[@class='dataTables_scrollHead']//thead//th[text()='%s']/preceding-sibling::th";
	public static final String COUNTER_SEARCH_RESULT = "xpath=//div[@class='dataTables_scrollBody']//tbody/tr";
	public static final String LOADING_SEARCH_ICON = "css=div#ajaxBusy";
	public static final String VALUE_COLUMN_BY_INDE_COLUMN = "XPATH=//div[@class='dataTables_scrollBody']//tbody/tr[1]/td[%s]";
	public static final String NO_DATA_AVAILABLE_MESSAGE = "XPATH=//div[@class='dataTables_scrollBody']//tbody//td[text()='No data available in table']";
	public static final String GO_TO_PRODUCT_BY_SKU = "css=button#go-to-product-by-sku";
	
	

}
