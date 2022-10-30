package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.portal.UserSearchPageObject;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;
import pageUIs.nopCommerce.user.FooterListPageUI;

public class FooterListMenuPage extends BasePage {

	private WebDriver driver;

	public FooterListMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public FooterListMenuPage openPageAtFooterByPageName(String pageName) {
		waitForElementVisible(driver, FooterListPageUI.PAGE_AT_FOOTER_BY_NAME, pageName);
		clickToElement(driver, FooterListPageUI.PAGE_AT_FOOTER_BY_NAME, pageName);
		switch (pageName) {
		case "Search":
			return PageGeneratorManager.getSearchPageObjet(driver);
		case "Compare products list":
			return PageGeneratorManager.getCompareListPage(driver);
		case "Recently viewed products":
			return PageGeneratorManager.getRecentlyViewPage(driver);
		default:
			throw new RuntimeException("Invalid page name. Please try again");
		}
	}
}
