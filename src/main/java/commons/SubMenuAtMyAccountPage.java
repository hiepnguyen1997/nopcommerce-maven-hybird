package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.user.OrderPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageUIs.nopCommerce.user.NopCommercePageUIUser;

public class SubMenuAtMyAccountPage extends BasePage{
	private WebDriver driver;
	
	public SubMenuAtMyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserCustomerInforPageObject openCustomerInforPage() {
		waitForElementVisible(driver, NopCommercePageUIUser.CUSTOMER_INFOR_LINK);
		clickToElement(driver, NopCommercePageUIUser.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}
	
	public UserAddressPageObject openAddressPage() {
		waitForElementVisible(driver, NopCommercePageUIUser.ADDRESS_LINK);
		clickToElement(driver, NopCommercePageUIUser.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserChangePasswordPageObject openChangePasswordPage() {
		waitForElementVisible(driver, NopCommercePageUIUser.CHANGE_PASSWORD_LINK);
		clickToElement(driver, NopCommercePageUIUser.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getChangePasswordPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductPage() {
		waitForElementVisible(driver, NopCommercePageUIUser.MY_PRODUCT_LINK);
		clickToElement(driver, NopCommercePageUIUser.MY_PRODUCT_LINK);
		return PageGeneratorManager.getUserMyProductPage(driver);
	}
	
	public OrderPageObject openOrderPage() {
		waitForElementVisible(driver, NopCommercePageUIUser.ORDER_LINK);
		clickToElement(driver, NopCommercePageUIUser.ORDER_LINK);
		return PageGeneratorManager.getOrderPage(driver);
	}

}
