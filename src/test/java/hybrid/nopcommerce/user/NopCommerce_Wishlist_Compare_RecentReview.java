package hybrid.nopcommerce.user;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import exception.BrowserNotSupport;
import hybrid.nopcommerce.commons.Register_Commons;
import pageObjects.nopCommerce.portal.NotebooksPageObject;
import pageObjects.nopCommerce.portal.ProductDetailPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.WishlistPageObject;
import pageObjects.nopCommerce.portal.WishlistShareLinkPageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;

public class NopCommerce_Wishlist_Compare_RecentReview extends BaseTest{
	private WebDriver driver;
	private String emailAddress, password, firstName, lastName, fullName;
	private String productName, wishlistPageUrl;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	EnvironmentConfig environmentConfig;
	ProductDetailPageObject productDetailPage;
	NotebooksPageObject notebooksPage;
	WishlistPageObject wishlistPage;
	WishlistShareLinkPageObject wishlistShareLinkPage;
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) throws BrowserNotSupport{
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		driver = getBrowserDriver(browserName, environmentConfig.getWebURL());
		emailAddress = Register_Commons.emailAddress;
		password = Register_Commons.password;
		fullName = Register_Commons.firstName + " " + Register_Commons.lastName;
		productName = "Asus N551JK-XO076H Laptop";
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		log.info("Pre Conditions: Step 01 - Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		
		log.info("Pre Conditions: Step 02 - Input to email by: " + emailAddress);
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Pre Conditions: Step 03 - Input to password by: " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Pre Conditions: Step 04 - Click on Login button");
		homePage = loginPage.clickOnLoginButton();
		
		log.info("Pre Conditions: Step 05 - Verify login successfull");
		homePage.isMyAccountLinkDisplayed();
	}
	@Test
	public void TC_01_Add_To_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 01: Add to wishlist");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 01: Open Notebooks page");
		notebooksPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on product name");
		log.info("Step 02: Click on product name");
		productDetailPage = notebooksPage.clickOnProductByName(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Add to wishlist");
		log.info("Step 03: Click on Add to wishlist");
		productDetailPage.clickOnAddToWishlistButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the message add to wishlist successfull");
		log.info("Step 04: Verify the message add to wishlist successfull display");
		Assert.assertEquals(productDetailPage.getAddWishlistMessageDisplay(), "The product has been added to your wishlist");
		productDetailPage.closeAddWishlistMessage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 05: Click on Wishlist link");
		wishlistPage = productDetailPage.clickOnWishlistLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 06: Verify product: " + " added to Wishlist");
		Assert.assertEquals(wishlistPage.getValueAtRowNumberByColumnName("1","Product(s)"), productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 07: Verify the share wishlist link display");
		Assert.assertTrue(wishlistPage.isShareWishlistLinkDisplay());
		wishlistPageUrl = wishlistPage.getPageUrl(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 08: Click on share wishlist link");
		wishlistShareLinkPage= wishlistPage.clickOnShareWishlistLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 09: Verify the wishlist of " + fullName + " is display");
		Assert.assertTrue(wishlistShareLinkPage.isWishlistByUserNameDisplay(fullName));
		
	}
	
	@AfterClass(alwaysRun = true)
		public void afterClass() {
		closeBrowserAndDriver();
	}
}
