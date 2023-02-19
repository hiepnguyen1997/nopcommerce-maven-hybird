package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.ListAdminMenuPageByPageName;

public class AdminDashboardPageObject extends ListAdminMenuPageByPageName{
	
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	

}
