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

import commons.BaseTest;
import commons.PageGeneratorManager;
import exception.BrowserNotSupport;
import pageObjects.nopCommerce.user.NotebooksPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import reportConfig.ExtentTestManager;
import utilities.EnvironmentConfig;

public class NopCommerce_Sort extends BaseTest {
    private WebDriver driver;
    UserHomePageObject homePage;
    NotebooksPageObject notebookPage;
    private EnvironmentConfig environmentConfig;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName, String environmentName) throws BrowserNotSupport {
		ConfigFactory.setProperty("evn", environmentName);
		environmentConfig = ConfigFactory.create(EnvironmentConfig.class);
		driver = getBrowserDriverMananment(browserName, environmentConfig.getWebURL());
        homePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Test
    public void TC_01_Sort_Name_A_To_Z(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC 01 : Sort with Name A To Z");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Computer/NoteBooks Page");
        log.info("Step 01: Navigate to Computer/NoteBooks Page");
        notebookPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select Name: A To Z");
        log.info("Step 02: Select Name: A To Z");
        notebookPage.selectItemInSortByDropdown("Name: A to Z");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the product name sort correctly");
        log.info("Step 03: Verify the product name sort correctly");
        Assert.assertTrue(notebookPage.isProductNameSortAtoZ());

    }

   @Test
    public void TC_02_Sort_Name_Z_To_A(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC 02 : Sort with Name Z To A");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Computer/NoteBooks Page");
        log.info("Step 01: Navigate to Computer/NoteBooks Page");
        notebookPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select Name: Z To A");
        log.info("Step 02: Select Name:  Z to A");
        notebookPage.selectItemInSortByDropdown("Name: Z to A");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the product name sort correctly");
        log.info("Step 03: Verify the product name sort correctly");
        Assert.assertTrue(notebookPage.isProductNameSortZtoA());
    }

    @Test
    public void TC_03_Sort_Price_Low_To_High(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC 03 : Sort with price Low to High");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Computer/NoteBooks Page");
        log.info("Step 01: Navigate to Computer/NoteBooks Page");
        notebookPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select Price: Low to High");
        log.info("Step 02: Select Price: Low to High");
        notebookPage.selectItemInSortByDropdown("Price: Low to High");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the product name sort correctly");
        log.info("Step 03: Verify the product name sort correctly");
        Assert.assertTrue(notebookPage.isProductNamePriceLowToHigh());
    }

    @Test
    public void TC_04_Sort_Price_High_To_Low(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC 04 : Sort with price High to Low");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Computer/NoteBooks Page");
        log.info("Step 01: Navigate to Computer/NoteBooks Page");
        notebookPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select Price: High to Low");
        log.info("Step 02: Select Price: High to Low");
        notebookPage.selectItemInSortByDropdown("Price: High to Low");

        ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the product name sort correctly");
        log.info("Step 03: Verify the product name sort correctly");
        Assert.assertTrue(notebookPage.isProductNamePriceHighToLow());
    }

    @Test
    public void TC_05_Display_3_Product_In_Page(Method method) {
    	ExtentTestManager.startTest(method.getName(), "TC 05: Verify display 3 product when select paing is 3");
    	ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Computer/NoteBooks Page");
    	log.info("Step 01: Navigate to Computer/NoteBooks Page");
    	notebookPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Step 02: Paging display is 3");
    	log.info("Step 02: Paging display is 3");
    	notebookPage.selectItemInDisplayDropdown("3");
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the product name sort correctly");
    	log.info("Step 03: Verify the product name sort correctly");
    	Assert.assertTrue(notebookPage.isProductDisplayByNumber(3));
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify Next icon display and click on it");
    	log.info("Step 04: Verify Next icon display and click on it");
    	Assert.assertFalse(notebookPage.isPagingUnDisplay());
    	Assert.assertTrue(notebookPage.isNextIconDisplay());
    	notebookPage.clickOnTheNextIcon();
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Step 05: Verify Previous icon display and click on it");
    	log.info("Step 05: Verify Previous icon display and click on it");
    	Assert.assertFalse(notebookPage.isPagingUnDisplay());
    	Assert.assertTrue(notebookPage.isPreviousIconDisplay());
    	notebookPage.clickOnThePreviousIcon();
    	
    }
    
    @Test
    public void TC_06_Display_6_Product_In_Page(Method method) {
    	ExtentTestManager.startTest(method.getName(), "TC 05: Verify display 3 product when select paing is 6");
    	ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Computer/NoteBooks Page");
    	log.info("Step 01: Navigate to Computer/NoteBooks Page");
    	notebookPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select Paging display is 6");
    	log.info("Step 02: Select Paging display is 6");
    	notebookPage.selectItemInDisplayDropdown("6");
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Step 03: Verify the product name sort correctly");
    	log.info("Step 03: Verify the product name sort correctly");
    	Assert.assertTrue(notebookPage.isProductDisplayByNumber(6));
    	
    	ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the paging section not display");
    	log.info("Step 04: Verify Next icon display and click on it");
    	Assert.assertTrue(notebookPage.isPagingUnDisplay());
    }
    
    @Test
    public void TC_07_Display_9_Product_In_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC 05: Verify display 9 product when select paing is 3");
        ExtentTestManager.getTest().log(Status.INFO, "Step 01: Navigate to Computer/NoteBooks Page");
        log.info("Step 01: Navigate to Computer/NoteBooks Page");
        notebookPage = (NotebooksPageObject) homePage.getListPage(driver).openPageAtTopMenuByPageName("Computers", "Notebooks");

        ExtentTestManager.getTest().log(Status.INFO, "Step 02: Select Paging display is 9");
        log.info("Step 02: Select Paging display is 9");
        notebookPage.selectItemInDisplayDropdown("9");

        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify the paging section not display");
        log.info("Step 03: Verify the product name sort correctly");
        Assert.assertTrue(notebookPage.isProductDisplayByNumber(9));
        
        ExtentTestManager.getTest().log(Status.INFO, "Step 04: Verify Next icon display and click on it");
        log.info("Step 04: Verify Next icon display and click on it");
        Assert.assertTrue(notebookPage.isPagingUnDisplay());
    }

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}
}
