package pageUIs.nopCommerce.admin;

public class AdminEditCustomerPageUI {
	
	public static final String SAVE_EDIT_CUSTOMER_BUTTON = "xpath=//button[normalize-space()='Save']";
	public static final String GET_NOITIFICATION_MESSAGE = "xpath=//div[@class='alert alert-success alert-dismissable']";
	public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//button[normalize-space(text())='Add new address']";
	public static final String ADDRESS_BUTTON = "css=div#customer-address";
	public static final String COLUMN_INDEX_BY_NAME_AT_ADDRESS_SECTION = "xpath=//div[text()='Addresses']/parent::div/following-sibling::div//div[@class='dataTables_scrollHead']//th[text()='%s']/preceding-sibling::th";
	public static final String VALUE_BY_COLUMN_INDEX_AT_ADDRESS_SECTION = "xpath=//div[text()='Addresses']/parent::div/following-sibling::div//div[@class='dataTables_scrollBody']//tbody/tr/td[%s]";
	
}
