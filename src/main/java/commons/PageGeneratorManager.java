package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.admin.AdminCustomerPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductDetailPageObject;
import pageObjects.nopCommerce.admin.AdminProductPageObject;
import pageObjects.nopCommerce.user.CheckoutPageObject;
import pageObjects.nopCommerce.user.CompareListPageObject;
import pageObjects.nopCommerce.user.DesktopsPageObject;
import pageObjects.nopCommerce.user.NotebooksPageObject;
import pageObjects.nopCommerce.user.OrderPageObject;
import pageObjects.nopCommerce.user.ProductDetailPageObject;
import pageObjects.nopCommerce.user.ProductPreviewPageObject;
import pageObjects.nopCommerce.user.RecentlyViewProductPageObject;
import pageObjects.nopCommerce.user.ShoppingCardPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserChangePasswordPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import pageObjects.nopCommerce.user.WishlistPageObject;
import pageObjects.nopCommerce.user.WishlistShareLinkPageObject;

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
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static final AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static final AdminProductPageObject getAdminProductPage(WebDriver driver) {
		return new AdminProductPageObject(driver);
	}
	
	public static final AdminProductDetailPageObject getAdminProductDetailPage(WebDriver driver) {
		return new AdminProductDetailPageObject(driver);
	}
	
	public static final AdminCustomerPageObject getAdminCustomerPage(WebDriver driver) {
		return new AdminCustomerPageObject(driver);
	}
	
}
