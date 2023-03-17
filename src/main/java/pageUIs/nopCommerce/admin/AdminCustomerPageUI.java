package pageUIs.nopCommerce.admin;

public class AdminCustomerPageUI {
	
	public static final String ADD_NEW_CUSTOMER_BUTTON = "xpath=//a[@class='btn btn-primary' and normalize-space()='Add new']";
	public static final String SAVE_AND_CONTINUE_BUTTON = "xpath=//button[@name='save-continue' and normalize-space()='Save and Continue Edit']";
	public static final String BACK_TO_CUSTOMER_LIST = "xpath=//a[text()='back to customer list']";
	public static final String CUSTOMER_ROLE_DROPDOWN_LIST_CREATE = "xpath=//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div//div[@class='input-group']";
	public static final String CUSTOMER_ROLE_DROPDOWN_LIST_SEARCH = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div";
	public static final String LIST_CUSTOMER_ROLE = "CSS=ul#SelectedCustomerRoleIds_listbox li";
	public static final String REMOVE_REGISTER_ROLE = "xpath=//span[text()='Registered']/following-sibling::span";
	public static final String REMOVE_CUSTOMER_ROLE_BY_NAME = "xpath=//span[text()='%s']/following-sibling::span";
	public static final String CUSTOMER_ROLE_BY_NAME_IS_SELECTED = "xpath=//span[text()='%s']/parent::li";
	public static final String GET_NUMBER_PAGINATE = "XPATH=//a[text()='…']/parent::li/following-sibling::li[1]/a";
	public static final String SEARCH_CUSTOMER_BUTTON = "css=button#search-customers";
	public static final String ALL_RESULT_AT_SEARCH_TABLE = "css=div.dataTables_scrollBody>table>tbody>tr";
	public static final String LOADING_SEARCH_ICON = "css=div#ajaxBusy";
	public static final String EDIT_BUTTON = "xpath=//a[@class='btn btn-default']";

}
