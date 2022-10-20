package pageUIs.nopCommerce.user;

public class SearchPageUI {
	public static final String SEARCH_PAGE_TITLE = "xpath=//div[@class='page-title']//h1[text()='Search']";
	public static final String SEARCH_RESULT_PRODUCT = "xpath=//div[@class='product-item']//h2[@class='product-title']/a";
	public static final String SEARCH_TEXT_BOX = "css=div.search-page input.search-text";
	public static final String SEARCH_BUTTON = "css=div.search-page div.buttons>button";
	public static final String CATEGORY_DROPDOWNLIST = "xpath=//label[text()='Category:']/following-sibling::select";
	public static final String MANUFACTURER_DROPDOWNLIST = "xpath=//label[text()='Manufacturer:']/following-sibling::select";
	public static final String SEARCH_RESULT_MESSAGE = "css=div.search-results div.products-wrapper>div";
}
