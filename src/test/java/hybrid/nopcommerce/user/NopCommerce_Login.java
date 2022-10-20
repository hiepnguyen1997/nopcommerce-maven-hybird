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
import pageObjects.nopCommerce.portal.UserLoginPageObject;
import reportConfig.ExtentTestManager;

public class NopCommerce_Login extends BaseTest {
	WebDriver driver;
	String invalidEmail, notFoundEmail, wrongPassword;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String environmentName) throws BrowserNotSupport {
		driver = getBrowserDriver(browserName);
		driver.get(getEnvironmentName(environmentName));
		invalidEmail = "123@dasd.#22";
		notFoundEmail = "test" + getRandomNumber() + "@gmail.vn";
		wrongPassword = "147258";
		homePage = PageGeneratorManager.getUserHomePage(driver);
	}

	@Test
	public void Login_01_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Login link");
		log.info("Login TC 01 - Step 1: Click on Login link");
		loginPage = homePage.clickOnLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Click on Login button");
		log.info("Login TC 01 - Step 2: Click on Login button");
		loginPage.clickOnLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Verify the message 'Please enter your email' displayed");
		log.info("Login TC 01 - Step 3: Verify the message 'Please enter your email' displayed");
		Assert.assertEquals(loginPage.getErrorMessageEmailTexbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02 - Login with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Login link");
		log.info("Step 1: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to email with data: " + invalidEmail);
		log.info("Step 2: Input to email with data: " + invalidEmail);
		loginPage.inputToEmailTextBox(invalidEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on Login button");
		log.info("Step 3: Click on Login button");
		loginPage.clickOnLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Login link");
		log.info("Step 4: Verify the message 'Wrong email' displayed");
		Assert.assertEquals(loginPage.getErrorMessageEmailTexbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_NotFound(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 03 - Login with email not found");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Login link");
		log.info("Step 1: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to email with data: " + notFoundEmail);
		log.info("Step 2: Input to email with data: " + notFoundEmail);
		loginPage.inputToEmailTextBox(notFoundEmail);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on Login button");
		log.info("Step 3: Click on Login button");
		loginPage.clickOnLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Verify the message 'Login was unsuccessful. Please correct the errors and try again.\nNo customer account found' displayed");
		log.info("Step 4: Verify the message 'Login was unsuccessful. Please correct the errors and try again.\nNo customer account found' displayed");
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	}

	@Test
	public void Login_04_Valid_Email_Empty_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 04 - Login with valid email and empty password ");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Login link");
		log.info("Step 1: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to email with data: " + Register_Commons.emailAddress);
		log.info("Step 2: Input to email with data: " + Register_Commons.emailAddress);
		loginPage.inputToEmailTextBox(Register_Commons.emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on Login button");
		log.info("Step 3: Click on Login button");
		loginPage.clickOnLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Verify the message 'Login was unsuccessful. Please correct the errors and try again. \nThe credentials provided are incorrect");
		log.info("Step 4: Verify the message 'Login was unsuccessful. Please correct the errors and try again. \nThe credentials provided are incorrect");
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_05_Valid_Email_Incorrect_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 05 - Login with valid email and incorrect password ");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Login link");
		log.info("Step 1: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to email with data: " + Register_Commons.emailAddress);
		log.info("Step 2: Input to email with data: " + Register_Commons.emailAddress);
		loginPage.inputToEmailTextBox(Register_Commons.emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input to password with data: " + wrongPassword);
		log.info("Step 3: Input to password with data: " + wrongPassword);
		loginPage.inputToPasswordTextBox(wrongPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Click on Login button");
		log.info("Step 4: Click on Login button");
		loginPage.clickOnLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Verify the message 'Login was unsuccessful. Please correct the errors and try again. \nThe credentials provided are incorrect");
		log.info("Step 5: Verify the message 'Login was unsuccessful. Please correct the errors and try again. \nThe credentials provided are incorrect");
		Assert.assertEquals(loginPage.getInvalidErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void Login_06_Login_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 06 - Login with valid email and password ");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Login link");
		log.info("Step 1: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to email with data: " + Register_Commons.emailAddress);
		log.info("Step 2: Input to email with data: " + Register_Commons.emailAddress);
		loginPage.inputToEmailTextBox(Register_Commons.emailAddress);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input to password with data: " + Register_Commons.password);
		log.info("Step 3: Input to password with data: " + Register_Commons.password);
		loginPage.inputToPasswordTextBox(Register_Commons.password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Click on Login button");
		log.info("Step 4: Click on Login button");
		homePage = loginPage.clickOnLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Verify the My Account link page dispalyed");
		log.info("Step 5: Verify the My Account link page dispalyed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		homePage.clickOnLougoutLinkUserPage(driver);
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
