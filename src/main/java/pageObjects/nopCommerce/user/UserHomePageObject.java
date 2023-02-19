package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.ListPageAtTopMenu;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.HomePageUI;

public class UserHomePageObject extends ListPageAtTopMenu {
	private WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterLink() {
		waitForElementVisible(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPage(driver);
	}

	public UserLoginPageObject clickOnLoginLink() {
		waitForElementVisible(driver, HomePageUI.LOGIN_LINK);
		waitForElementClickabled(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MYACCOUNT_LINK);
	}

	public UserCustomerInforPageObject clickOnMyAccountLink() {
		waitForElementVisible(driver, HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}
	
	public boolean isOrderSuccessfullMessageDisplayed() {
		waitForElementVisible(driver, HomePageUI.ORDER_SUCCESSFULL_MESSAGE);
		return isElementDisplayed(driver, HomePageUI.ORDER_SUCCESSFULL_MESSAGE);
	}
	
	public boolean isOrderNumberDisplayed() {
		waitForElementVisible(driver, HomePageUI.ORDER_NUMBER);
		return isElementDisplayed(driver, HomePageUI.ORDER_NUMBER);
	}
	
	public String getOrderNumber() {
		waitForElementVisible(driver, HomePageUI.ORDER_NUMBER);
		String tempOrderNumber = getElementText(driver, HomePageUI.ORDER_NUMBER);
		String[] orderNumber = tempOrderNumber.split(":");
		return orderNumber[1].trim();
	}

}
