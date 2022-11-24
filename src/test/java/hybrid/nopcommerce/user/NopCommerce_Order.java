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
import hybrid.nopcommerce.commons.Register_Commons;
import pageObjects.nopCommerce.portal.DesktopsPageObject;
import pageObjects.nopCommerce.portal.ProductDetailPageObject;
import pageObjects.nopCommerce.portal.ShoppingCardPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;

public class NopCommerce_Order extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private DesktopsPageObject desktopPage;
	private ProductDetailPageObject productDetailPage;
	private ShoppingCardPageObject shoppingCartPage;
	private EnvironmentConfig environmentConfig;
	private String email, password;
	private String productName, processer, RAM, HDD, OS, softwareMicrosoftOffice, softwareAcrobatReader, softwareTotalCommander, price;
	private String  processerEdit, RAMEdit, HDDEdit, OSEdit, quantityProduct;
	
	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		email = Register_Commons.emailAddress;
		password = Register_Commons.password;
		productName = "Build your own computer";
		processerEdit = "2.2 GHz Intel Pentium Dual-Core E2200";
		processer = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		RAM = "8GB [+$60.00]";
		RAMEdit = "4GB [+$20.00]";
		HDD = "400 GB [+$100.00]";
		HDDEdit = "320 GB";
		OS = "Vista Premium [+$60.00]";
		OSEdit = "Vista Home [+$50.00]";
		softwareAcrobatReader = "Acrobat Reader [+$10.00]";
		softwareMicrosoftOffice = "Microsoft Office [+$50.00]";
		softwareTotalCommander = "Total Commander [+$5.00]";
		quantityProduct = "3";
		
		driver = getBrowserDriverMananment(browserName, environmentConfig.getWebURL());
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Pre-Conditions: Click on Login link");
		userLoginPage = homePage.clickOnLoginLink();
		
		log.info("Pre-Conditions: Input to email: " + email);
		userLoginPage.inputToEmailTextBox(email);
		
		log.info("Pre-Conditions: Input to password: " + password);
		userLoginPage.inputToPasswordTextBox(password);
		
		log.info("Pre-Conditions: Click on Login button");
		homePage = userLoginPage.clickOnLoginButton();
		
		log.info("Pre-Conditions: Verify login successfull");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	@Test
	public void TC_01_Add_product_to_cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 01: Add product to cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Desktop page");
		log.info("Step 01: Open Desktop page");
		desktopPage = (DesktopsPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Desktops");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on product name: " + productName);
		log.info("Step 02: Click on product name: " + productName);
		productDetailPage = desktopPage.clickOnProductByName(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select Processer: " + processer);
		log.info("Step 03: Select Processer: " + processer);
		productDetailPage.seclectItemInProcesserDropdown(processer);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select RAM: " + RAM);
		log.info("Step 04: Select RAM: " + RAM);
		productDetailPage.seclectItemInRAMDropdown(RAM);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Select HDD: " + HDD);
		log.info("Step 05: Select HDD: " + HDD);
		productDetailPage.checkToHDDRadioButton(HDD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select OS: " + OS);
		log.info("Step 06: Select HDD: " + OS);
		productDetailPage.checkOSRadioButton(OS);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Check to checkbox of Software: " + softwareAcrobatReader);
		log.info("Step 07: Check to checkbox of Software: " + softwareAcrobatReader);
		productDetailPage.checkToSoftwareCheckbox(softwareAcrobatReader);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Check to checkbox of Software: " + softwareTotalCommander);
		log.info("Step 08: Check to checkbox of Software: " + softwareAcrobatReader);
		productDetailPage.checkToSoftwareCheckbox(softwareTotalCommander);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify the Software: " + softwareMicrosoftOffice + " is checked by default");
		log.info("Step 09: Verify the Software: " + softwareMicrosoftOffice + " is checked by default");
		Assert.assertTrue(productDetailPage.isSoftwareCheckSelectedByDefault(softwareMicrosoftOffice));;
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Get total price");
		log.info("Step 10: Get total price");
		price = productDetailPage.getTotalPrice();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Click on Add to cart");
		log.info("Step 11: Click on Add to cart");
		productDetailPage.clickOnAddToCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify the message The product has been added to your shopping cart");
		log.info("Step 12: Verify the message The product has been added to your shopping cart");
		Assert.assertEquals(productDetailPage.getProductAddToCartMessage(), "The product has been added to your shopping cart");
		productDetailPage.closeNoitificationMessage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Get text and verify the number of Shopping Cart");
		log.info("Step 13: Get text and verify the number of Shopping Cart");
		Assert.assertEquals(productDetailPage.getCountNumberOfShoppingCart(driver), "(1)");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Click on Shopping Cart");
		log.info("Step 14: Click on Shopping Cart");
		shoppingCartPage = productDetailPage.clickOnShoppingCartLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Verify the product display correctly in Shopping Cart");
		log.info("Step 15: Verify the product display correctly in Shopping Cart");
		Assert.assertEquals(shoppingCartPage.getProductNameAtRowNumberByColumnName("1", "Product(s)"), productName);
		Assert.assertEquals(shoppingCartPage.getProductAttributeAtRowNumberByColumnName("1", "Product(s)"), "Processor: " + processer+ "\nRAM: " + RAM + "\nHDD: " + HDD + "\nOS: " + OS + "\nSoftware: " + softwareMicrosoftOffice + "\nSoftware: " + softwareAcrobatReader + "\nSoftware: " + softwareTotalCommander);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Price"), price);
		
	}
	
	@Test
	public void TC_02_Edit_product_in_Shopping_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02: Edit product in Shopping Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Access Shopping Cart");
		log.info("Step 01: Access Shopping Cart");
		shoppingCartPage = homePage.clickOnShoppingCartLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Edit link");
		log.info("Step 02: Click on Edit link");
		productDetailPage = shoppingCartPage.clickOnEditProductAtRowNumberByColmnName("1", "Product(s)");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Edit processer by: " + processerEdit);
		log.info("Step 03: Edit processer by: " + processerEdit);
		productDetailPage.seclectItemInProcesserDropdown(processerEdit);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Edit RAM by: " + RAMEdit);
		log.info("Step 04: Edit RAM by: " + RAMEdit);
		productDetailPage.seclectItemInRAMDropdown(RAMEdit);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Edit HDD by: " + HDDEdit);
		log.info("Step 05: Edit HDD by: " + HDDEdit);
		productDetailPage.checkToHDDRadioButton(HDDEdit);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Edit OS by: " + OSEdit);
		log.info("Step 06: Edit OS by: " + OSEdit);
		productDetailPage.checkOSRadioButton(OSEdit);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Unselect software: " + softwareAcrobatReader + " and " + softwareTotalCommander);
		log.info("Step 07: Unselect software: " + softwareAcrobatReader + " and " + softwareTotalCommander);
		productDetailPage.unCheckToSoftwareCheckbox(softwareAcrobatReader);
		productDetailPage.unCheckToSoftwareCheckbox(softwareTotalCommander);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Get total price");
		log.info("Step 08: Get total price");
		price = productDetailPage.getTotalPrice();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Increase the number of product to 2");
		log.info("Step 09: Increase the number of product to 2");
		productDetailPage.inputToNumberQuantityProduct(quantityProduct);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Click on Update Button");
		log.info("Step 11: Click on Update Button");
		productDetailPage.clickOnUpdateButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify the message The product has been added to your shopping cart");
		log.info("Step 12: Verify the message The product has been added to your shopping cart");
		Assert.assertEquals(productDetailPage.getProductAddToCartMessage(), "The product has been added to your shopping cart");
		productDetailPage.closeNoitificationMessage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Get text and verify the number of Shopping Cart");
		log.info("Step 13: Get text and verify the number of Shopping Cart");
		Assert.assertEquals(productDetailPage.getCountNumberOfShoppingCart(driver), "(" + quantityProduct + ")");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Click on Shopping Cart");
		log.info("Step 14: Click on Shopping Cart");
		shoppingCartPage = productDetailPage.clickOnShoppingCartLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Verify the product display correctly in Shopping Cart");
		log.info("Step 15: Verify the product display correctly in Shopping Cart");
		Assert.assertEquals(shoppingCartPage.getProductNameAtRowNumberByColumnName("1", "Product(s)"), productName);
		Assert.assertEquals(shoppingCartPage.getProductAttributeAtRowNumberByColumnName("1", "Product(s)"), "Processor: " + processerEdit + "\nRAM: " + RAMEdit + "\nHDD: " + HDDEdit + "\nOS: " + OSEdit + "\nSoftware: " + softwareMicrosoftOffice);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Price"), price);
		Assert.assertEquals(shoppingCartPage.getAttributeValueAtRowNumberByColumnName("1", "Qty.", "value"), quantityProduct);
		Assert.assertEquals(shoppingCartPage.getTotalPriceAtShoppingCart("1", "Total"), shoppingCartPage.totalPriceOfProduct(price, quantityProduct));
		
	}
	
	@Test
	public void TC_03_Remove_from_cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 03 - Remove product from cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click on Shopping Cart link");
		log.info("Step 01: Click on Shopping Cart link");
		shoppingCartPage = homePage.clickOnShoppingCartLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Remove button by Product Name");
		log.info("Step 02: Click on Remove button by Product Name");
		shoppingCartPage.clickOnRemoveButtonByProductName(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the shopping cart is empty");
		log.info("Step 03: Verify the shopping cart is empty");
		Assert.assertTrue(shoppingCartPage.isShoppingCartEmptyMessage());
		Assert.assertTrue(shoppingCartPage.isProductByNameUnDisplay(productName));
		
	}
	
//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//		closeBrowserAndDriver();
//	}
}
