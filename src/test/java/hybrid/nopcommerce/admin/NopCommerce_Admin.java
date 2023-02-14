package hybrid.nopcommerce.admin;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import utilities.EnvironmentConfig;

public class NopCommerce_Admin extends BaseTest{
	private WebDriver driver;
	AdminLoginPageObject loginPageAdmin;
	EnvironmentConfig environment;
	
	private String emailLoginAdmin, passwordLoginAdmin;
	
	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {
		ConfigFactory.setProperty("evn", environmentName);
		environment = ConfigFactory.create(EnvironmentConfig.class);
		emailLoginAdmin = environment.getEmail();
		passwordLoginAdmin = environment.getPassword();
		driver = getBrowserDriverMananment(browserName, environment.getWebURL());
		
		loginPageAdmin = PageGeneratorManager.getLoginPageAdmin(driver);
		log.info("Pre-Conditions: Login as Admin with email :" + emailLoginAdmin +" and password: " + passwordLoginAdmin);
		loginPageAdmin.loginAsAdmin(emailLoginAdmin, passwordLoginAdmin);
	}
	
	@Test
	public void TC_01_Search() {
		
	}
	
//	@AfterClass(alwaysRun = true)
//		public void afterClass() {
//		closeBrowserAndDriver();
//	}
	

}
