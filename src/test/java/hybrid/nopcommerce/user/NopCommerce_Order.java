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
import pageObjects.nopCommerce.portal.CheckoutPageObject;
import pageObjects.nopCommerce.portal.DesktopsPageObject;
import pageObjects.nopCommerce.portal.NotebooksPageObject;
import pageObjects.nopCommerce.portal.OrderPageObject;
import pageObjects.nopCommerce.portal.ProductDetailPageObject;
import pageObjects.nopCommerce.portal.ShoppingCardPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;
import utilities.FakeDataHelper;

public class NopCommerce_Order extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject userLoginPage;
	private DesktopsPageObject desktopPage;
	private NotebooksPageObject notebooksPage;
	private ProductDetailPageObject productDetailPage;
	private ShoppingCardPageObject shoppingCartPage;
	private CheckoutPageObject checkoutPage;
	private UserCustomerInforPageObject customerPage;
	private OrderPageObject orderPage;

	private FakeDataHelper fakeData;
	private EnvironmentConfig environmentConfig;
	private String email, password;
	private String productName1, productName2, productName3, processer, RAM, HDD, OS, softwareMicrosoftOffice, softwareAcrobatReader, softwareTotalCommander, price;
	private String processerEdit, RAMEdit, HDDEdit, OSEdit, quantityProduct1, quantityProduct2;
	private String giftWrappingOption, shiptoCountry, shiptoProvince, shiptoZipcode;
	private String company, country, city, address1, address2, zipCode, phoneNumber, faxNumber;
	private String firstname_2, lastname_2, email_2, company_2, country_2, city_2, address1_2, address2_2, zipCode_2, phoneNumber_2, faxNumber_2;
	private String shippingMethod_1, shippingMethod_2, paymentMethod_1, paymentMethod_2;
	private String creditCard, cardHolderName, cardNumber, expirationYear, expirationMonth, cardCode;
	private String orderNumber, orderDate, orderStatus;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		fakeData = FakeDataHelper.getFakeDataHelper();
		email = Register_Commons.emailAddress;
		password = Register_Commons.password;
		productName1 = "Build your own computer";
		productName2 = "Lenovo IdeaCentre 600 All-in-One PC";
		productName3 = "Apple MacBook Pro 13-inch";
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
		quantityProduct1 = "3";
		quantityProduct2 = "5";
		giftWrappingOption = "No";
		shiptoCountry = "Viet Nam";
		shiptoProvince = "Other";
		shiptoZipcode = fakeData.getZipCode();
		company = fakeData.getCompany();
		country = "Viet Nam";
		city = fakeData.getCity();
		address1 = fakeData.getAddress();
		address2 = fakeData.getAddress();
		zipCode = fakeData.getZipCode();
		phoneNumber = fakeData.getPhoneNumber();
		faxNumber = fakeData.getPhoneNumber();
		firstname_2 = fakeData.getFirstName();
		lastname_2 = fakeData.getLastName();
		email_2 = fakeData.getEmailAddress();
		company_2 = fakeData.getCompany();
		country_2 = "Brazil";
		city_2 = fakeData.getCity();
		address1_2 = fakeData.getAddress();
		address2_2 = fakeData.getAddress();
		zipCode_2 = fakeData.getZipCode();
		phoneNumber_2 = fakeData.getPhoneNumber();
		faxNumber_2 = fakeData.getPhoneNumber();
		shippingMethod_1 = "Next Day Air ($0.00)";
		shippingMethod_2 = "2nd Day Air ($0.00)";
		paymentMethod_1 = "Credit Card";
		paymentMethod_2 = "Check / Money Order";
		creditCard = "Master card";
		cardHolderName = "BIDV";
		cardNumber = fakeData.getCardNumber();
		expirationMonth = "08";
		expirationYear = "2023";
		cardCode = String.valueOf(generatorNumber());
		orderStatus = "Pending";
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

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on product name: " + productName1);
		log.info("Step 02: Click on product name: " + productName1);
		productDetailPage = desktopPage.clickOnProductByName(productName1);

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
		Assert.assertTrue(productDetailPage.isSoftwareCheckSelectedByDefault(softwareMicrosoftOffice));
		;

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
		Assert.assertEquals(shoppingCartPage.getProductNameAtRowNumberByColumnName("1", "Product(s)"), productName1);
		Assert.assertEquals(shoppingCartPage.getProductAttributeAtRowNumberByColumnName("1", "Product(s)"),
				"Processor: " + processer + "\nRAM: " + RAM + "\nHDD: " + HDD + "\nOS: " + OS + "\nSoftware: " + softwareMicrosoftOffice + "\nSoftware: " + softwareAcrobatReader + "\nSoftware: " + softwareTotalCommander);
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
		productDetailPage.inputToNumberQuantityProduct(quantityProduct1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Click on Update Button");
		log.info("Step 11: Click on Update Button");
		productDetailPage.clickOnUpdateButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify the message The product has been added to your shopping cart");
		log.info("Step 12: Verify the message The product has been added to your shopping cart");
		Assert.assertEquals(productDetailPage.getProductAddToCartMessage(), "The product has been added to your shopping cart");
		productDetailPage.closeNoitificationMessage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Get text and verify the number of Shopping Cart");
		log.info("Step 13: Get text and verify the number of Shopping Cart");
		Assert.assertEquals(productDetailPage.getCountNumberOfShoppingCart(driver), "(" + quantityProduct1 + ")");

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Click on Shopping Cart");
		log.info("Step 14: Click on Shopping Cart");
		shoppingCartPage = productDetailPage.clickOnShoppingCartLink(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Verify the product display correctly in Shopping Cart");
		log.info("Step 15: Verify the product display correctly in Shopping Cart");
		Assert.assertEquals(shoppingCartPage.getProductNameAtRowNumberByColumnName("1", "Product(s)"), productName1);
		Assert.assertEquals(shoppingCartPage.getProductAttributeAtRowNumberByColumnName("1", "Product(s)"), "Processor: " + processerEdit + "\nRAM: " + RAMEdit + "\nHDD: " + HDDEdit + "\nOS: " + OSEdit + "\nSoftware: " + softwareMicrosoftOffice);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Price"), price);
		Assert.assertEquals(shoppingCartPage.getAttributeValueAtRowNumberByColumnName("1", "Qty.", "value"), quantityProduct1);
		Assert.assertEquals(shoppingCartPage.getTotalPriceAtShoppingCart("1", "Total"), shoppingCartPage.totalPriceOfProduct(price, quantityProduct1));

	}

	@Test
	public void TC_03_Remove_from_cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 03 - Remove product from cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click on Shopping Cart link");
		log.info("Step 01: Click on Shopping Cart link");
		shoppingCartPage = homePage.clickOnShoppingCartLink(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Remove button by Product Name");
		log.info("Step 02: Click on Remove button by Product Name");
		shoppingCartPage.clickOnRemoveButtonByProductName(productName1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the shopping cart is empty");
		log.info("Step 03: Verify the shopping cart is empty");
		Assert.assertTrue(shoppingCartPage.isShoppingCartEmptyMessage());
		Assert.assertTrue(shoppingCartPage.isProductByNameUnDisplay(productName1));

	}

	@Test
	public void TC_04_Update_Shopping_cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 04 - Update shopping cart");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Desktops page");
		log.info("Step 01: Open Desktops page");
		desktopPage = (DesktopsPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Desktops");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Add to cart for product: " + productName2);
		log.info("Step 02: Click on Add to cart for product: " + productName2);
		desktopPage.clickOnAddToCartByProductName(driver, productName2);
		String price = desktopPage.getProductPriceByProductName(productName2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the message add to cart display");
		log.info("Step 03: Verify the message add to cart display");
		Assert.assertEquals(desktopPage.getNoitificationBarMessage(), "The product has been added to your shopping cart");
		desktopPage.closeNoitificationBarMessage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on Shopping cart link");
		log.info("Step 04: Click on Shopping cart link");
		shoppingCartPage = desktopPage.clickOnShoppingCartLink(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify the infomation of product display correctly");
		log.info("Step 05: Verify the infomation of product display correctly");
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Product(s)"), productName2);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Price"), price);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Change the quantity: " + quantityProduct2);
		log.info("Step 06: Change the quantity: " + quantityProduct2);
		shoppingCartPage.inputToQtyByProductName(quantityProduct2, "1", "Qty.");

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click Update shopping cart button");
		log.info("Step 07: Click Update shopping cart button");
		shoppingCartPage.clickOnUpdateShoppingCart();
		Assert.assertEquals(shoppingCartPage.getCountNumberOfShoppingCart(driver), "(" + quantityProduct2 + ")");

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: verify the total price is $2,500.00");
		log.info("Step 08: verify the total price is $2,500.00");
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Total"), "$2,500.00");
		shoppingCartPage.clickOnRemoveButtonByProductName(productName2);
	}

	@Test
	public void TC_05_Checkout_Order_Payment_Method_By_Cart(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 05: Checkout-Order");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 01: Open Notebooks page");
		notebooksPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Add to cart for product: " + productName3);
		log.info("Step 02: Click on Add to cart for product: " + productName3);
		productDetailPage = notebooksPage.clickOnProductByName(productName3);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Add to cart at product detail page");
		log.info("Step 03: Click on Add to cart at product detail page");
		productDetailPage.clickOnAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the product has been add to shopping cart message display");
		log.info("Step 04: Verify the product has been add to shopping cart message display");
		Assert.assertEquals(productDetailPage.getProductAddToCartMessage(), "The product has been added to your shopping cart");
		productDetailPage.closeNoitificationMessage();
		String price = productDetailPage.getTotalPrice();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click on Shopping Cart link");
		log.info("Step 05: Click on Shopping Cart link");
		shoppingCartPage = productDetailPage.clickOnShoppingCartLink(driver);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Product(s)"), productName3);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Price"), price);
		String quantityProd = shoppingCartPage.getAttributeValueAtRowNumberByColumnName("1", "Qty.", "value");
		Assert.assertEquals(shoppingCartPage.totalPriceOfProduct(price, quantityProd), shoppingCartPage.getTotalPriceAtShoppingCart("1", "Total"));

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select the No option on Gift wrapping");
		log.info("Step 06: Select the No option on Gift wrapping");
		shoppingCartPage.selectValueInGiftWrapping(giftWrappingOption);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on Estimate shipping button");
		log.info("Step 07: Click on Estimate shipping button");
		shoppingCartPage.clickOnEstimateShippingButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Select Country in Ship to popup: " + shiptoCountry);
		log.info("Step 08: Select Country in Ship to popup: " + shiptoCountry);
		shoppingCartPage.selectCountryInShipToPopup(shiptoCountry);

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Select Province in Ship to popup: " + shiptoProvince);
		log.info("Step 09: Select Province in Ship to popup: " + shiptoProvince);
		shoppingCartPage.selectProvinceInShipToPopup(shiptoProvince);

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input to Zip/Postal Code textbox: " + shiptoZipcode);
		log.info("Step 10: Input to Zip/Postal Code textbox: " + shiptoZipcode);
		shoppingCartPage.inputToZipCodeInShipToPopup(shiptoZipcode);

		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Click on Apply button");
		log.info("Step 11: Click on Apply button");
		shoppingCartPage.clickOnApplyButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Check to I agree with condition checkbox");
		log.info("Step 12: Check to I agree with condition checkbox");
		shoppingCartPage.checkToAgreeConditionCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Click on Checkout button");
		log.info("Step 13: Click on Checkout button");
		checkoutPage = shoppingCartPage.clickOnCheckoutButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Input to Company textbox: " + company);
		log.info("Step 14: Input to Company textbox: " + company);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Company", company);

		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Select value in Country dropdown: " + country);
		log.info("Step 15: Select value in Country dropdown: " + country);
		checkoutPage.selectValueInDropDownByName(driver, "BillingNewAddress.CountryId", country);

		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Input to City textbox: " + city);
		log.info("Step 16: Input to City textbox: " + city);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_City", city);

		ExtentTestManager.getTest().log(Status.INFO, "Step 17: Input to Address 1 textbox: " + address1);
		log.info("Step 17: Input to Address 1 textbox: " + address1);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address1", address1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 18: Input to Address 2 textbox: " + address2);
		log.info("Step 18: Input to Address 2 textbox: " + address2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address2", address2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 19: Input to ZipCode textbox: " + zipCode);
		log.info("Step 19: Input to ZipCode textbox: " + zipCode);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zipCode);

		ExtentTestManager.getTest().log(Status.INFO, "Step 20: Input to Phone number textbox: " + phoneNumber);
		log.info("Step 20: Input to Phone number textbox: " + phoneNumber);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_PhoneNumber", phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 21: Input to Fax number textbox: " + faxNumber);
		log.info("Step 21: Input to Fax number textbox: " + faxNumber);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_FaxNumber", String.valueOf(faxNumber));

		ExtentTestManager.getTest().log(Status.INFO, "Step 22: Click on Continue button");
		log.info("Step 22: Click on Continue button");
		checkoutPage.clickOnContinueButtonByStepTitle("Billing address");

		ExtentTestManager.getTest().log(Status.INFO, "Step 23: Select Shipping method: " + shippingMethod_1);
		log.info("Step 23: Select Shipping method: " + shippingMethod_1);
		checkoutPage.clickOnRadioButtonByLabelName(driver, shippingMethod_1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 24: Click on Continus button");
		log.info("Step 24: Click on Continus button");
		checkoutPage.clickOnContinueButtonByStepTitle("Shipping method");

		ExtentTestManager.getTest().log(Status.INFO, "Step 25: Check to payment method: " + paymentMethod_1);
		log.info("Step 25: Check to payment method: " + paymentMethod_1);
		checkoutPage.clickOnRadioButtonByLabelName(driver, paymentMethod_1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 26: Click on Continue button");
		log.info("Step 26: Click on Continue button");
		checkoutPage.clickOnContinueButtonByStepTitle("Payment method");

		ExtentTestManager.getTest().log(Status.INFO, "Step 27: Select credit card: " + creditCard);
		log.info("Step 27: Select credit card: " + creditCard);
		checkoutPage.selectValueInDropDownByName(driver, "CreditCardType", creditCard);

		ExtentTestManager.getTest().log(Status.INFO, "Step 28: Input cartholder name: " + cardHolderName);
		log.info("Step 28: Input cartholder name: " + cardHolderName);
		checkoutPage.inputToTextboxByID(driver, "CardholderName", cardHolderName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 29: Input cart number:  " + cardNumber);
		log.info("Step 29: Input cart number:  " + cardNumber);
		checkoutPage.inputToTextboxByID(driver, "CardNumber", cardNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 30: Select Expiration date: " + expirationMonth);
		log.info("Step 30: Select Expiration date: " + expirationMonth);
		checkoutPage.selectValueInDropDownByName(driver, "ExpireMonth", expirationMonth);

		ExtentTestManager.getTest().log(Status.INFO, "Step 31: Select Expiration month: " + expirationYear);
		log.info("Step 31: Select Expiration month: " + expirationYear);
		checkoutPage.selectValueInDropDownByName(driver, "ExpireYear", expirationYear);

		ExtentTestManager.getTest().log(Status.INFO, "Step 32: Input to card code " + cardCode);
		log.info("Step 32: Input to card code " + cardCode);
		checkoutPage.inputToTextboxByID(driver, "CardCode", cardCode);

		ExtentTestManager.getTest().log(Status.INFO, "Step 33: Click to Continue button");
		log.info("Step 33: Click to Continue button");
		checkoutPage.clickOnContinueButtonByStepTitle("Payment information");

		ExtentTestManager.getTest().log(Status.INFO, "Step 34: Verify the previous information display correctly");
		log.info("Step 34: Verify the previous information display correctly");
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("name"), Register_Commons.firstName + " " + Register_Commons.lastName);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("email"), "Email: " + email);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("phone"), "Phone: " + phoneNumber);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("fax"), "Fax: " + faxNumber);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("company"), company);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("address1"), address1);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("address2"), address2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("city-state-zip"), city + "," + zipCode);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("country"), country);
		Assert.assertEquals(checkoutPage.getTextValueAtRowNumberByColumnName("1", "Product(s)"), productName3);
		Assert.assertEquals(checkoutPage.getPriceCheckoutByProductName(productName3), price);
		String subTotal = checkoutPage.getTextValueAtRowNumberByColumnName("1", "Total");
		Assert.assertEquals(checkoutPage.getQtyProductCheckoutByProductName(productName3), quantityProd);
		Assert.assertEquals(checkoutPage.getGiftWappingOption(), "Gift wrapping: " + giftWrappingOption);
		float actualTotal = checkoutPage.convertToNumberTotalPriceCheckoutByProductName(productName3);
		float expectdTotal = checkoutPage.caculateTotalPrice(price, quantityProd);
		String[] shippingInfor = shippingMethod_1.split("\\(");
		Assert.assertEquals(actualTotal, expectdTotal);
		Assert.assertEquals(checkoutPage.getSubTotalAtTotalInfo(), subTotal);
		Assert.assertEquals(checkoutPage.getShippingMethodAtTotalInfo(), "(" + shippingInfor[0].trim() + ")");
		Assert.assertEquals(checkoutPage.getShippingAtTotalInfo(), shippingInfor[1].substring(0, shippingInfor[1].length() - 1));
		Assert.assertEquals(checkoutPage.getTaxAtTotalInfo(), "$0.00");
		Assert.assertEquals(checkoutPage.getTotalAtTotalInfo(), subTotal);

		ExtentTestManager.getTest().log(Status.INFO, "Step 35: Click on Confirm button");
		log.info("Step 35: Click on Confirm button");
		homePage = checkoutPage.clickOnconfirmButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 36: Verify the oreder successfull message and the number order display");
		log.info("Step 36: Verify the oreder successfull message and the number order display");
		Assert.assertTrue(homePage.isOrderSuccessfullMessageDisplayed());
		Assert.assertTrue(homePage.isOrderNumberDisplayed());
		orderNumber = homePage.splitOrderNumber();
		System.out.println(orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 37: Click on My Account link");
		log.info("Step 37: Click on My Account link");
		customerPage = homePage.clickOnMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Step 38: Click on Order page");
		log.info("Step 38: Click on Order page");
		orderPage = customerPage.openOrderPage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 39: Verify the number order display");
		log.info("Step 39: Verify the number order display");
		Assert.assertTrue(orderPage.isOrderByNumberDisplayed(orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "Step 40: Click on Detail of oreder number");
		log.info("Step 40: Click on Detail of oreder number");
		orderPage.clickOnDetailButtonOfOrderNumber(orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 41: Verify the order ID display correctly");
		log.info("Step 41: Verify the order ID display correctly");
		Assert.assertTrue(orderPage.isOrderIDByOrderNumberDisplayed(orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "Step 42: Verify the date order display correctly");
		log.info("Step 42: Verify the date order display correctly");
		orderDate = orderPage.getFullLocationDate();
		Assert.assertTrue(orderPage.isOrderDateByDateDisplayed(orderDate));

		ExtentTestManager.getTest().log(Status.INFO, "Step 43: Verify the status order display correctly");
		log.info("Step 43: Verify the status order display correctly");
		Assert.assertTrue(orderPage.isOrderStatusByStatusDisplayed(orderStatus));

		ExtentTestManager.getTest().log(Status.INFO, "Step 44: Verify the order total display correctly");
		log.info("Step 44: Verify the order total display correctly");
		Assert.assertTrue(orderPage.isOrderTotalByTotalDislayed(subTotal));

		ExtentTestManager.getTest().log(Status.INFO, "Step 45: Verify the Billing Address display correctly");
		log.info("Step 45: Verify the Billing Address display correctly");
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("name"), Register_Commons.firstName + " " + Register_Commons.lastName);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("email"), "Email: " + email);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("phone"), "Phone: " + phoneNumber);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("fax"), "Fax: " + faxNumber);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("company"), company);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("address1"), address1);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("address2"), address2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("city-state-zip"), city + "," + zipCode);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("country"), country);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Name"), productName3);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Price"), price);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Quantity"), quantityProd);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Total"), subTotal);
		Assert.assertEquals(orderPage.getGiftWappingOption(), "Gift wrapping: " + giftWrappingOption);

		ExtentTestManager.getTest().log(Status.INFO, "Step 46: Verify the product order information display correctly");
		log.info("Step 46: Verify the product order information display correctly");
		Assert.assertEquals(orderPage.getSubTotalAtTotalInfo(), subTotal);
		Assert.assertEquals(orderPage.getShippingAtTotalInfo(), shippingInfor[1].substring(0, shippingInfor[1].length() - 1));
		Assert.assertEquals(orderPage.getTaxAtTotalInfo(), "$0.00");
		Assert.assertEquals(orderPage.getTotalAtTotalInfo(), subTotal);
	}

	@Test
	public void TC_06_TC_Checkout_Order_Payment_Methoḍ_By_Cheque(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 06: Checkout-Order by Cheque");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Notebooks page");
		log.info("Step 01: Open Notebooks page");
		notebooksPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Add to cart for product: " + productName3);
		log.info("Step 02: Click on Add to cart for product: " + productName3);
		productDetailPage = notebooksPage.clickOnProductByName(productName3);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Add to cart at product detail page");
		log.info("Step 03: Click on Add to cart at product detail page");
		productDetailPage.clickOnAddToCartButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the product has been add to shopping cart message display");
		log.info("Step 04: Verify the product has been add to shopping cart message display");
		Assert.assertEquals(productDetailPage.getProductAddToCartMessage(), "The product has been added to your shopping cart");
		productDetailPage.closeNoitificationMessage();
		String price = productDetailPage.getTotalPrice();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click on Shopping Cart link");
		log.info("Step 05: Click on Shopping Cart link");
		shoppingCartPage = productDetailPage.clickOnShoppingCartLink(driver);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Product(s)"), productName3);
		Assert.assertEquals(shoppingCartPage.getProductValueAtRowNumberByColumnName("1", "Price"), price);
		String quantityProd = shoppingCartPage.getAttributeValueAtRowNumberByColumnName("1", "Qty.", "value");
		Assert.assertEquals(shoppingCartPage.totalPriceOfProduct(price, quantityProd), shoppingCartPage.getTotalPriceAtShoppingCart("1", "Total"));

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select the No option on Gift wrapping");
		log.info("Step 06: Select the No option on Gift wrapping");
		shoppingCartPage.selectValueInGiftWrapping(giftWrappingOption);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on Estimate shipping button");
		log.info("Step 07: Click on Estimate shipping button");
		shoppingCartPage.clickOnEstimateShippingButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Select Country in Ship to popup: " + shiptoCountry);
		log.info("Step 08: Select Country in Ship to popup: " + shiptoCountry);
		shoppingCartPage.selectCountryInShipToPopup(shiptoCountry);

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Select Province in Ship to popup: " + shiptoProvince);
		log.info("Step 09: Select Province in Ship to popup: " + shiptoProvince);
		shoppingCartPage.selectProvinceInShipToPopup(shiptoProvince);

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input to Zip/Postal Code textbox: " + shiptoZipcode);
		log.info("Step 10: Input to Zip/Postal Code textbox: " + shiptoZipcode);
		shoppingCartPage.inputToZipCodeInShipToPopup(shiptoZipcode);

		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Click on Apply button");
		log.info("Step 11: Click on Apply button");
		shoppingCartPage.clickOnApplyButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Check to I agree with condition checkbox");
		log.info("Step 12: Check to I agree with condition checkbox");
		shoppingCartPage.checkToAgreeConditionCheckbox();

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Click on Checkout button");
		log.info("Step 13: Click on Checkout button");
		checkoutPage = shoppingCartPage.clickOnCheckoutButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Click on Edit button to modify Billing Adress");
		log.info("Step 14: Click on Edit button to modify Billing Adress");
		checkoutPage.clickOnEditButtonOfBillingAdress();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Input to First Name textbox: " + firstname_2);
		log.info("Step 15: Input to First Name textbox: " + firstname_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_FirstName", firstname_2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Input to Last Name textbox: " + lastname_2);
		log.info("Step 16: Input to Last Name textbox: " + lastname_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_LastName", lastname_2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 17: Input to Email textbox: " + email_2);
		log.info("Step 17: Input to Email textbox: " + email_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Email", email_2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 18: Input to Company textbox: " + company_2);
		log.info("Step 18: Input to Company textbox: " + company_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Company", company_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 19: Select value in Country dropdown: " + country_2);
		log.info("Step 19: Select value in Country dropdown: " + country_2);
		checkoutPage.selectValueInDropDownByName(driver, "BillingNewAddress.CountryId", country_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 20: Input to City textbox: " + city_2);
		log.info("Step 20: Input to City textbox: " + city_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_City", city_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 21: Input to Address 1 textbox: " + address1_2);
		log.info("Step 21: Input to Address 1 textbox: " + address1_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address1", address1_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 22: Input to Address 2 textbox: " + address2_2);
		log.info("Step 22: Input to Address 2 textbox: " + address2_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_Address2", address2_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 23: Input to ZipCode textbox: " + zipCode_2);
		log.info("Step 23: Input to ZipCode textbox: " + zipCode_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zipCode_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 24: Input to Phone number textbox: " + phoneNumber_2);
		log.info("Step 24: Input to Phone number textbox: " + phoneNumber_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_PhoneNumber", phoneNumber_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 25: Input to Fax number textbox: " + faxNumber_2);
		log.info("Step 25: Input to Fax number textbox: " + faxNumber_2);
		checkoutPage.inputToTextboxByID(driver, "BillingNewAddress_FaxNumber", String.valueOf(faxNumber_2));

		ExtentTestManager.getTest().log(Status.INFO, "Step 26: Click on Save button");
		log.info("Step 26: Click on Save button");
		checkoutPage.clickOnSaveButtonOfBillingAdress();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 27: Click on Continue button");
		log.info("Step 27: Click on Continue button");
		checkoutPage.clickOnContinueButtonByStepTitle("Billing address");

		ExtentTestManager.getTest().log(Status.INFO, "Step 28: Select Shipping method: " + shippingMethod_2);
		log.info("Step 28: Select Shipping method: " + shippingMethod_2);
		checkoutPage.clickOnRadioButtonByLabelName(driver, shippingMethod_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 29: Click on Continus button");
		log.info("Step 29: Click on Continus button");
		checkoutPage.clickOnContinueButtonByStepTitle("Shipping method");

		ExtentTestManager.getTest().log(Status.INFO, "Step 30: Check to payment method: " + paymentMethod_2);
		log.info("Step 30: Check to payment method: " + paymentMethod_2);
		checkoutPage.clickOnRadioButtonByLabelName(driver, paymentMethod_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 31: Click on Continue button");
		log.info("Step 31: Click on Continue button");
		checkoutPage.clickOnContinueButtonByStepTitle("Payment method");

		ExtentTestManager.getTest().log(Status.INFO, "Step 32: Click to Continue button");
		log.info("Step 32: Click to Continue button");
		checkoutPage.clickOnContinueButtonByStepTitle("Payment information");

		ExtentTestManager.getTest().log(Status.INFO, "Step 33: Verify the previous information display correctly");
		log.info("Step 33: Verify the previous information display correctly");
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("name"), firstname_2 + " " + lastname_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("email"), "Email: " + email_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("phone"), "Phone: " + phoneNumber_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("fax"), "Fax: " + faxNumber_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("company"), company_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("address1"), address1_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("address2"), address2_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("city-state-zip"), city_2 + "," + zipCode_2);
		Assert.assertEquals(checkoutPage.getBillingAddressAtCheckoutPageByClassName("country"), country_2);
		Assert.assertEquals(checkoutPage.getTextValueAtRowNumberByColumnName("1", "Product(s)"), productName3);
		Assert.assertEquals(checkoutPage.getPriceCheckoutByProductName(productName3), price);
		String subTotal = checkoutPage.getTextValueAtRowNumberByColumnName("1", "Total");
		Assert.assertEquals(checkoutPage.getQtyProductCheckoutByProductName(productName3), quantityProd);
		Assert.assertEquals(checkoutPage.getGiftWappingOption(), "Gift wrapping: " + giftWrappingOption);
		float actualTotal = checkoutPage.convertToNumberTotalPriceCheckoutByProductName(productName3);
		float expectdTotal = checkoutPage.caculateTotalPrice(price, quantityProd);
		String[] shippingInfor = shippingMethod_2.split("\\(");
		Assert.assertEquals(actualTotal, expectdTotal);
		Assert.assertEquals(checkoutPage.getSubTotalAtTotalInfo(), subTotal);
		Assert.assertEquals(checkoutPage.getShippingMethodAtTotalInfo(), "(" + shippingInfor[0].trim() + ")");
		Assert.assertEquals(checkoutPage.getShippingAtTotalInfo(), shippingInfor[1].substring(0, shippingInfor[1].length() - 1));
		Assert.assertEquals(checkoutPage.getTaxAtTotalInfo(), "$0.00");
		Assert.assertEquals(checkoutPage.getTotalAtTotalInfo(), subTotal);
		delay(5);

		ExtentTestManager.getTest().log(Status.INFO, "Step 34: Click on Confirm button");
		log.info("Step 34: Click on Confirm button");
		homePage = checkoutPage.clickOnconfirmButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 35: Verify the oreder successfull message and the number order display");
		log.info("Step 35: Verify the oreder successfull message and the number order display");
		Assert.assertTrue(homePage.isOrderSuccessfullMessageDisplayed());
		Assert.assertTrue(homePage.isOrderNumberDisplayed());
		orderNumber = homePage.splitOrderNumber();

		ExtentTestManager.getTest().log(Status.INFO, "Step 36: Click on My Account link");
		log.info("Step 36: Click on My Account link");
		customerPage = homePage.clickOnMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Step 37: Click on Order page");
		log.info("Step 37: Click on Order page");
		orderPage = customerPage.openOrderPage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 38: Verify the number order display");
		log.info("Step 38: Verify the number order display");
		Assert.assertTrue(orderPage.isOrderByNumberDisplayed(orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "Step 39: Click on Detail of oreder number");
		log.info("Step 39: Click on Detail of oreder number");
		orderPage.clickOnDetailButtonOfOrderNumber(orderNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 40: Verify the order ID display correctly");
		log.info("Step 40: Verify the order ID display correctly");
		Assert.assertTrue(orderPage.isOrderIDByOrderNumberDisplayed(orderNumber));

		ExtentTestManager.getTest().log(Status.INFO, "Step 41: Verify the date order display correctly");
		log.info("Step 41: Verify the date order display correctly");
		orderDate = orderPage.getFullLocationDate();
		Assert.assertTrue(orderPage.isOrderDateByDateDisplayed(orderDate));

		ExtentTestManager.getTest().log(Status.INFO, "Step 42: Verify the status order display correctly");
		log.info("Step 42: Verify the status order display correctly");
		Assert.assertTrue(orderPage.isOrderStatusByStatusDisplayed(orderStatus));

		ExtentTestManager.getTest().log(Status.INFO, "Step 43: Verify the order total display correctly");
		log.info("Step 43: Verify the order total display correctly");
		Assert.assertTrue(orderPage.isOrderTotalByTotalDislayed(subTotal));

		ExtentTestManager.getTest().log(Status.INFO, "Step 44: Verify the Billing Address display correctly");
		log.info("Step 44: Verify the Billing Address display correctly");
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("name"), firstname_2 + " " + lastname_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("email"), "Email: " + email_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("phone"), "Phone: " + phoneNumber_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("fax"), "Fax: " + faxNumber_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("company"), company_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("address1"), address1_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("address2"), address2_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("city-state-zip"), city_2 + "," + zipCode_2);
		Assert.assertEquals(orderPage.getBillingAddressAtOrderPageByClassName("country"), country_2);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Name"), productName3);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Price"), price);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Quantity"), quantityProd);
		Assert.assertEquals(orderPage.getTextValueAtRowNumberByColumnName("1", "Total"), subTotal);
		Assert.assertEquals(orderPage.getGiftWappingOption(), "Gift wrapping: " + giftWrappingOption);

		ExtentTestManager.getTest().log(Status.INFO, "Step 45: Verify the product order information display correctly");
		log.info("Step 45: Verify the product order information display correctly");
		Assert.assertEquals(orderPage.getSubTotalAtTotalInfo(), subTotal);
		Assert.assertEquals(orderPage.getShippingAtTotalInfo(), shippingInfor[1].substring(0, shippingInfor[1].length() - 1));
		Assert.assertEquals(orderPage.getTaxAtTotalInfo(), "$0.00");
		Assert.assertEquals(orderPage.getTotalAtTotalInfo(), subTotal);
	}

//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//		closeBrowserAndDriver();
//	}
}
