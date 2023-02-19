package commons;

import org.openqa.selenium.WebDriver;

import pageUIs.nopCommerce.admin.AdminPageNavigateUI;

public class ListAdminMenuPageByPageName extends BasePage{
	
	WebDriver driver;
	
	public ListAdminMenuPageByPageName(WebDriver driver) {
		this.driver = driver;
	}
	
	public ListAdminMenuPageByPageName openPageInMenuByPageName(String menuName, String pageName) {
		waitForElementVisible(driver, AdminPageNavigateUI.MENU_BY_NAME, menuName);
		clickToElement(driver, AdminPageNavigateUI.MENU_BY_NAME, menuName);
		waitForElementVisible(driver, AdminPageNavigateUI.SUB_MENU_BY_NAME, menuName, pageName);
		clickToElement(driver, AdminPageNavigateUI.SUB_MENU_BY_NAME, menuName, pageName);
		switch (pageName) {
		case "Products":
			return PageGeneratorManager.getAdminProductPage(driver);
		case "Customers":
			return PageGeneratorManager.getAdminCustomerPage(driver);
		default:
			throw new RuntimeException("Invalid Page Name at Menu"); 
		}
		
	}

}
