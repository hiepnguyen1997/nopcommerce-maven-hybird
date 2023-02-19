package pageObjects.nopCommerce.user;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.FooterListMenuPage;
import pageUIs.nopCommerce.user.SearchPageUI;

public class UserSearchPageObject extends FooterListMenuPage{

	private WebDriver driver;
	public UserSearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean isSearchPageTiTleDisplay() {
		waitForAllElementsVisible(driver, SearchPageUI.SEARCH_PAGE_TITLE);
		return isElementDisplayed(driver, SearchPageUI.SEARCH_PAGE_TITLE);
	}
	
	public String getSearchResultMessage() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_RESULT_MESSAGE);
		return getElementText(driver, SearchPageUI.SEARCH_RESULT_MESSAGE);
	}
	
	public void inputToSearchTextbox(String textValue) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXT_BOX);
		sendkeyToElement(driver, SearchPageUI.SEARCH_TEXT_BOX, textValue);
	}
	
	public void clickOnSearchButton() {
		waitForElementVisible(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	
	public void selectItemInCategoryDropdown(String itemCategory) {
		waitForElementClickabled(driver, SearchPageUI.CATEGORY_DROPDOWNLIST);
		selectItemInDefaultDropdown(driver, SearchPageUI.CATEGORY_DROPDOWNLIST, itemCategory);
	}
	
	public void selectItemInManufacturerDropdown(String itemManufacturer) {
		waitForElementClickabled(driver, SearchPageUI.MANUFACTURER_DROPDOWNLIST);
		selectItemInDefaultDropdown(driver, SearchPageUI.MANUFACTURER_DROPDOWNLIST, itemManufacturer);
	} 

	public boolean isProductByNameDisplay(String expectedProductName) {
		boolean mapping = false;
		ArrayList<String> listProductName = new ArrayList<String>();
		List <WebElement> productItem = getListWebElement(driver, SearchPageUI.SEARCH_RESULT_PRODUCT);
		for(WebElement eachItem : productItem) {
			listProductName.add(eachItem.getText().trim());
			System.out.println(eachItem.getText().trim());
		}
		for(String productName : listProductName) {
			if(productName.equals(expectedProductName)) {
				mapping = !mapping;
				break;
			}
		}
		return mapping;
	}

}
