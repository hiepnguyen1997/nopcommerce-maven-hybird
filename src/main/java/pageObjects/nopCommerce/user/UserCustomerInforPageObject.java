package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.SubMenuAtMyAccountPage;
import pageUIs.nopCommerce.user.CustomerInforPageUI;

public class UserCustomerInforPageObject extends SubMenuAtMyAccountPage{
	private WebDriver driver;
	
	public UserCustomerInforPageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public String getMyAccountTitle() {
		waitForElementVisible(driver, CustomerInforPageUI.MY_ACCOUNT_PAGE_TITLE);
		return getElementText(driver, CustomerInforPageUI.MY_ACCOUNT_PAGE_TITLE);
		
	}

}
