package pageObjects.nopCommerce.portal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.user.ListProductPageUI;

public class ListProductPage extends BasePage {
	WebDriver driver;

	public ListProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public ProductDetailPageObject clickOnProductByName(String productName) {
		waitForElementVisible(driver, ListProductPageUI.PRODUCT_BY_NAME, productName);
		clickToElement(driver, ListProductPageUI.PRODUCT_BY_NAME, productName);
		return PageGeneratorManager.getProductPage(driver);
	}

	public void selectItemInSortByDropdown(String textItem) {
		waitForElementClickabled(driver, ListProductPageUI.SORT_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver, ListProductPageUI.SORT_BY_DROPDOWN, textItem);
		sleepInSecond(3);
	}

	public boolean isProductNameSortAtoZ() {
		ArrayList<String> productNameUI = new ArrayList<String>();
		List<WebElement> productsName = getListWebElement(driver, ListProductPageUI.PRODUCT_NAME);
		for (WebElement item : productsName) {
			productNameUI.add(item.getText().trim());
		}
		ArrayList<String> productNameSort = new ArrayList<String>();
		for (String name : productNameUI) {
			productNameSort.add(name);
		}
		Collections.sort(productNameSort);
		return productNameUI.equals(productNameSort);
	}

	public boolean isProductNameSortZtoA() {
		ArrayList<String> productNameUI = new ArrayList<String>();
		List<WebElement> productsName = getListWebElement(driver, ListProductPageUI.PRODUCT_NAME);
		for (WebElement item : productsName) {
			productNameUI.add(item.getText().trim());
		}
		ArrayList<String> productNameSort = new ArrayList<String>();
		for (String name : productNameUI) {
			productNameSort.add(name);
		}
		Collections.sort(productNameSort);
		Collections.reverse(productNameSort);
		return productNameUI.equals(productNameSort);
	}

	public boolean isProductNamePriceLowToHigh() {
		ArrayList<Float> productPriceUI = new ArrayList<Float>();
		List<WebElement> productsPrice = getListWebElement(driver, ListProductPageUI.PRODUCT_PRICE);
		for (WebElement item : productsPrice) {
			System.out.println("UI: " + item.getText().trim().replace("$", "").replace(",", ""));
			productPriceUI.add(Float.parseFloat(item.getText().trim().replace("$", "").replace(",", "")));
		}
		ArrayList<Float> productPriceSort = new ArrayList<Float>();
		for (Float price : productPriceUI) {
			productPriceSort.add(price);
		}
		Collections.sort(productPriceSort);
		for (float it : productPriceSort) {
			System.out.println("sort: " + it);
		}
		return productPriceUI.equals(productPriceSort);
	}

	public boolean isProductNamePriceHighToLow() {
		ArrayList<Float> productPriceUI = new ArrayList<Float>();
		List<WebElement> productsPrice = getListWebElement(driver, ListProductPageUI.PRODUCT_PRICE);
		for (WebElement item : productsPrice) {
			System.out.println("UI: " + item.getText().trim().replace("$", "").replace(",", ""));
			productPriceUI.add(Float.parseFloat(item.getText().trim().replace("$", "").replace(",", "")));
		}
		ArrayList<Float> productPriceSort = new ArrayList<Float>();
		for (float price : productPriceUI) {
			productPriceSort.add(price);
		}
		Collections.sort(productPriceSort);
		Collections.reverse(productPriceSort);
		for (Float it : productPriceSort) {
			System.out.println("sort: " + it);
		}
		return productPriceUI.equals(productPriceSort);
	}

	public void selectItemInDisplayDropdown(String textItem) {
		waitForElementClickabled(driver, ListProductPageUI.DISPLAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, ListProductPageUI.DISPLAY_DROPDOWN, textItem);
		sleepInSecond(3);
	}

	public boolean isProductDisplayByNumber(int paigingNumber) {
		waitForAllElementPresent(driver, ListProductPageUI.PRODUCT_ITEM);
		int numberProduct = getElementSize(driver, ListProductPageUI.PRODUCT_ITEM);
		if ((numberProduct == paigingNumber) || (numberProduct < paigingNumber)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isNextIconDisplay() {
		return isElementDisplayed(driver, ListProductPageUI.NEXT_PAGE_ICON);
	}

	public void clickOnTheNextIcon() {
		waitForElementClickabled(driver, ListProductPageUI.NEXT_PAGE_ICON);
		clickToElement(driver, ListProductPageUI.NEXT_PAGE_ICON);
		sleepInSecond(2);
	}

	public boolean isPreviousIconDisplay() {
		return isElementDisplayed(driver, ListProductPageUI.PREVIOUS_PAGE_ICON);
	}

	public void clickOnThePreviousIcon() {
		waitForElementClickabled(driver, ListProductPageUI.PREVIOUS_PAGE_ICON);
		clickToElement(driver, ListProductPageUI.PREVIOUS_PAGE_ICON);
		sleepInSecond(2);
	}

	public boolean isPagingUnDisplay() {
		return isElementUnDisplay(driver, ListProductPageUI.PRODUCT_PAGER);
	}

}
