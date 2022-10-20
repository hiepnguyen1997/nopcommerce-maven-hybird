package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserChangePasswordPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;

public class SubMenuAtMyAccountPage extends BasePage{
	private WebDriver driver;
	
	public SubMenuAtMyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserCustomerInforPageObject openCustomerInforPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.CUSTOMER_INFOR_LINK);
		clickToElement(driver, BasePageUINopCommerce.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerPage(driver);
	}
	
	public UserAddressPageObject openAddressPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.ADDRESS_LINK);
		clickToElement(driver, BasePageUINopCommerce.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressPage(driver);
	}
	
	public UserChangePasswordPageObject openChangePasswordPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUINopCommerce.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getChangePasswordPage(driver);
	}
	
	public UserMyProductReviewPageObject openMyProductPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.MY_PRODUCT_LINK);
		clickToElement(driver, BasePageUINopCommerce.MY_PRODUCT_LINK);
		return PageGeneratorManager.getUserMyProductPage(driver);
	}

}
