package hybrid.nopcommerce.commons;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import exception.BrowserNotSupport;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.UserRegisterPageObject;
import utilities.EnvironmentConfig;
import utilities.FakeDataHelper;

public class Register_Commons extends BaseTest{
	private WebDriver driver;
	private String dayOfBirth, monthOfBirth, yearOfBirth;
	public static String firstName, lastName, emailAddress, password;
	UserRegisterPageObject registerPage;
	UserHomePageObject homePage;
	FakeDataHelper fakeDataHelper;
	EnvironmentConfig environmentConfig;
	
	@Parameters({"browser", "environment"})
	@BeforeTest
	public void beforeTest(String browserName, String environmentName) throws BrowserNotSupport {
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		driver = getBrowserDriverMananment(browserName, environmentConfig.getWebURL());
		fakeDataHelper = FakeDataHelper.getFakeDataHelper();
		firstName = fakeDataHelper.getFirstName();
		lastName = fakeDataHelper.getLastName();
		password = fakeDataHelper.getPassword();
		emailAddress = fakeDataHelper.getEmailAddress();
		dayOfBirth = "11";
		monthOfBirth = "August";
		yearOfBirth = "1997";
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Pre-Condidtion: Step 1 - Click on Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Pre-Condidtion: Step 2 - Input to FirstName textbox by: " + firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Pre-Condidtion: Step 3 - Input to LasttName textbox by: " + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		log.info("Pre-Conditon: Step 4 - Select Day with data: " + dayOfBirth);
		registerPage.selectValueInDropDownByName(driver, "DateOfBirthDay", dayOfBirth);

		log.info("Pre-Conditon: Step 5 - Select Month with data: " + monthOfBirth);
		registerPage.selectValueInDropDownByName(driver, "DateOfBirthMonth", monthOfBirth);

		log.info("Pre-Conditon: Step 6 - Select Year with data: " + yearOfBirth);
		registerPage.selectValueInDropDownByName(driver, "DateOfBirthYear", yearOfBirth);
		
		log.info("Pre-Condidtion: Step 7 - Input to Email textbox by: " + emailAddress);
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);
		
		log.info("Pre-Condidtion: Step 8 - Input to Password textbox by: " + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		
		log.info("Pre-Condidtion: Step 9 - Input to Confirm Password textbox by: " + password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);
		
		log.info("Pre-Condidtion: Step 10 - Click on Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre-Condidtion: Step 11 - Verify Register message successfull display");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		homePage = registerPage.clickOnLougoutLinkUserPage(driver);
		driver.quit();
	}
	
	@AfterTest()
	public void afterTest() {
	}
}
