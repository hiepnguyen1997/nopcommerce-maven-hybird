package pageUIs.nopCommerce.admin;

public class AdminPageNavigateUI {
	
	public static final String MENU_BY_NAME = "xpath=//p[normalize-space(text())='%s']/ancestor::li";
	public static final String SUB_MENU_BY_NAME = "xpath=//p[normalize-space(text())='%s']/parent::a/following-sibling::ul//p[normalize-space(text())='%s']/ancestor::a";

}
