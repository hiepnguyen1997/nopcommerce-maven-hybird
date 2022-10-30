package pageObjects.nopCommerce.portal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.FooterListMenuPage;
import pageUIs.nopCommerce.user.RecentlyViewProductPageUI;

public class RecentlyViewProductPageObject extends FooterListMenuPage {
	private WebDriver driver;

	public RecentlyViewProductPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public int getProductSizeDisplay() {
		waitForAllElementsVisible(driver, RecentlyViewProductPageUI.PRODUCT_BY_NAME_AT_RECENTTLY_VIEW);
		return getElementSize(driver, RecentlyViewProductPageUI.PRODUCT_BY_NAME_AT_RECENTTLY_VIEW);
	}

	public boolean isLast3ProducstDisplayedFromListProduct(String... listValue) {
		int sizeListProduct = listValue.length;
		Collections.reverse(Arrays.asList(listValue));
		for (String test : listValue) {
			System.out.println(test);
		}
		ArrayList<String> tempReviewsProduct = new ArrayList<String>();
		for (int i = 0; i < getProductSizeDisplay(); i++) {
			tempReviewsProduct.add(listValue[i]);
		}
		
		ArrayList<String> recentProductUI = new ArrayList<String>();
		List<WebElement> allProductitem = getListWebElement(driver, RecentlyViewProductPageUI.PRODUCT_BY_NAME_AT_RECENTTLY_VIEW);
		for (WebElement item : allProductitem) {
			recentProductUI.add(item.getText().trim());
		}
		return recentProductUI.equals(tempReviewsProduct);
	}
}
