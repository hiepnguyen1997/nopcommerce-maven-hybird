package hybrid.nopcommerce.admin;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminAddNewAddressPageObject;
import pageObjects.nopCommerce.admin.AdminCustomerPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminEditCustomerPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductDetailPageObject;
import pageObjects.nopCommerce.admin.AdminProductPageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;
import utilities.FakeDataHelper;

public class NopCommerce_Admin extends BaseTest {
	private WebDriver driver;
	AdminLoginPageObject loginPageAdmin;
	AdminDashboardPageObject dashboardPageAdmin;
	AdminProductPageObject productPageAdmin;
	AdminProductDetailPageObject productDetailPageAdmin;
	AdminCustomerPageObject customerPageAdmin;
	AdminEditCustomerPageObject editCustomerPageAdmin;
	AdminAddNewAddressPageObject addNewAddressPageAdmin;
	FakeDataHelper fakeData;
	EnvironmentConfig environment;
	private String email, firstName, lastName, password, dateOfBirth, companyName, adminComment, customerRole;
	private String emailEdit, firstNameEdit, lastNameEdit, dateOfBirthEdit, companyNameEdit, adminCommentEdit;
	private String emailNewAddress, firstNameNewAddress, lastNameNewAddress, companyNameNewAddress, countryNewAddress, cityNewAddress, address1NewAddress, zipCodeNewAddress, phoneNumberNewAddress;

	private String emailLoginAdmin, passwordLoginAdmin;
	private String searchData = "Lenovo IdeaCentre 600 All-in-One PC";

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		fakeData = FakeDataHelper.getFakeDataHelper();
		ConfigFactory.setProperty("evn", environmentName);
		environment = ConfigFactory.create(EnvironmentConfig.class);
		email = fakeData.getEmailAddress();
		password = fakeData.getPassword();
		firstName = fakeData.getFirstName();
		lastName = fakeData.getLastName();
		companyName = fakeData.getCompany();
		dateOfBirth = fakeData.getBrithday();
		adminComment = "The String to test";
		customerRole = "Guests";

		emailEdit = fakeData.getEmailAddress();
		firstNameEdit = fakeData.getFirstName();
		lastNameEdit = fakeData.getLastName();
		companyNameEdit = fakeData.getCompany();
		dateOfBirthEdit = fakeData.getBrithday();
		adminCommentEdit = "Edit Customer (Guest)";

		emailNewAddress = fakeData.getEmailAddress();
		firstNameNewAddress = fakeData.getFirstName();
		lastNameNewAddress = fakeData.getLastName();
		companyNameNewAddress = fakeData.getCompany();
		countryNewAddress = fakeData.getCountry();
		cityNewAddress = fakeData.getCity();
		address1NewAddress = fakeData.getAddress();
		zipCodeNewAddress = fakeData.getZipCode();
		phoneNumberNewAddress = fakeData.getPhoneNumber();

		emailLoginAdmin = environment.getEmail();
		passwordLoginAdmin = environment.getPassword();

		driver = getBrowserDriverMananment(browserName, environment.getWebURL());
		System.out.println(email);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(companyName);
		System.out.println(dateOfBirth);

