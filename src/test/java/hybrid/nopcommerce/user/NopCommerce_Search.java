package hybrid.nopcommerce.user;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.data.NopCommerceTestData;

import commons.BaseTest;
import commons.PageGeneratorManager;
import exception.BrowserNotSupport;
import hybrid.nopcommerce.commons.Register_Commons;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserSearchPageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;

public class NopCommerce_Search extends BaseTest{
	private WebDriver driver;
	
	UserHomePageObject homePage;
	UserLoginPageObject loginPage;
	UserSearchPageObject searchPage;
	private EnvironmentConfig environmentConfig;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String environmentName) throws BrowserNotSupport {
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		driver = getBrowserDriverMananment(browserName, environmentConfig.getWebURL());
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Pre-Condition: Step 1: Click on Login link");
		loginPage = homePage.clickOnLoginLink();
		
		log.info("Pre-Condition: Step 2: Input to Email textbox with: " + Register_Commons.emailAddress);
		loginPage.inputToTextboxByID(driver, "Email", Register_Commons.emailAddress);
		
		log.info("Pre-Condition: Step 3: Input to Email textbox with: " + Register_Commons.password);
		loginPage.inputToTextboxByID(driver, "Password", Register_Commons.password);
		
		log.info("Pre-Condition: Step 4: Click on Login button");
		homePage = loginPage.clickOnLoginButton();
		
		log.info("Pre-Condition: Step 5: Verify My Account link display after Login successfull");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	@Test
	public void TC_01_Search_Empty_Data(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 01: Search with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Click on Search button");
		log.info("Step 2: Click on Search link at footer");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Verify the message 'Search term minimum length is 3 characters' display");
		log.info("Step 3: Click on Search link at footer");
		Assert.assertEquals(searchPage.getSearchResultMessage(), "Search term minimum length is 3 characters");	
	}
	
	@Test
	public void TC_02_Search_With_Data_Not_Exsit(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 02: Search with not exist");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Input to Search textbox with data: " + NopCommerceTestData.SearchData.DATA_NOT_EXIST);
		log.info("Step 1: Input to Search textbox with data: " + NopCommerceTestData.SearchData.DATA_NOT_EXIST);
		searchPage.inputToSearchTextbox(NopCommerceTestData.SearchData.DATA_NOT_EXIST);
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on Search button");
		log.info("Step 3: Click on Search link at footer");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Verify the message 'No products were found that matched your criteria.' display");
		log.info("Step 4: Verify the message 'No products were found that matched your criteria.' display");
		Assert.assertEquals(searchPage.getSearchResultMessage(), "No products were found that matched your criteria.");
		
	}
	
	@Test
	public void TC_03_Search_With_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 03: Search with product name");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Input to Search textbox with data: Lenovo");
		log.info("Step 1: Input to Search textbox with data: Lenovo");
		searchPage.inputToSearchTextbox("Lenovo");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on Search button");
		log.info("Step 3: Click on Search link at footer");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Verify 2 products display");
		log.info("Step 4: Verify 2 products display");
		Assert.assertTrue(searchPage.isProductByNameDisplay("Lenovo IdeaCentre 600 All-in-One PC"));
		Assert.assertTrue(searchPage.isProductByNameDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
	}
	
	@Test
	public void TC_04_Search_With_Product_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 04: Search with product name");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Input to Search textbox with data: ThinkPad X1 Carbon");
		log.info("Step 1: Input to Search textbox with data: Thinkpad X1 Carbon");
		searchPage.inputToSearchTextbox("Thinkpad X1 Carbon");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on Search button");
		log.info("Step 3: Click on Search link at footer");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Verify 'Lenovo Thinkpad X1 Carbon Laptop' products display");
		log.info("Step 4: Verify 'Lenovo Thinkpad X1 Carbon Laptop' products display");
		Assert.assertTrue(searchPage.isProductByNameDisplay("Lenovo Thinkpad X1 Carbon Laptop"));
	}
	
	@Test
	public void TC_05_Advance_Search_With_Parent_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 05: Search advance parent category");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Search textbox with data: Apple MacBook Pro");
		log.info("Step 2: Input to Search textbox with data: Apple MacBook Pro");
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Input to Search textbox with data: Apple MacBook Pro");
		log.info("Step 3: Input to Search textbox with data: Apple MacBook Pro");
		searchPage.clickOnRadioButtonByLabelName(driver, "Advanced search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Select 'Computers' item in category");
		log.info("Step 4: Select 'Computers' item in category");
		searchPage.selectItemInCategoryDropdown("Computers");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Click on Search button");
		log.info("Step 5: Click on Search button");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Verify the message 'No products were found that matched your criteria.' display");
		log.info("Step 6: Verify the message 'No products were found that matched your criteria.' display");
		Assert.assertEquals(searchPage.getSearchResultMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_06_Advance_Search_With_Sub_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 05: Search advance sub category");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Search textbox with data: Apple MacBook Pro");
		log.info("Step 2: Input to Search textbox with data: Apple MacBook Pro");
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on 'Advance' checkbox");
		log.info("Step 3: Click on Advance checkbox");
		searchPage.clickOnRadioButtonByLabelName(driver, "Advanced search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Select 'Computers' item in category");
		log.info("Step 4: Select 'Computers' item in category");
		searchPage.selectItemInCategoryDropdown("Computers");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Click on 'Automatically search sub categories' checkbox");
		log.info("Step 5: Click on 'Automatically search sub categories' checkbox");
		searchPage.clickOnRadioButtonByLabelName(driver, "Automatically search sub categories");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Click on Search button");
		log.info("Step 6: Click on Search button");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Verify 'Apple MacBook Pro 13-inch' products display");
		log.info("Step 7: Verify 'Apple MacBook Pro 13-inch' products display");
		Assert.assertTrue(searchPage.isProductByNameDisplay("Apple MacBook Pro 13-inch"));
	}
	
	@Test
	public void TC_07_Advance_Search_With_Incorrect_Manufacturer(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 07: Search advance in correct manufacturer");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Search textbox with data: Apple MacBook Pro");
		log.info("Step 2: Input to Search textbox with data: Apple MacBook Pro");
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on 'Advance' checkbox");
		log.info("Step 3: Click on Advance checkbox");
		searchPage.clickOnRadioButtonByLabelName(driver, "Advanced search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Select 'Computers' item in category");
		log.info("Step 4: Select 'Computers' item in category");
		searchPage.selectItemInCategoryDropdown("Computers");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Click on 'Automatically search sub categories' checkbox");
		log.info("Step 5: Click on 'Automatically search sub categories' checkbox");
		searchPage.clickOnRadioButtonByLabelName(driver, "Automatically search sub categories");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Select 'HP' item in Manufacturer");
		log.info("Step 6: Select 'HP' item in Manufacturer");
		searchPage.selectItemInManufacturerDropdown("HP");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Click on Search button");
		log.info("Step 7: Click on Search button");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify the message 'No products were found that matched your criteria.' display");
		log.info("Step 8: Verify the message 'No products were found that matched your criteria.' display");
		Assert.assertEquals(searchPage.getSearchResultMessage(), "No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_08_Advands_Search_With_Parent_Category(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC 05: Search advand parent category");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: Click on Search link at footer");
		log.info("Step 1: Click on Search link at footer");
		searchPage = (UserSearchPageObject) homePage.getFooterListMenu(driver).openPageAtFooterByPageName("Search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: Input to Search textbox with data: Apple MacBook Pro");
		log.info("Step 2: Input to Search textbox with data: Apple MacBook Pro");
		searchPage.inputToSearchTextbox("Apple MacBook Pro");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 3: Click on 'Advance' checkbox");
		log.info("Step 3: Click on Advance checkbox");
		searchPage.clickOnRadioButtonByLabelName(driver, "Advanced search");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 4: Select 'Computers' item in category");
		log.info("Step 4: Select 'Computers' item in category");
		searchPage.selectItemInCategoryDropdown("Computers");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 5: Click on 'Automatically search sub categories' checkbox");
		log.info("Step 5: Click on 'Automatically search sub categories' checkbox");
		searchPage.clickOnRadioButtonByLabelName(driver, "Automatically search sub categories");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 6: Select 'HP' item in Manufacturer");
		log.info("Step 6: Select 'HP' item in Manufacturer");
		searchPage.selectItemInManufacturerDropdown("Apple");
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 7: Click on Search button");
		log.info("Step 7: Click on Search button");
		searchPage.clickOnSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify 'Apple MacBook Pro 13-inch' products display");
		log.info("Step 8: Verify 'Apple MacBook Pro 13-inch' products display");
		Assert.assertTrue(searchPage.isProductByNameDisplay("Apple MacBook Pro 13-inch"));
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
