package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.LoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	
	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public UserHomePageObject clickOnLoginButton() {
		waitForElementClickabled(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getErrorMessageEmailTexbox() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_EMAIL_TEXT_BOX);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_EMAIL_TEXT_BOX);
	}


	public String getInvalidErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.ERROR_MESSAGE_COMMON);
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_COMMON);
	}

	public void inputToPasswordTextBox(String value) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, value);
	}

	public void inputToEmailTextBox(String value) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, value);
	}

	public UserHomePageObject loginAsUser(String emailValue, String password) {
		inputToEmailTextBox(emailValue);
		inputToPasswordTextBox(password);
		return clickOnLoginButton();
	}
}
