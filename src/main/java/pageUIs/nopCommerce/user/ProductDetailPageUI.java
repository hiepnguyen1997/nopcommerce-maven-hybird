package pageUIs.nopCommerce.user;

public class ProductDetailPageUI {
	public static final String ADD_YOUR_REVIEW = "xpath=//a[text()='Add your review']";
	public static final String ADD_TO_WISHLIST = "xpath=//button[text()='Add to wishlist']";
	public static final String ADD_TO_CART = "xpath=//button[text()='Add to cart']";
	public static final String BAR_NOITIFICATION = "xpath=//div[@id='bar-notification']//p[@class='content']";
	public static final String CLOSE_BAR_NOITIFICATION = "xpath=//div[@id='bar-notification']//span[@class='close']";
	public static final String PROCESSER_DROPDOWN_LIST = "xpath=//label[normalize-space(text())='Processor']/parent::dt/following-sibling::dd[1]/select";
	public static final String RAM_DROPDOWN_LIST = "xpath=//label[normalize-space(text())='RAM']/parent::dt/following-sibling::dd[1]/select";
	public static final String HDD_RADIO_BUTTON = "xpath=//label[normalize-space(text())='HDD']/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input";
	public static final String OS_RADIO_BUTTON = "xpath=//label[normalize-space(text())='OS']/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input";
	public static final String SOFTWARE_CHECKBOX = "xpath=//label[normalize-space(text())='Software']/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input";
	public static final String PRODUCT_PRICE = "CSS=div.product-price>span";
}
