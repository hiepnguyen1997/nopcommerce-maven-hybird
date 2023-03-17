package pageUIs.nopCommerce.admin;

public class NopCommercePageUIAdmin {
	
	public static final String LOGOUT_BUTTON = "xpath=//a[@class='nav-link' and text()='Logout']";
	public static final String TEXTBOX_BY_NAME_AT_ADMIN_PAGE = "xpath=//label[text()='%s']/parent::div/parent::div/following-sibling::div//input";
	public static final String DROPDOWN_LIST_BY_NAME_AT_ADMIN_PAGE = "xpath=//label[text()='%s']/parent::div/parent::div/following-sibling::div//select";
	public static final String RADIO_BUTTON_CHECKBOX_BY_LABEL = "xpath=//label[text()='%s']/parent::div/parent::div/following-sibling::div/input";
	public static final String GET_NOITIFICATION_MESSAGE = "xpath=//div[@class='alert alert-success alert-dismissable']";
	public static final String ADMIN_COMMENT_TEXTAREA = "xpath=//label[text()='Admin comment']/parent::div/parent::div/following-sibling::div//textarea";
	public static final String BACK_TO_CUSTOMER_LIST = "xpath=//a[text()='back to customer list']";

}
