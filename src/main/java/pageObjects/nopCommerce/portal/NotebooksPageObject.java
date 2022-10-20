package pageObjects.nopCommerce.portal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.ListPageAtTopMenu;
import pageUIs.nopCommerce.user.NoteBookPageUI;

public class NotebooksPageObject extends ListPageAtTopMenu{
	private WebDriver driver;

	public NotebooksPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectItemInSortByDropdown(String textItem) {
		waitForElementClickabled(driver, NoteBookPageUI.SORT_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver, NoteBookPageUI.SORT_BY_DROPDOWN, textItem);
	}

	public boolean isProductNameSortAtoZ() {
		ArrayList<String> productNameUI = new ArrayList<String>();
		List<WebElement> productsName = getListWebElement(driver, NoteBookPageUI.PRODUCT_NAME);
		for(WebElement item : productsName) {
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
		List<WebElement> productsName = getListWebElement(driver, NoteBookPageUI.PRODUCT_NAME);
		for(WebElement item : productsName) {
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

}
