package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.portal.CheckoutPageObject;
import pageObjects.nopCommerce.portal.CompareListPageObject;
import pageObjects.nopCommerce.portal.DesktopsPageObject;
import pageObjects.nopCommerce.portal.NotebooksPageObject;
import pageObjects.nopCommerce.portal.OrderPageObject;
import pageObjects.nopCommerce.portal.ProductDetailPageObject;
import pageObjects.nopCommerce.portal.ProductPreviewPageObject;
import pageObjects.nopCommerce.portal.RecentlyViewProductPageObject;
import pageObjects.nopCommerce.portal.ShoppingCardPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserChangePasswordPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import pageObjects.nopCommerce.portal.UserSearchPageObject;
import pageObjects.nopCommerce.portal.WishlistPageObject;
import pageObjects.nopCommerce.portal.WishlistShareLinkPageObject;

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
	
	public static ProductDetailPageObject getProductPage(WebDriver driver) {
		return new ProductDetailPageObject(driver);
	}
	
	public static ProductPreviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductPreviewPageObject(driver);
	}
	
	public static UserSearchPageObject getSearchPageObjet(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	
	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);
	}
	
	public static WishlistShareLinkPageObject getWishlistShareLinkPage(WebDriver driver) {
		return new WishlistShareLinkPageObject(driver);
	}
	
	public static ShoppingCardPageObject getShoppingCardPage(WebDriver driver) {
		return new ShoppingCardPageObject(driver);
	}
	
	public static CompareListPageObject getCompareListPage(WebDriver driver) {
		return new CompareListPageObject(driver);
	}
	
	public static RecentlyViewProductPageObject getRecentlyViewPage(WebDriver driver) {
		return new RecentlyViewProductPageObject(driver);
	}
	
	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}
	
	public static OrderPageObject getOrderPage(WebDriver driver) {
		return new OrderPageObject(driver);
	}
	
	public static AdminLoginPageObject getLoginPageAdmin(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
}
