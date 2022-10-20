package pageUIs.nopCommerce.user;

public class BasePageUINopCommerce {
	public static final String CUSTOMER_INFOR_LINK = "XPath=//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESS_LINK = "XPath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String CHANGE_PASSWORD_LINK = "XPath=//div[contains(@class,'account-navigation')]//a[text()='Change password']";
	public static final String REWARD_POINTS_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String MY_PRODUCT_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String LOGOUT_LINK_USER = "Css=a.ico-logout";
	public static final String LOGOUT_LINK_ADMIN = "XPATH=//a[text()='Logout']";
	public static final String FOOTER_SEARCH_PAGE = "XPATH=//div[@class='footer']//a[text()='Search']";
	public static final String PAGE_AT_FOOTER_BY_NAME = "XPATH=//div[@class='footer']//a[text()='%s']";
	
	//pattern object
	
	public static final String TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DROPDOWN_LIST_BY_NAME = "xpath=//select[@name='%s']";
	public static final String BUTTON_BY_NAME = "xpath=//button[text()='%s']";
	public static final String RADIO_BUTTON_BY_LABEL_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String TOP_MENU_BY_NAME = "xpath=//ul[@class='top-menu notmobile']//a[normalize-space(text())='%s']";
	public static final String SUB_MENU_BY_NAME = "xpath=//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a[normalize-space(text())='%s']";
}
