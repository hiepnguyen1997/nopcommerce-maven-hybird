package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.portal.ListProductPage;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;

public class ListPageAtTopMenu extends ListProductPage{
	private WebDriver driver;
	
	public ListPageAtTopMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public ListPageAtTopMenu openPageAtTopMenuByPageName(String menuName, String subMenuName) {
		waitForElementVisible(driver, BasePageUINopCommerce.TOP_MENU_BY_NAME, menuName);
		hoverMouseToElement(driver, BasePageUINopCommerce.TOP_MENU_BY_NAME, menuName);
		waitForElementVisible(driver, BasePageUINopCommerce.SUB_MENU_BY_NAME, subMenuName);
		clickToElement(driver, BasePageUINopCommerce.SUB_MENU_BY_NAME, subMenuName);
		switch (subMenuName) {
		case "Desktops":
			return PageGeneratorManager.getDesktopsPage(driver);
		case "Notebooks":
			return PageGeneratorManager.getNotebooksPage(driver);
		default:
			throw new RuntimeException("Invalid Sub Menu Name at top menu");
		}
	}
}
