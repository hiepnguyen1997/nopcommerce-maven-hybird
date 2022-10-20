package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.portal.DesktopsPageObject;
import pageObjects.nopCommerce.portal.NotebooksPageObject;
import pageObjects.nopCommerce.portal.ProductPageObject;
import pageObjects.nopCommerce.portal.ProductPreviewPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserChangePasswordPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserSearchPageObject;

public class PageGeneratorManager {
	
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserCustomerInforPageObject getUserCustomerPage(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}
	
	public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObject(driver);
	}
	
	public static UserChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	
	public static DesktopsPageObject getDesktopsPage(WebDriver driver) {
		return new DesktopsPageObject(driver);
	}
	
	public static UserMyProductReviewPageObject getUserMyProductPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	
	public static NotebooksPageObject getNotebooksPage(WebDriver driver) {
		return new NotebooksPageObject(driver);
	}
	
	public static ProductPageObject getProductPage(WebDriver driver) {
		return new ProductPageObject(driver);
	}
	
	public static ProductPreviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductPreviewPageObject(driver);
	}
	
	public static UserSearchPageObject getSearchPageObjet(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
}
