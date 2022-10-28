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
import pageObjects.nopCommerce.portal.CompareListPageObject;
import pageObjects.nopCommerce.portal.NotebooksPageObject;
import pageObjects.nopCommerce.portal.ProductDetailPageObject;
import pageObjects.nopCommerce.portal.ShoppingCardPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.WishlistPageObject;
import pageObjects.nopCommerce.portal.WishlistShareLinkPageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;

public class NopCommerce_Wishlist_Compare_RecentReview extends BaseTest{
	private WebDriver driver;
	private String emailAddress, password, firstName, lastName, fullName;
	private String productName1, productName2, wishlistPageUrl;
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	EnvironmentConfig environmentConfig;
	ProductDetailPageObject productDetailPage;
	NotebooksPageObject notebooksPage;
	WishlistPageObject wishlistPage;
	WishlistShareLinkPageObject wishlistShareLinkPage;
	ShoppingCardPageObject shoppingCardPage;
	CompareListPageObject comparelistPage;
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) throws BrowserNotSupport{
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		driver = getBrowserDriver(browserName, environmentConfig.getWebURL());
		emailAddress = Register_Commons.emailAddress;
		password = Register_Commons.password;
		fullName = Register_Commons.firstName + " " + Register_Commons.lastName;
		productName1 = "Asus N551JK-XO076H Laptop";
		productName2 = "Samsung Series 9 NP900X4C Premium Ultrabook";
		
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
	//@Test
	public void TC_01_Add_To_Wishlist(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 01: Add to wishlist");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 01: Open Notebooks page");
		notebooksPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on product name");
		log.info("Step 02: Click on product name");
		productDetailPage = notebooksPage.clickOnProductByName(productName1);
		
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
		Assert.assertEquals(wishlistPage.getValueAtRowNumberByColumnName("1","Product(s)"), productName1);
		
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
	
	//@Test
	public void TC_02_Add_product_to_Cart_from_Wishlsit_page(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02: Add product to cart from wishlist page");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Wishlist page");
		log.info("Step 01: Open Wishlist page");
		wishlistShareLinkPage.openPageUrl(driver, wishlistPageUrl);
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on checkbox of " + productName1);
		log.info("Step 02: Click on checkbox of " + productName1);
		wishlistPage.clickOnCheckboxOfProductByName(productName1);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Add to cart button");
		log.info("Step 03: Click on Add to cart button");
		shoppingCardPage = wishlistPage.clickOnAddToCardButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the product is removed from Wishlist page and add to card");
		log.info("Step 04: Verify the product is removed from Wishlist page and add to card");
		Assert.assertEquals(shoppingCardPage.getWislistQuantity(), "(0)");
		Assert.assertTrue(shoppingCardPage.isShoppingCardTitleDisplay());
		Assert.assertEquals(shoppingCardPage.getProductAtRowNumberByName("1", "Product(s)"), productName1);
	}
	
	//@Test
	public void TC_03_Remove_product_from_Wishlist_Page(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 03: Remove product from Wishlist page");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 01: Open Notebooks page");
		notebooksPage = (NotebooksPageObject) shoppingCardPage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on product name");
		log.info("Step 02: Click on product name");
		productDetailPage = notebooksPage.clickOnProductByName(productName1);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Add to wishlist");
		log.info("Step 03: Click on Add to wishlist");
		productDetailPage.clickOnAddToWishlistButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the message add to wishlist successfull");
		log.info("Step 04: Verify the message add to wishlist successfull display");
		Assert.assertEquals(productDetailPage.getAddWishlistMessageDisplay(), "The product has been added to your wishlist");
		productDetailPage.closeAddWishlistMessage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click on Wishlist link");
		log.info("Step 05: Click on Wishlist link");
		wishlistPage = productDetailPage.clickOnWishlistLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify product: " + productName1 + " added to Wishlist");
		log.info("Step 06: Verify product: " + productName1 + " added to Wishlist");
		Assert.assertEquals(wishlistPage.getValueAtRowNumberByColumnName("1","Product(s)"), productName1);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on remove button of product: " + productName1);
		log.info("Step 07: Click on remove button of product: " + productName1);
		wishlistPage.clickOnRemoveButtonByProductName(productName1);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify the wishlist page empty message display");
		log.info("Step 08: Verify the wishlist page empty message display");
		Assert.assertTrue(wishlistPage.isPageEmptyMessageDisplay());
		
	}
	

	@Test
	public void TC_04_Add_product_to_compare(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 04: Add product to compare");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 01: Open Notebooks page");
		notebooksPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Add to compare list for: " + productName1);
		log.info("Step 02: Click on Add to compare list for: " + productName1);
		String priceProduct1 = notebooksPage.getProductPriceByProductName(productName1);
		notebooksPage.clickonAddToCompareListProductName(productName1);
		Assert.assertEquals(notebooksPage.getCompareProductMessage(), "The product has been added to your product comparison");
		notebooksPage.closeAddCompareListMessage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Add to compare list for: " + productName2);
		log.info("Step 03: Click on Add to compare list for: " + productName2);
		String priceProduct2 =notebooksPage.getProductPriceByProductName(productName2);
		notebooksPage.clickonAddToCompareListProductName(productName2);
		Assert.assertEquals(notebooksPage.getCompareProductMessage(), "The product has been added to your product comparison");
		notebooksPage.closeAddCompareListMessage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on Compare product list at footer page");
		log.info("Step 04: Click on Compare product list at footer page");
		comparelistPage = (CompareListPageObject) notebooksPage.getFooterListMenu(driver).openPageAtFooterByPageName("Compare products list");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify the product name " + productName1 + " and its price display");
		log.info("Step 05: Verify the product name " + productName1 + " and its price display");
		Assert.assertTrue(comparelistPage.removeButtonForProductByNameDisplay(productName1));
		Assert.assertTrue(comparelistPage.isProductByNameDisplay(productName1));
		Assert.assertEquals(comparelistPage.getValueAtRowNameByProductNameDisplay("Price",productName1), priceProduct1);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify the product name " + productName2 + " and its price display");
		log.info("Step 05: Verify the product name " + productName2 + " and its price display");
		Assert.assertTrue(comparelistPage.removeButtonForProductByNameDisplay(productName2));
		Assert.assertTrue(comparelistPage.isProductByNameDisplay(productName2));
		Assert.assertEquals(comparelistPage.getValueAtRowNameByProductNameDisplay("Price",productName2), priceProduct2);
	}
	
//	@AfterClass(alwaysRun = true)
//		public void afterClass() {
//		closeBrowserAndDriver();
//	}
}
