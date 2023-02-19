package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class AdminProductDetailPageObject extends BasePage{
	
	WebDriver driver;
	
	public AdminProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

}
