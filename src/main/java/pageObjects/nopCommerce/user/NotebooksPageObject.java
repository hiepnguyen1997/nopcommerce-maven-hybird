package pageObjects.nopCommerce.user;


import org.openqa.selenium.WebDriver;

import commons.ListPageAtTopMenu;

public class NotebooksPageObject extends ListPageAtTopMenu{
	private WebDriver driver;

	public NotebooksPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
