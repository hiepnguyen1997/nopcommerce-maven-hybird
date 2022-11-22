package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.SubMenuAtMyAccountPage;
import pageUIs.nopCommerce.user.ChangePasswordUI;

public class UserChangePasswordPageObject extends SubMenuAtMyAccountPage{
	private WebDriver driver;
	
	public UserChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean isPasswordChangedMessageDisplay() {
		waitForElementVisible(driver, ChangePasswordUI.PASSWORD_CHANGED_SUCCESSFULLY_MESSAGE);
		return isElementDisplayed(driver, ChangePasswordUI.PASSWORD_CHANGED_SUCCESSFULLY_MESSAGE);
	}
	
	public void closeBarNotification() {
		waitForElementVisible(driver, ChangePasswordUI.CLOSE_BAR_NOTIFICATION);
		clickToElement(driver, ChangePasswordUI.CLOSE_BAR_NOTIFICATION);
		sleepInSecond(2);
	}
}
