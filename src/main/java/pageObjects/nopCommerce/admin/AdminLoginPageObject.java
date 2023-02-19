package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{
	private WebDriver driver;
	
	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public AdminDashboardPageObject loginAsAdmin(String email, String password) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL, email);
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD, password);
		waitForElementClickabled(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}

}
