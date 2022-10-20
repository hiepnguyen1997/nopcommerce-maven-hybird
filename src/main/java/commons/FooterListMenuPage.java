package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.portal.UserSearchPageObject;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;

public class FooterListMenuPage extends BasePage{
	
	private WebDriver driver;
	
	public FooterListMenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public UserSearchPageObject openSearchPage() {
		waitForElementVisible(driver, BasePageUINopCommerce.FOOTER_SEARCH_PAGE);
		clickToElement(driver, BasePageUINopCommerce.FOOTER_SEARCH_PAGE);
		return PageGeneratorManager.getSearchPageObjet(driver);
	}
	
	public FooterListMenuPage openPageAtFooterByPageName(String pageName) {
		waitForElementVisible(driver, BasePageUINopCommerce.PAGE_AT_FOOTER_BY_NAME, pageName);
		clickToElement(driver, BasePageUINopCommerce.PAGE_AT_FOOTER_BY_NAME, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getSearchPageObjet(driver);

		default:
			throw new RuntimeException("Invalid page name. Please try again");
		}
	}
}
