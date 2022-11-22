package hybrid.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import exception.BrowserNotSupport;
import hybrid.nopcommerce.commons.Register_Commons;
import pageObjects.nopCommerce.portal.DesktopsPageObject;
import pageObjects.nopCommerce.portal.ProductDetailPageObject;
import pageObjects.nopCommerce.portal.ProductPreviewPageObject;
import pageObjects.nopCommerce.portal.UserAddressPageObject;
import pageObjects.nopCommerce.portal.UserChangePasswordPageObject;
import pageObjects.nopCommerce.portal.UserCustomerInforPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import pageObjects.nopCommerce.portal.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;
import utilities.FakeDataHelper;

public class NopCommerce_MyAccount extends BaseTest {
	private WebDriver driver;
	private String male, female;
	private String newFullName, newFirstName, newLastName, newEmail, newPassword, newDayOfBirth, newMonthOfBirth, newYearOfBirth, newCompany;
	private String country, city, address_1, address_2, zip, phoneNumber, faxNumber;
	private String productName, reviewTitle, reviewBody;
	private int randomNumber;

	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserRegisterPageObject registerPage;
	UserCustomerInforPageObject customerInfoPage;
	UserAddressPageObject addressPage;
	UserChangePasswordPageObject changePasswordPage;
	DesktopsPageObject desktopPage;
	ProductDetailPageObject productPage;
	ProductPreviewPageObject productReviewPage;
	UserMyProductReviewPageObject myProductReViewPage;
	FakeDataHelper dataHelper;
	private EnvironmentConfig environmentConfig;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String environmentName) throws BrowserNotSupport {
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		driver = getBrowserDriverMananment(browserName, environmentConfig.getWebURL());
		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataHelper = FakeDataHelper.getFakeDataHelper();

		randomNumber = generateRandomNumber();
		male = "Male";
		female = "Female";

		newEmail = dataHelper.getEmailAddress();
		newFirstName = dataHelper.getFirstName();
		newLastName = dataHelper.getLastName();
		newFullName = newFirstName + " " + newLastName;
		newPassword = dataHelper.getPassword();
		newDayOfBirth = "24";
		newMonthOfBirth = "May";
		newYearOfBirth = "1996";
		newCompany = dataHelper.getCompany();

		//country = dataHelper.getCountry();
		country = "Viet Nam";
		city = dataHelper.getCity();
		address_1 = dataHelper.getAddress();
		address_2 = dataHelper.getAddress();
		zip = dataHelper.getZipCode();
		phoneNumber = dataHelper.getPhoneNumber();
		faxNumber = "9876543210";

		productName = "Digital Storm VANQUISH 3 Custom Performance PC";
		reviewTitle = "Title of review " + randomNumber;
		reviewBody = "Body of review " + randomNumber;

		log.info("Pre-Conditon: Step 1 - Click on Login link");
		loginPage = homePage.clickOnLoginLink();

		log.info("Pre-Conditon: Step 2 - Input to Email with data: " + Register_Commons.emailAddress);
		loginPage.inputToEmailTextBox(Register_Commons.emailAddress);

		log.info("Pre-Conditon: Step 3 - Input to Confirm Password with data: " + Register_Commons.password);
		loginPage.inputToPasswordTextBox(Register_Commons.password);

		log.info("Pre-Conditon: Step 4 - Click on Login button");
		homePage = loginPage.clickOnLoginButton();

		log.info("Pre-Conditon: Step 5 - Verify My Account link displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void MyAccount_TC_01_Information(Method method) {
		ExtentTestManager.startTest(method.getName(), "My Account - TC 01: Information");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on My Account link");
		log.info("Step 1: Click on My Account link");
		customerInfoPage = homePage.clickOnMyAccountLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Verify Customer Info title display");
		log.info("Step 2: Verify Customer Info title display");
		Assert.assertEquals(customerInfoPage.getMyAccountTitle(), "My account - Customer info");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on Gender radio button by name: " + female);
		log.info("Step 3: Click on Gender radio button by name: " + female);
		customerInfoPage.clickOnRadioButtonByLabelName(driver, female);

		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Input to Fist Name with value: " + newFirstName);
		log.info("Step 4: Input to Fist Name with value: " + newFirstName);
		customerInfoPage.inputToTextboxByID(driver, "FirstName", newFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Input to Last Name with value: " + newLastName);
		log.info("Step 5: Input to Last Name with value: " + newLastName);
		customerInfoPage.inputToTextboxByID(driver, "LastName", newLastName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Select the day with value: " + newDayOfBirth);
		log.info("Step 6: Select the day with value: " + newDayOfBirth);
		customerInfoPage.selectValueInDropDownByName(driver, "DateOfBirthDay", newDayOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Select the month with value: " + newMonthOfBirth);
		log.info("Step 7: Select the month with value: " + newMonthOfBirth);
		customerInfoPage.selectValueInDropDownByName(driver, "DateOfBirthMonth", newMonthOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Select the year with value: " + newYearOfBirth);
		log.info("Step 8: Select the year with value: " + newYearOfBirth);
		customerInfoPage.selectValueInDropDownByName(driver, "DateOfBirthYear", newYearOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Step 9: Input to Email with value: " + newEmail);
		log.info("Step 9: Input to Email with value: " + newEmail);
		customerInfoPage.inputToTextboxByID(driver, "Email", newEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input to Company name with value: " + newCompany);
		log.info("Step 10: Input to Company name with value: " + newCompany);
		customerInfoPage.inputToTextboxByID(driver, "Company", newCompany);

		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Click on Save button");
		log.info("Step 11: Click on Save button");
		customerInfoPage.clickOnButtonByName(driver, "Save");

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify Gender updated by value: " + female);
		log.info("Step 12: Verify Gender updated by value: " + female);
		Assert.assertTrue(customerInfoPage.isRadioButtonByLabelNameSelected(driver, female));

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Verify First Name updated by value: " + newFirstName);
		log.info("Step 13: Verify First Name updated by value: " + newFirstName);
		Assert.assertEquals(customerInfoPage.getTextInTextboxByID(driver, "FirstName", "value"), newFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Verify Last Name updated by value: " + newLastName);
		log.info("Step 14: Verify Last Name updated by value: " + newLastName);
		Assert.assertEquals(customerInfoPage.getTextInTextboxByID(driver, "LastName", "value"), newLastName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Verify day updated by value: " + newDayOfBirth);
		log.info("Step 15: Verify day updated by value: " + newDayOfBirth);
		Assert.assertEquals(customerInfoPage.getSelectedValueInDefaultDropdownListByName(driver, "DateOfBirthDay"), newDayOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Verify month updated by value: " + newMonthOfBirth);
		log.info("Step 16: Verify month updated by value: " + newMonthOfBirth);
		Assert.assertEquals(customerInfoPage.getSelectedValueInDefaultDropdownListByName(driver, "DateOfBirthMonth"), newMonthOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Step 17: Verify year updated by value: " + newYearOfBirth);
		log.info("Step 17: Verify year updated by value: " + newYearOfBirth);
		Assert.assertEquals(customerInfoPage.getSelectedValueInDefaultDropdownListByName(driver, "DateOfBirthYear"), newYearOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Step 18: Verify Email updated by value: " + newEmail);
		log.info("Step 18: Verify Email updated by value: " + newEmail);
		Assert.assertEquals(customerInfoPage.getTextInTextboxByID(driver, "Email", "value"), newEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Step 19: Verify Company Name updated by value: " + newCompany);
		log.info("Step 19: Verify Company Name updated by value: " + newCompany);
		Assert.assertEquals(customerInfoPage.getTextInTextboxByID(driver, "Company", "value"), newCompany);

	}

	@Test
	public void MyAccount_TC_02_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), "My Account - TC 02: Address");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click on Address link");
		log.info("Step 01: Click on Address link");
		addressPage = customerInfoPage.openAddressPage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Verify No Addresses title display");
		log.info("Step 02: Verify No Addresses title display");
		Assert.assertTrue(addressPage.isNoDataTitleDisplay());

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Address button");
		log.info("Step 03: Click on Address button");
		addressPage.clickOnButtonByName(driver, "Add new");

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input to First Name with value: " + newFirstName);
		log.info("Step 04: Input to First Name with value: " + newFirstName);
		addressPage.inputToTextboxByID(driver, "Address_FirstName", newFirstName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input to Last Name with value: " + newLastName);
		log.info("Step 05: Input to Last Name with value: " + newLastName);
		addressPage.inputToTextboxByID(driver, "Address_LastName", newLastName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input to Email with value: " + newEmail);
		log.info("Step 06: Input to Email with value: " + newEmail);
		addressPage.inputToTextboxByID(driver, "Address_Email", newEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Input to Company with value: " + newCompany);
		log.info("Step 07: Input to Company with value: " + newCompany);
		addressPage.inputToTextboxByID(driver, "Address_Company", newCompany);

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Select value in Country with: " + country);
		log.info("Step 08: Select value in Country with: " + country);
		addressPage.selectValueInDropDownByName(driver, "Address.CountryId", country);

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify value in State dropdown by Other");
		log.info("Step 09: Verify value in State dropdown by Other");
		Assert.assertEquals(addressPage.selectValueInStateDropdownList("Address.StateProvinceId"), "Other");

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input to City with value: " + city);
		log.info("Step 10: Input to City with value: " + city);
		addressPage.inputToTextboxByID(driver, "Address_City", city);

		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Input to Address 1 with value: " + address_1);
		log.info("Step 11: Input to Address 1 with value: " + address_1);
		addressPage.inputToTextboxByID(driver, "Address_Address1", address_1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Input to Address 2 with value: " + address_2);
		log.info("Step 12: Input to Address 2 with value: " + address_2);
		addressPage.inputToTextboxByID(driver, "Address_Address2", address_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Input to Zip/Postal Code with value: " + zip);
		log.info("Step 13: Input to Zip/Postal Code with value: " + zip);
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", zip);

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Input to Phone Number with value: " + phoneNumber);
		log.info("Step 14: Input to Phone Number with value: " + phoneNumber);
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Input to Fax Number with value: " + faxNumber);
		log.info("Step 15: Input to Fax Number with value: " + faxNumber);
		addressPage.inputToTextboxByID(driver, "Address_FaxNumber", faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Click on Save button");
		log.info("Step 16: Click on Save button");
		addressPage.clickOnButtonByName(driver, "Save");

		ExtentTestManager.getTest().log(Status.INFO, "Step 17: Verify Title Name with value: " + newFullName);
		log.info("Step 17: Verify Title Name with value: " + newFullName);
		Assert.assertTrue(addressPage.isTitleByFullNameDisplay(newFullName));

		ExtentTestManager.getTest().log(Status.INFO, "Step 18: Verify User Name with value: " + newFullName);
		log.info("Step 18: Verify User Name with value: " + newFullName);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("name"), newFullName);
		System.out.println(addressPage.getTextAtTextFieldByClassName("email"));

		ExtentTestManager.getTest().log(Status.INFO, "Step 19: Verify Email with value: " + newEmail);
		log.info("Step 19: Verify Email with value: " + newEmail);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("email"), "Email: " + newEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Step 20: Verify Phone Number with value: " + phoneNumber);
		log.info("Step 20: Verify Phone Number with value: " + phoneNumber);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("phone"), "Phone number: " + phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 21: Verify Fax Number with value: " + faxNumber);
		log.info("Step 21: Verify Fax Number with value: " + faxNumber);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("fax"), "Fax number: " + faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Step 22: Verify Company with value: " + newCompany);
		log.info("Step 22: Verify Company with value: " + newCompany);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("company"), newCompany);

		ExtentTestManager.getTest().log(Status.INFO, "Step 23: Verify Address 1 with value: " + address_1);
		log.info("Step 23: Verify Address 1 with value: " + address_1);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("address1"), address_1);

		ExtentTestManager.getTest().log(Status.INFO, "Step 24: Verify Address 2 with value: " + address_2);
		log.info("Step 24: Verify Address 2 with value: " + address_2);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("address2"), address_2);

		ExtentTestManager.getTest().log(Status.INFO, "Step 25: Verify City and Zip Code with value: " + city + " and " + zip);
		log.info("Step 25: Verify City and Zip Code with value: " + city + " and " + zip);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("city-state-zip"), city + ", " + zip);

		ExtentTestManager.getTest().log(Status.INFO, "Step 26: Verify Country with value: " + country);
		log.info("Step 26: Verify Country with value: " + country);
		Assert.assertEquals(addressPage.getTextAtTextFieldByClassName("country"), country);
	}

	@Test
	public void MyAccount_TC_03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "My Account - TC 03: Change Password");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Click on Change Password link");
		log.info("Step 01: Click on Change Password link");
		changePasswordPage = addressPage.openChangePasswordPage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Input to Old Password with value: " + Register_Commons.password);
		log.info("Step 02: Input to Old Password with value: " + Register_Commons.password);
		changePasswordPage.inputToTextboxByID(driver, "OldPassword", Register_Commons.password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Input to New Password with value: " + newPassword);
		log.info("Step 03: Input to New Password with value: " + newPassword);
		changePasswordPage.inputToTextboxByID(driver, "NewPassword", newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Input to Confirm Password with value: " + newPassword);
		log.info("Step 04: Input to Confirm Password with value: " + newPassword);
		changePasswordPage.inputToTextboxByID(driver, "ConfirmNewPassword", newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Click on Change Password button");
		log.info("Step 05: Click on Change Password button");
		changePasswordPage.clickOnButtonByName(driver, "Change password");

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Verify the Change Password successfull mesage display");
		log.info("Step 06: Verify the Change Password successfull mesage display");
		Assert.assertTrue(changePasswordPage.isPasswordChangedMessageDisplay());

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on Close icon");
		log.info("Step 07: Click on Close icon");
		changePasswordPage.closeBarNotification();

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Click on Logout link");
		log.info("Step 08: Click on Logout link");
		homePage = changePasswordPage.clickOnLougoutLinkUserPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Click on Login link");
		log.info("Step 09: Click on Login link");
		loginPage = homePage.clickOnLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Input to Email with updated Email: " + newEmail);
		log.info("Step 10: Input to Email with updated Email: " + newEmail);
		loginPage.inputToTextboxByID(driver, "Email", newEmail);

		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Input old password: " + Register_Commons.password);
		log.info("Step 11: Input old password: " + Register_Commons.password);
		loginPage.inputToTextboxByID(driver, "Password", Register_Commons.password);

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Click on Login button");
		log.info("Step 12: Click on Login button");
		loginPage.clickOnButtonByName(driver, "Log in");

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Verify the error message display");
		log.info("Step 13: Verify the error message display");
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Input new password: " + newPassword);
		log.info("Step 14: Input new password: " + newPassword);
		loginPage.inputToTextboxByID(driver, "Password", newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Click on Login button");
		log.info("Step 15: Click on Login button");
		loginPage.clickOnButtonByName(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Verify My Account link page display");
		log.info("Step 16: Verify My Account link page display");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void MyAccount_TC_04_My_Product_Review(Method method) {
		ExtentTestManager.startTest(method.getName(), "My Account - TC 04: Product Review");
		ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Desktop page");
		log.info("Step 01: Navigate to Desktop page");
		desktopPage = (DesktopsPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Desktops");

		ExtentTestManager.getTest().log(Status.INFO, "Step 02: Click on Product name by: " + productName);
		log.info("Step 02: Click on Product name by: " + productName);
		productPage = desktopPage.clickOnProductByName(productName);

		ExtentTestManager.getTest().log(Status.INFO, "Step 03: Click on Add your reiew link");
		log.info("Step 03: Click on Add your reiew link");
		productReviewPage = productPage.clickOnAddYourReviewLink();

		ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the page title contain value: " + productName);
		log.info("Step 04: Verify the page title contain value: " + productName);
		Assert.assertTrue(productReviewPage.isTitlePageReviewByProductNameDisplay(productName));

		ExtentTestManager.getTest().log(Status.INFO, "Step 05: Input to Review title by value: " + reviewTitle);
		log.info("Step 05: Input to Review title by value: " + reviewTitle);
		productReviewPage.inputToTextboxByID(driver, "AddProductReview_Title", reviewTitle);

		ExtentTestManager.getTest().log(Status.INFO, "Step 06: Input to Review title by value: " + reviewBody);
		log.info("Step 06: Input to Review title by value: " + reviewBody);
		productReviewPage.inputToReviewTextArea(reviewBody);

		ExtentTestManager.getTest().log(Status.INFO, "Step 07: Click on Submit review button");
		log.info("Step 07: Click on Submit review button");
		productReviewPage.clickOnButtonByName(driver, "Submit review");

		ExtentTestManager.getTest().log(Status.INFO, "Step 08: Verify the page title contain value: " + productName);
		log.info("Step 08: Verify the page title contain value: " + productName);
		Assert.assertTrue(productReviewPage.isTitlePageReviewByProductNameDisplay(productName));

		ExtentTestManager.getTest().log(Status.INFO, "Step 09: Verify Review is added message display");
		log.info("Step 09: Verify Review is added message display");
		Assert.assertTrue(productReviewPage.isReviewAddedMessageDisplay());

		ExtentTestManager.getTest().log(Status.INFO, "Step 10: Verify review title display by value: " + reviewTitle);
		log.info("Step 10: Verify review title display by value: " + reviewTitle);
		Assert.assertTrue(productReviewPage.isReviewTitleByValueDisplay(reviewTitle));

		ExtentTestManager.getTest().log(Status.INFO, "Step 11: Verify review body display by value: " + reviewBody);
		log.info("Step 11: Verify review body display by value: " + reviewBody);
		Assert.assertTrue(productReviewPage.isReviewBodyByValueDisplay(reviewBody));

		ExtentTestManager.getTest().log(Status.INFO, "Step 12: Verify review upload by value: " + newFirstName);
		log.info("Step 12: Verify review upload by value: " + newFirstName);
		Assert.assertTrue(productReviewPage.isReviewUploadByAuthor(newFirstName));

		// log.info("Step 01: Verify the date upload review: " + getCurrentDate);
		// Assert.assertTrue(productReviewPage.isDateUploadReviewDisplay().contains(getCurrentDate));

		ExtentTestManager.getTest().log(Status.INFO, "Step 13: Click on My Account link");
		log.info("Step 13: Click on My Account link");
		customerInfoPage = homePage.clickOnMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Step 14: Verify Customer info title display");
		log.info("Step 14: Verify Customer info title display");
		Assert.assertEquals(customerInfoPage.getMyAccountTitle(), "My account - Customer info");

		ExtentTestManager.getTest().log(Status.INFO, "Step 15: Click on My Product reviews links");
		log.info("Step 15: Click on My Product reviews links");
		myProductReViewPage = customerInfoPage.openMyProductPage();

		ExtentTestManager.getTest().log(Status.INFO, "Step 16: Verify My product reviews title display");
		log.info("Step 16: Verify My product reviews title display");
		Assert.assertTrue(myProductReViewPage.isMyProductReviewTitleDisplay("My account - My product reviews"));

		ExtentTestManager.getTest().log(Status.INFO, "Step 17: Verify Review title display with value: " + reviewTitle);
		log.info("Step 17: Verify Review title display with value: " + reviewTitle);
		Assert.assertTrue(myProductReViewPage.isReviewTitleByValueDisplay(reviewTitle));

		ExtentTestManager.getTest().log(Status.INFO, "Step 18: Verify Review body display with value: " + reviewBody);
		log.info("Step 18: Verify Review body display with value: " + reviewBody);
		Assert.assertTrue(myProductReViewPage.isRevieBodyByValueDisplay(reviewBody));

		ExtentTestManager.getTest().log(Status.INFO, "Step 19: Verify review for product name display with value: " + productName);
		log.info("Step 19: Verify review for product name display with value: " + productName);
		Assert.assertTrue(myProductReViewPage.isProductByNameDisplay(productName));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	private int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