		loginPageAdmin = PageGeneratorManager.getAdminLoginPage(driver);
		log.info("Pre-Conditions: Login as Admin with email :" + emailLoginAdmin + " and password: " + passwordLoginAdmin);
		dashboardPageAdmin = loginPageAdmin.loginAsAdmin(emailLoginAdmin, passwordLoginAdmin);
		Assert.assertTrue(dashboardPageAdmin.isAdminLogoutButtonDisplay(driver));
	}

	@Test
	public void TC_01_Search_With_Prodcuts_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 01: Search with products name");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Product page");
		log.info("Step 01: Open Product page");
		productPageAdmin = (AdminProductPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Catalog", "Products");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Product name with value: " + searchData);
		log.info("Step 02: Input to Product name with value: " + searchData);
		productPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Product name", searchData);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on search button");
		log.info("Step 03: Click on search button");
		productPageAdmin.clickOnSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify result display");
		log.info("Step 04: Verify result display");
		Assert.assertEquals(productPageAdmin.getNumberResultAtTableInAdminPage(), 1);
		Assert.assertEquals(productPageAdmin.getTextValueByColumnNameAtAdmniPage("Product name"), searchData);

	}

	@Test
	public void TC_02_Search_With_Product_Name_Catefory_Uncheck(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02: Search with product name + catfory + uncheck");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Product page");
		log.info("");
		productPageAdmin = (AdminProductPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Catalog", "Products");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Product name with value: " + searchData);
		log.info("Step 02: Input to Product name with value: " + searchData);
		productPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Product name", searchData);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select value in Category dropdown with value: Computer");
		log.info("Step 03: Select value in Category dropdown with value: Computer");
		productPageAdmin.selectValueInDropdownListAtAdminPage(driver, "Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on search button");
		log.info("Step 04: Click on search button");
		productPageAdmin.clickOnSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify the message no data display");
		log.info("Step 05: Verify the message no data display");
		Assert.assertTrue(productPageAdmin.isNoDataAvailableInfoDisplay());

	}

	@Test
	public void TC_03_Search_With_Product_Name_Catefory_Check(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 03: Search with product name + catefory + check");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Product page");
		log.info("");
		productPageAdmin = (AdminProductPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Catalog", "Products");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Product name with value: " + searchData);
		log.info("Step 02: Input to Product name with value: " + searchData);
		productPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Product name", searchData);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select value in Category dropdown with value: Computer");
		log.info("Step 03: Select value in Category dropdown with value: Computer");
		productPageAdmin.selectValueInDropdownListAtAdminPage(driver, "Category", "Computers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on Search subcategories checkbox");
		log.info("Step 04: Click on Search subcategories checkbox");
		productPageAdmin.clickOnCheckboxByLabelAtAdminPage(driver, "Search subcategories");

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click on search button");
		log.info("Step 05: Click on search button");
		productPageAdmin.clickOnSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify the result display");
		log.info("Step 06: Verify the result display");
		Assert.assertEquals(productPageAdmin.getNumberResultAtTableInAdminPage(), 1);
		Assert.assertEquals(productPageAdmin.getTextValueByColumnNameAtAdmniPage("Product name"), searchData);
	}

	@Test
	public void TC_04_Search_With_Product_Name_Child_Catefory(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02: Search with product name + catfory +check");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Product page");
		log.info("Step 01: Open Product page");
		productPageAdmin = (AdminProductPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Catalog", "Products");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Product name with value: " + searchData);
		log.info("Step 02: Input to Product name with value: " + searchData);
		productPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Product name", searchData);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select value in Category dropdown with value: Computers >> Desktops");
		log.info("Step 03: Select value in Category dropdown with value: Computers >> Desktops");
		productPageAdmin.selectValueInDropdownListAtAdminPage(driver, "Category", "Computers >> Desktops");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on search button");
		log.info("Step 04: Click on search button");
		productPageAdmin.clickOnSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify the result display");
		log.info("Step 05: Verify the result display");
		Assert.assertEquals(productPageAdmin.getNumberResultAtTableInAdminPage(), 1);
		Assert.assertEquals(productPageAdmin.getTextValueByColumnNameAtAdmniPage("Product name"), searchData);
	}

	@Test
	public void TC_05_Search_With_Product_Name_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02: Search with product name + catfory + uncheck");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Product page");
		log.info("Step 01: Open Product page");
		productPageAdmin = (AdminProductPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Catalog", "Products");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Product name with value: " + searchData);
		log.info("Step 02: Input to Product name with value: " + searchData);
		productPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Product name", searchData);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select value in Manufacturer dropdown with value: Apple");
		log.info("Step 03: Select value in Manufacturer dropdown with value: Apple");
		productPageAdmin.selectValueInDropdownListAtAdminPage(driver, "Manufacturer", "Apple");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on search button");
		log.info("Step 04: Click on search button");
		productPageAdmin.clickOnSearchButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify the result display");
		log.info("Step 05: Verify the result display");
		Assert.assertTrue(productPageAdmin.isNoDataAvailableInfoDisplay());

	}

	@Test
	public void TC_06_Go_Directly_To_Product_SKU(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 06: Go directly to porduct SKU");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Product page");
		log.info("Step 01: Open Product page");
		productPageAdmin = (AdminProductPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Catalog", "Products");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Go directly to product SKU with value: LE_IC_600");
		log.info("Step 02: Input to Go directly to product SKU with value: LE_IC_600");
		productPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Go directly to product SKU", "LE_IC_600");

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Go button to go to product detail page");
		log.info("Step 03: Click on Go button to go to product detail page");
		productDetailPageAdmin = productPageAdmin.clickOnGoSKUButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the infomation of Lenovo IdeaCentre 600 All-in-One PC display");
		log.info("Step 04: Verify the infomation of Lenovo IdeaCentre 600 All-in-One PC display");
		String informationData = productDetailPageAdmin.getAttributeValueAtTextboxByNameAtAdminPage(driver, "Product name", "value");
		Assert.assertEquals(informationData, searchData);
	}

	@Test
	public void TC_07_Create_New_Customer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 07: Create new customer");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Customer page");
		log.info("Step 01: Open Customer page");
		customerPageAdmin = (AdminCustomerPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Customers", "Customers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Add New button");
		log.info("Step 02: Click on Add New button");
		customerPageAdmin.clickOAddNewCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to the all fields");
		log.info("Step 03: Input to the all fields");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", email);
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Password", password);
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstName);
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastName);
		customerPageAdmin.clickOnRadioButtonByLabelName(driver, "Male");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Date of birth", dateOfBirth);
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company name", companyName);
		customerPageAdmin.selectValueInCustomerRoleDropdownCreate(customerRole);
		customerPageAdmin.inputToAdminCommentTextArea(driver, adminComment);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on Save and Continue Edit");
		log.info("Step 04: Click on Save and Continue Edit");
		customerPageAdmin.clickOnSaveAndContinueButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify the message display");
		log.info("Step 05: Verify the message display");
		Assert.assertTrue(customerPageAdmin.getNoitificationMessageAtAdminPage(driver).contains("The new customer has been added successfully."));

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify all information display correctly");
		log.info("Step 06: Verify all information display correctly");
		Assert.assertEquals(customerPageAdmin.getAttributeValueAtTextboxByNameAtAdminPage(driver, "Email", "value"), email);
		Assert.assertEquals(customerPageAdmin.getAttributeValueAtTextboxByNameAtAdminPage(driver, "First name", "value"), firstName);
		Assert.assertEquals(customerPageAdmin.getAttributeValueAtTextboxByNameAtAdminPage(driver, "Last name", "value"), lastName);
		String date = customerPageAdmin.getAttributeValueAtTextboxByNameAtAdminPage(driver, "Date of birth", "value");
		String dateConvert = customerPageAdmin.getAndConvertFormatDateOfBirth(date);
		Assert.assertEquals(dateOfBirth, dateConvert);
		Assert.assertEquals(customerPageAdmin.getAttributeValueAtTextboxByNameAtAdminPage(driver, "Company name", "value"), companyName);
		Assert.assertTrue(customerPageAdmin.isCustomerRoleByNameDisplay(customerRole));
		Assert.assertEquals(customerPageAdmin.getTextValueInAdminCommentTextArea(driver), adminComment);
		Assert.assertTrue(customerPageAdmin.isRadioButtonByLabelNameSelected(driver, "Male"));
		;

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on back to customer list");
		log.info("Step 07: Click on back to customer list");
		customerPageAdmin.clickOnBackToCustomerList();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Select value in Customer role: " + customerRole);
		log.info("Step 08: Select value in Customer role: " + customerRole);
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click on Search button");
		log.info("Step 09: Click on Search button");
		customerPageAdmin.clickOnSearchCustomerButton();
		Assert.assertTrue(customerPageAdmin.isCustomerInformationDisplayAtTable("Guest " + firstName + " " + lastName + " Guests " + companyName + " Edit"));

	}

	@Test
	public void TC_08_Search_By_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 08: Search customer by ID");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Customer page");
		log.info("Step 01: Open Customer page");
		customerPageAdmin = (AdminCustomerPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Customers", "Customers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to email textbox");
		log.info("Step 02: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", email);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select value in Customer Role dropdown");
		log.info("Step 03: Select value in Customer Role dropdown");
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on Search");
		log.info("Step 04: Click on Search");
		customerPageAdmin.clickOnSearchCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify number result display");
		log.info("Step 05: Verify number result display");
		Assert.assertEquals(customerPageAdmin.getNumberOfLineResult(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify the information display");
		log.info("Step 06: Verify the information display");
		Assert.assertTrue(customerPageAdmin.isCustomerInformationDisplayAtTable("Guest " + firstName + " " + lastName + " Guests " + companyName + " Edit"));

	}

	@Test
	public void TC_09_Search_Customer_With_First_Name_Last_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 09: Search Customer with first name and last name");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Customer page");
		log.info("Step 01: Open Customer page");
		customerPageAdmin = (AdminCustomerPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Customers", "Customers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to First Name textbox");
		log.info("Step 02: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to Last Name textbox");
		log.info("Step 03: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Select value in Customer Role dropdown");
		log.info("Step 04: Select value in Customer Role dropdown");
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click on Search");
		log.info("Step 05: Click on Search");
		customerPageAdmin.clickOnSearchCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify number result display");
		log.info("Step 06: Verify number result display");
		Assert.assertEquals(customerPageAdmin.getNumberOfLineResult(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Verify the information display");
		log.info("Step 07: Verify the information display");
		Assert.assertTrue(customerPageAdmin.isCustomerInformationDisplayAtTable("Guest " + firstName + " " + lastName + " Guests " + companyName + " Edit"));

	}

	@Test
	public void TC_10_Search_By_Company(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 10: Search customer by company");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Customer page");
		log.info("Step 01: Open Customer page");
		customerPageAdmin = (AdminCustomerPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Customers", "Customers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to company textbox");
		log.info("Step 02: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company", companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Select value in Customer Role dropdown");
		log.info("Step 03: Select value in Customer Role dropdown");
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Click on Search");
		log.info("Step 04: Click on Search");
		customerPageAdmin.clickOnSearchCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify number result display");
		log.info("Step 05: Verify number result display");
		Assert.assertEquals(customerPageAdmin.getNumberOfLineResult(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify the information display");
		log.info("Step 06: Verify the information display");
		Assert.assertTrue(customerPageAdmin.isCustomerInformationDisplayAtTable("Guest " + firstName + " " + lastName + " Guests " + companyName + " Edit"));

	}

	@Test
	public void TC_11_Search_With_Full_data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 11: Search customer by full data");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Customer page");
		log.info("Step 01: Open Customer page");
		customerPageAdmin = (AdminCustomerPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Customers", "Customers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to email textbox");
		log.info("Step 02: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", email);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to First Name textbox");
		log.info("Step 03: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input to Last Name textbox");
		log.info("Step 04: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input to company textbox");
		log.info("Step 05: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company", companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select value in Customer Role dropdown");
		log.info("Step 06: Select value in Customer Role dropdown");
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on Search");
		log.info("Step 07: Click on Search");
		customerPageAdmin.clickOnSearchCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify number result display");
		log.info("Step 08: Verify number result display");
		Assert.assertEquals(customerPageAdmin.getNumberOfLineResult(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify the information display");
		log.info("Step 09: Verify the information display");
		Assert.assertTrue(customerPageAdmin.isCustomerInformationDisplayAtTable("Guest " + firstName + " " + lastName + " Guests " + companyName + " Edit"));
	}

	@Test
	public void TC_12_Edit_Customer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 12: Edit customer");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Customer page");
		log.info("Step 01: Open Customer page");
		customerPageAdmin = (AdminCustomerPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Customers", "Customers");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to email textbox");
		log.info("Step 02: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", email);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to First Name textbox");
		log.info("Step 03: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input to Last Name textbox");
		log.info("Step 04: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input to company textbox");
		log.info("Step 05: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company", companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select value in Customer Role dropdown");
		log.info("Step 06: Select value in Customer Role dropdown");
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on Search");
		log.info("Step 07: Click on Search");
		customerPageAdmin.clickOnSearchCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click on Edit button");
		log.info("Step 08: Click on Edit button");
		editCustomerPageAdmin = customerPageAdmin.clickOnEditCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Modify all fields");
		log.info("Step 09: Modify all fields");
		editCustomerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", emailEdit);
		editCustomerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstNameEdit);
		editCustomerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastNameEdit);
		editCustomerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Date of birth", dateOfBirthEdit);
		editCustomerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company name", companyNameEdit);
		editCustomerPageAdmin.inputToAdminCommentTextArea(driver, adminCommentEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Click on Save button");
		log.info(" ");
		customerPageAdmin = editCustomerPageAdmin.clickOnSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify the message: The customer has been updated successfully.");
		log.info("Step 11: Verify the message: The customer has been updated successfully.");
		Assert.assertTrue(customerPageAdmin.getNoitificationMessageAtAdminPage(driver).contains("The customer has been updated successfully"));

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Input to email textbox");
		log.info("Step 12: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", emailEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Input to First Name textbox");
		log.info("Step 13: Input to First Name textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstNameEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Input to Last Name textbox");
		log.info("Step 14: Input to Last Name textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastNameEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Input to company textbox");
		log.info("Step 15: Input to company textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company", companyNameEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Select value in Customer Role dropdown");
		log.info("Step 16: Select value in Customer Role dropdown");
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 17: Click on Search");
		log.info("Step 17: Click on Search");
		customerPageAdmin.clickOnSearchCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 18: Verify number result display");
		log.info("Step 18: Verify number result display");
		Assert.assertEquals(customerPageAdmin.getNumberOfLineResult(), 1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 19: Verify the information display");
		log.info("Step 19: Verify the information display");
		Assert.assertTrue(customerPageAdmin.isCustomerInformationDisplayAtTable("Guest " + firstNameEdit + " " + lastNameEdit + " Guests " + companyNameEdit + " Edit"));
	}

	@Test
	public void TC_13_Add_New_address_In_Customer_Detail(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 13: Add new address in customer detail");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Open Customer page");
		log.info("Step 01: Open Customer page");
		customerPageAdmin = (AdminCustomerPageObject) dashboardPageAdmin.getListAdminMenu(driver).openPageInMenuByPageName("Customers", "Customers");
		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to email textbox");
		log.info("Step 02: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", emailEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to First Name textbox");
		log.info("Step 03: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstNameEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input to Last Name textbox");
		log.info("Step 04: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastNameEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input to company textbox");
		log.info("Step 05: Input to email textbox");
		customerPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company", companyNameEdit);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Select value in Customer Role dropdown");
		log.info("Step 06: Select value in Customer Role dropdown");
		customerPageAdmin.selectValueInCustomerRoleDropdownSearch(customerRole);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on Search");
		log.info("Step 07: Click on Search");
		customerPageAdmin.clickOnSearchCustomerButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click on Edit button");
		log.info("Step 08: Click on Edit button");
		editCustomerPageAdmin = customerPageAdmin.clickOnEditCustomerButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click on Add new address");
		log.info("Step 09: Click on Add new address");
		addNewAddressPageAdmin = editCustomerPageAdmin.clickOnAddNewAddressButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input to all field");
		log.info("Step 10: Input to all field");
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "First name", firstNameNewAddress);
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Last name", lastNameNewAddress);
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Email", emailNewAddress);
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Company", companyNameNewAddress);
		addNewAddressPageAdmin.selectValueInDropdownListAtAdminPage(driver, "Country", countryNewAddress);
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "City", cityNewAddress);
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Address 1", address1NewAddress);
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Zip / postal code", zipCodeNewAddress);
		addNewAddressPageAdmin.inputToTextboxByNameAtAdminPage(driver, "Phone number", phoneNumberNewAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Click on Save button");
		log.info("Step 11: Click on Save button");
		addNewAddressPageAdmin.clickOnSaveNewAddressButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify the message 'The new address has been added successfully' display");
		log.info("Step 11: Click on Save button");
		Assert.assertTrue(addNewAddressPageAdmin.getNoitificationMessageAtAdminPage(driver).contains("The new address has been added successfully"));
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Click on Back to customer detail button");
		log.info("Step 13: Click on Back to customer detail button");
		editCustomerPageAdmin = addNewAddressPageAdmin.clickOnBackToCustomerDetail();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Verify the address display correctly at address section");
		log.info("Step 14: Verify the address display correctly at address section");
		Assert.assertEquals(editCustomerPageAdmin.getValueAtColumnByNameAtAddressSection("First name"), firstNameNewAddress);
		Assert.assertEquals(editCustomerPageAdmin.getValueAtColumnByNameAtAddressSection("Last name"), lastNameNewAddress);
		Assert.assertEquals(editCustomerPageAdmin.getValueAtColumnByNameAtAddressSection("Email"), emailNewAddress);
		Assert.assertEquals(editCustomerPageAdmin.getValueAtColumnByNameAtAddressSection("Phone number"), phoneNumberNewAddress);
		Assert.assertEquals(editCustomerPageAdmin.getValueAtColumnByNameAtAddressSection("Address"), companyNameNewAddress + "\n"  + address1NewAddress + "\n" + cityNewAddress + "," + zipCodeNewAddress + "\n" + countryNewAddress);
		
	}

//	@AfterClass(alwaysRun = true)
//		public void afterClass() {
//		closeBrowserAndDriver();
//	}

}
