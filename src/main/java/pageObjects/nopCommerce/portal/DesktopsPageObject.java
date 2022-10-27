package pageObjects.nopCommerce.portal;

import org.openqa.selenium.WebDriver;

import commons.ListPageAtTopMenu;

public class DesktopsPageObject extends ListPageAtTopMenu{
	private WebDriver driver;

	public DesktopsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
