package hybrid.nopcommerce.user;

import java.lang.reflect.Method;
import java.util.Random;

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
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class NopCommerce_Register extends BaseTest {
	WebDriver driver;
	String email, inValidMail, firstName, lastName, password, wrongPassword;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;

	@Parameters({"browser", "environment"})
	@BeforeClass
	public void beforeClass(@Optional ("chorme") String browserName, String environmentName) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		driver.get(getEnvironmentName(environmentName));
		homePage = PageGeneratorManager.getUserHomePage(driver);
		email = "testAuto" + generatorNumber() + "@gmail.com";
		inValidMail = "123@123";
		wrongPassword = "123";
		firstName = "Fake";
		lastName = "DAR";
	}

	@Test
	public void TC_01_Register_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 01 - Register with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Register link");
		log.info("Step 1: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Click on Register button");
		log.info("Step 2: Click on Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Verify the error message: 'First name is required.' displayed at Fisrt Name");
		log.info("Step 3: Verify the error message: 'First name is required.' displayed at Fisrt Name");
		Assert.assertEquals(registerPage.getErrorMessageFirstName(), "First name is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Verify the error message: 'Last name is required.' displayed at Last Name");
		log.info("Step 4: Verify the error message: 'Last name is required.' displayed at Last Name");
		Assert.assertEquals(registerPage.getErrorMessageLastName(), "Last name is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Verify the error message: 'Email is required.' displayed at Email");
		log.info("Step 5: Verify the error message: 'Email is required.' displayed at Email");
		Assert.assertEquals(registerPage.getErrorMessageEmail(), "Email is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Verify the error message: 'Password is required.' displayed at Password");
		log.info("Step 6: Verify the error message: 'Password is required.' displayed at Password");
		Assert.assertEquals(registerPage.getErrorMessagePassword(), "Password is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Verify the error message: 'Password is required.' displayed at Confirm Password");
		log.info("Step 7: Verify the error message: 'Password is required.' displayed at Confirm Password");
		Assert.assertEquals(registerPage.getErrorMessageConfirmPassword(), "Password is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02 - Register with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Register link");
		log.info("Step 1: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Fisrt Name with data: " + firstName);
		log.info("Step 2: Input to Fisrt Name with data: " + firstName);
		registerPage.inputToFistName(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input to Last Name with data: " + lastName);
		log.info("Step 3: Input to Last Name with data: " + lastName);
		registerPage.inputToLastName(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Input to Email with data: " + inValidMail);
		log.info("Step 4: Input to Email with data: " + inValidMail);
		registerPage.inputToEmail(inValidMail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Input to Password with data: " + Register_Commons.password);
		log.info("Step 5: Input to Password with data: " + Register_Commons.password);
		registerPage.inputToPassword(Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Input to Confirm Password with data: " + Register_Commons.password);
		log.info("Step 6: Input to Confirm Password with data: " + Register_Commons.password);
		registerPage.inputToConfirmPassword(Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Click on Register button");
		log.info("Step 7: Click on Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify the error 'Wrong email' displayed");
		log.info("Step 8: Verify the error 'Wrong email' displayed");
		Assert.assertEquals(registerPage.getErrorInvalidMail(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 03 - Register successfull");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Register link");
		log.info("Step 1: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Fisrt Name with data: " + firstName);
		log.info("Step 2: Input to Fisrt Name with data: " + firstName);
		registerPage.inputToFistName(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input to Last Name with data: " + lastName);
		log.info("Step 3: Input to Last Name with data: " + lastName);
		registerPage.inputToLastName(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Input to Email with data: " + email);
		log.info("Step 4: Input to Email with data: " + email);
		registerPage.inputToEmail(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Input to Password with data: " + Register_Commons.password);
		log.info("Step 5: Input to Password with data: " + Register_Commons.password);
		registerPage.inputToPassword(Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Input to Confirm Password with data: " + Register_Commons.password);
		log.info("Step 6: Input to Confirm Password with data: " + Register_Commons.password);
		registerPage.inputToConfirmPassword(Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Click on Register button");
		log.info("Step 7: Click on Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify the message 'Your registration completed' displayed");
		log.info("Step 8: Verify the message 'Your registration completed' displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 9: Click on Register link");
		log.info("Step 9: Click on Register link");
		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void TC_04_Register_Exsiting_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 04 - Register with existing email");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Register link");
		log.info("Step 1: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Fisrt Name with data: " + firstName);
		log.info("Step 2: Input to Fisrt Name with data: " + firstName);
		registerPage.inputToFistName(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, lastName);
		log.info("Step 3: Input to Last Name with data: " + lastName);
		registerPage.inputToLastName(lastName);
	
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Input to Email with data: " + Register_Commons.emailAddress);
		log.info("Step 4: Input to Email with data: " + Register_Commons.emailAddress);
		registerPage.inputToEmail(Register_Commons.emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Input to Password with data: " + Register_Commons.password);
		log.info("Step 5: Input to Password with data: " + Register_Commons.password);
		registerPage.inputToPassword(Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Input to Confirm Password with data: " + Register_Commons.password);
		log.info("Step 6: Input to Confirm Password with data: " + Register_Commons.password);
		registerPage.inputToConfirmPassword(Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Click on Register button");
		log.info("Step 7: Click on Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify the error: Existing Email");
		log.info("Step 8: Verify the error: Existing Email");
		Assert.assertTrue(registerPage.isExistingEmailErrorDisplayed());

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Characters(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 05 - Register with password less then 6 characters");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Register link");
		log.info("Step 1: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Fisrt Name with data: " + firstName);
		log.info("Step 2: Input to Fisrt Name with data: " + firstName);
		registerPage.inputToFistName(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input to Last Name with data: " + lastName);
		log.info("Step 3: Input to Last Name with data: " + lastName);
		registerPage.inputToLastName(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Input to Email with data: " + Register_Commons.emailAddress);
		log.info("Step 4: Input to Email with data: " + Register_Commons.emailAddress);
		registerPage.inputToEmail(Register_Commons.emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Input to Password with data: " + wrongPassword);
		log.info("Step 5: Input to Password with data: " + wrongPassword);
		registerPage.inputToPassword(wrongPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Input to Confirm Password with data: " + wrongPassword);
		log.info("Step 6: Input to Confirm Password with data: " + wrongPassword);
		registerPage.inputToConfirmPassword(wrongPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Click on Register button");
		log.info("Step 7: Click on Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify the error: 'Password must meet the following rules:\nmust have at least 6 characters' display");
		log.info("Step 8: Verify the error: 'Password must meet the following rules:\nmust have at least 6 characters' display");
		Assert.assertEquals(registerPage.getErrorMessagePassword(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void TC_06_Register_Invalid_Comfirm_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 06 - Register with invalid confirm password");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Register link");
		log.info("Step 1: Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Fisrt Name with data: " + firstName);
		log.info("Step 2: Input to Fisrt Name with data: " + firstName);
		registerPage.inputToFistName(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input to Last Name with data: " + lastName);
		log.info("Step 3: Input to Last Name with data: " + lastName);
		registerPage.inputToLastName(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Input to Email with data: " + Register_Commons.emailAddress);
		log.info("Step 4: Input to Email with data: " + Register_Commons.emailAddress);
		registerPage.inputToEmail(Register_Commons.emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Input to Password with data: " + Register_Commons.password);
		log.info("Step 5: Input to Password with data: " + Register_Commons.password);
		registerPage.inputToPassword("Step 5: Input to Password with data: " + Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Input to Confirm Password with data: " + wrongPassword);
		log.info("Step 6: Input to Confirm Password with data: " + wrongPassword);
		registerPage.inputToConfirmPassword(wrongPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Click on Register button");
		log.info("Step 7: Click on Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify the error: 'The password and confirmation password do not match.' display");
		log.info("Step 8: Verify the error: 'The password and confirmation password do not match.' display");
		Assert.assertEquals(registerPage.getErrorMessageConfirmPassword(), "The password and confirmation password do not match.");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

}
