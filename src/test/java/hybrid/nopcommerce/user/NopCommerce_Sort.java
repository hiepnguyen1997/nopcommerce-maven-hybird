package hybrid.nopcommerce.user;

import java.lang.reflect.Method;

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
import pageObjects.nopCommerce.portal.NotebooksPageObject;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import reportConfig.ExtentTestManager;

public class NopCommerce_Sort extends BaseTest {
    private WebDriver driver;
    UserHomePageObject homePage;
    NotebooksPageObject notebookPage;

    @Parameters({"browser", "environment"})
    @BeforeClass
    public void beforeClass(String browserName, String environmentName) throws BrowserNotSupport {
        driver = getBrowserDriver(browserName);
        driver.get(getEnvironmentName(environmentName));
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

    }

//	@AfterClass(alwaysRun = true)
//	public void afterClass() {
//		closeBrowserAndDriver();
//	}
}
