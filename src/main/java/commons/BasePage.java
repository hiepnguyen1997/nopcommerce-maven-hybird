package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bsh.commands.dir;
import pageObjects.nopCommerce.portal.UserHomePageObject;
import pageObjects.nopCommerce.portal.WishlistPageObject;
import pageUIs.nopCommerce.user.BasePageUINopCommerce;

public class BasePage {

	public static BasePage getBasePageObject() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void inputToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindowByID(WebDriver driver, String currentWindowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String tempID : allWindowIDs) {
			if (!tempID.equals(currentWindowID)) {
				driver.switchTo().window(tempID);
				break;
			}
		}
	}

	protected void switchToWindowByTitle(WebDriver driver, String pageTitle) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String tempID : allWindowIDs) {
			driver.switchTo().window(tempID);
			String currentPageTile = getPageTitle(driver);
			if (currentPageTile.equals(pageTitle)) {
				break;
			}
		}
	}

	protected void switchToWindowByIndex(WebDriver driver, int index) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		List<String> listWindowIDs = new ArrayList<>(allWindowIDs);
		String expectedWindow = listWindowIDs.get(index);
		driver.switchTo().window(expectedWindow);
	}

	protected void closeWindowByIndex(WebDriver driver, int index) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		List<String> listWindowIDs = new ArrayList<>(allWindowIDs);
		String expectedWindow = listWindowIDs.get(index);
		driver.switchTo().window(expectedWindow);
		driver.close();
	}

	protected void closeWindowWithoutParent(WebDriver driver, String parentWindowID) {
		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String tempID : allWindowIDs) {
			if (!tempID.equals(parentWindowID)) {
				driver.switchTo().window(tempID);
				driver.close();
			}
			driver.switchTo().window(parentWindowID);
		}
	}

	private By getByLocator(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("NAME=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=") || locatorType.startsWith("XPATH=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("The system NOT support this Locator type");
		}
		return by;
	}

	private String getDynamicXpath(String locatorType, String... params) {
		if (locatorType.startsWith("xpath=") || locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=") || locatorType.startsWith("XPATH=")) {
			locatorType = String.format(locatorType, (Object[]) params);
		} else if (locatorType.startsWith("id=") || locatorType.startsWith("Id=") || locatorType.startsWith("ID=")) {
			locatorType = String.format(locatorType, (Object[]) params);
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("Css=") || locatorType.startsWith("CSS=")) {
			locatorType = String.format(locatorType, (Object[]) params);
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("Class=") || locatorType.startsWith("CLASS=")) {
			locatorType = String.format(locatorType, (Object[]) params);
		} else {
			throw new RuntimeException("Invalid locator");
		}
		return locatorType;
	}

	private WebElement getWebElement(WebDriver driver, String locatorType) {
		return driver.findElement(getByLocator(locatorType));
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
		return driver.findElements(getByLocator(locatorType));
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String locatorType, String... params) {
		return driver.findElements(getByLocator(getDynamicXpath(locatorType, params)));
	}

	protected void clickToElement(WebDriver driver, String locatorType) {
		getWebElement(driver, locatorType).click();
	}

	protected void clickToElement(WebDriver driver, String locatorType, String... params) {
		getWebElement(driver, getDynamicXpath(locatorType, params)).click();
	}

	protected void sendkeyToElement(WebDriver driver, String locatorType, String value) {
		WebElement element = getWebElement(driver, locatorType);
		element.clear();
		element.sendKeys(value);
	}

	protected void sendkeyToElement(WebDriver driver, String locatorType, String value, String... params) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, params));
		element.clear();
		element.sendKeys(value);
	}

	protected void clearTextInElementByKey(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String value) {
		Select select = new Select(getWebElement(driver, locatorType));
		select.selectByVisibleText(value);
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String value, String... params) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, params)));
		select.selectByVisibleText(value);
	}

	protected String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {
		Select select = new Select(getWebElement(driver, locatorType));
		return select.getFirstSelectedOption().getText();
	}

	protected String getSelectedItemDefaultDropdown(WebDriver driver, String locatorType, String... params) {
		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, params)));
		return select.getFirstSelectedOption().getText();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String openDropdownLocator, String childLocator, String expectedValue) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		clickToElement(driver, openDropdownLocator);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement tempItem : allItems) {
			String actualValue = tempItem.getText();
			if (actualValue.equals(expectedValue)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView('true');", tempItem);
				tempItem.click();
				break;
			}
		}
	}

	protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}

	protected String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... params) {
		return getWebElement(driver, getDynamicXpath(locatorType, params)).getAttribute(attributeName);
	}

	protected String getElementText(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).getText();
	}

	protected String getElementText(WebDriver driver, String locatorType, String... params) {
		return getWebElement(driver, getDynamicXpath(locatorType, params)).getText();
	}

	protected String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {
		return getWebElement(driver, locatorType).getCssValue(propertyName);
	}

	protected String getHexaColorFormRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}

	protected int getElementSize(WebDriver driver, String locatorType) {
		return getListWebElement(driver, locatorType).size();
	}

	protected int getElementSize(WebDriver driver, String locatorType, String... params) {
		return getListWebElement(driver, getDynamicXpath(locatorType, params)).size();
	}

	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType, String... params) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, params));
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckbox(WebDriver driver, String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected void unCheckToDefaultCheckbox(WebDriver driver, String locatorType, String... params) {
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, params));
		if (element.isSelected()) {
			element.click();
		}
	}

	protected boolean isElementSelected(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isSelected();
	}

	protected boolean isElementSelected(WebDriver driver, String locatorType, String... params) {
		return getWebElement(driver, getDynamicXpath(locatorType, params)).isSelected();
	}

	protected boolean isElementEnabled(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isEnabled();
	}

	protected boolean isElementDisplayed(WebDriver driver, String locatorType) {
		return getWebElement(driver, locatorType).isDisplayed();
	}

	protected boolean isElementDisplayed(WebDriver driver, String locatorType, String... params) {
		return getWebElement(driver, getDynamicXpath(locatorType, params)).isDisplayed();
	}

	protected void overridenImplicitWait(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	protected boolean isElementUnDisplay(WebDriver driver, String locatorType) {
		overridenImplicitWait(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overridenImplicitWait(driver, longTimeout);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isElementUnDisplay(WebDriver driver, String locatorType, String... params) {
		overridenImplicitWait(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType, params));
		overridenImplicitWait(driver, longTimeout);
		if (elements.size() == 0) {
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	protected void switchToFrameIframe(WebDriver driver, String xpatLocator) {
		driver.switchTo().frame(getWebElement(driver, xpatLocator));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	protected void hoverMouseToElement(WebDriver driver, String locatorType, String... params) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType, params))).perform();
	}

	protected void sendKeyBoardToElement(WebDriver driver, String locatorType, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}

	protected void sendKeyBoardToElement(WebDriver driver, String locatorType, Keys key, String... params) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType, params)), key).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void highlightElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}

	protected void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}

	protected void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.jQuery != null)&&(jQuery.active===0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	protected String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	protected boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locatorType));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isImageLoaded(WebDriver driver, String locatorType, String... params) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, getDynamicXpath(locatorType, params)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	protected void waitForElementVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementVisible(WebDriver driver, String locatorType, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, params))));
	}

	protected void waitForAllElementsVisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	protected void waitForAllElementPresent(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	protected void waitForAllElementsVisible(WebDriver driver, String locatorType, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, params))));
	}

	protected void waitForElementInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	protected void waitForElementInvisible(WebDriver driver, String locatorType, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, params))));
	}

	protected void waitForElementUnDisplay(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overridenImplicitWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overridenImplicitWait(driver, longTimeout);
	}

	protected void waitForAllElementsInvisible(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	protected void waitForElementClickabled(WebDriver driver, String locatorType) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getWebElement(driver, locatorType)));
	}

	protected void waitForElementClickabled(WebDriver driver, String locatorType, String... params) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getWebElement(driver, getDynamicXpath(locatorType, params))));
	}

	// uplaod File
//	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
//		String filePath = GlobalConstants.UPLOAD_FILE_PATH;
//		String fullFileName = "";
//		for (String file : fileNames) {
//			fullFileName = fullFileName + filePath + file + "\n";
//		}
//		fullFileName = fullFileName.trim();
//		sendkeyToElement(driver, BasePageUINopCommerce.UPLOAD_FILE, fullFileName);
//	}

	public Set<Cookie> getCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Set<Cookie> cookies) {

		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}

	public UserHomePageObject clickOnLougoutLinkUserPage(WebDriver driver) {
		waitForElementVisible(driver, BasePageUINopCommerce.LOGOUT_LINK_USER);
		clickToElement(driver, BasePageUINopCommerce.LOGOUT_LINK_USER);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	/**
	 * input to textbox by id name
	 * 
	 * @param driver
	 * @param locatorType
	 * @param value
	 * @param id
	 */
	public void inputToTextboxByID(WebDriver driver, String id, String value) {
		waitForElementVisible(driver, BasePageUINopCommerce.TEXTBOX_BY_ID, id);
		sendkeyToElement(driver, BasePageUINopCommerce.TEXTBOX_BY_ID, value, id);
	}

	/**
	 * select value in default dropdown list by name
	 * 
	 * @param dropdown name
	 */
	public void selectValueInDropDownByName(WebDriver driver, String dropdownName, String value) {
		waitForElementVisible(driver, BasePageUINopCommerce.DROPDOWN_LIST_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(driver, BasePageUINopCommerce.DROPDOWN_LIST_BY_NAME, value, dropdownName);
	}

	/**
	 * click on button by name
	 * 
	 * @param button name
	 */
	public void clickOnButtonByName(WebDriver driver, String buttonName) {
		waitForElementClickabled(driver, BasePageUINopCommerce.BUTTON_BY_NAME, buttonName);
		clickToElement(driver, BasePageUINopCommerce.BUTTON_BY_NAME, buttonName);
	}

	/**
	 * get text value in textbox by id
	 * 
	 * @param id
	 */
	public String getTextInTextboxByID(WebDriver driver, String id, String attributeName) {
		waitForElementVisible(driver, BasePageUINopCommerce.TEXTBOX_BY_ID, id);
		return getElementAttribute(driver, BasePageUINopCommerce.TEXTBOX_BY_ID, attributeName, id);
	}

	/**
	 * get text value in dropdown by dropdown name
	 * 
	 * @param dropdown name
	 */
	public String getSelectedValueInDefaultDropdownListByName(WebDriver driver, String dropdownName) {
		waitForElementVisible(driver, BasePageUINopCommerce.DROPDOWN_LIST_BY_NAME, dropdownName);
		return getSelectedItemDefaultDropdown(driver, BasePageUINopCommerce.DROPDOWN_LIST_BY_NAME, dropdownName);
	}

	/**
	 * click on radion button by label name
	 * 
	 * @param label name
	 */
	public void clickOnRadioButtonByLabelName(WebDriver driver, String labelName) {
		waitForElementClickabled(driver, BasePageUINopCommerce.RADIO_BUTTON_BY_LABEL_NAME, labelName);
		clickToElement(driver, BasePageUINopCommerce.RADIO_BUTTON_BY_LABEL_NAME, labelName);
	}

	/**
	 * is radion button selected by label name
	 * 
	 * @param label name
	 */
	public boolean isRadioButtonByLabelNameSelected(WebDriver driver, String labelName) {
		waitForElementVisible(driver, BasePageUINopCommerce.RADIO_BUTTON_BY_LABEL_NAME, labelName);
		return isElementSelected(driver, BasePageUINopCommerce.RADIO_BUTTON_BY_LABEL_NAME, labelName);
	}

	/**
	 * create object of ListPageAtTopMenus
	 * 
	 * @param null
	 */
	public ListPageAtTopMenu getListPage(WebDriver driver) {
		return new ListPageAtTopMenu(driver);
	}
	
	/**
	 * create object of FooterListMenuPage
	 * 
	 * @param null
	 */
	public FooterListMenuPage getFooterListMenu(WebDriver driver) {
		return new FooterListMenuPage(driver);
	}
	
	public WishlistPageObject clickOnWishlistLink(WebDriver driver) {
		waitForElementVisible(driver, BasePageUINopCommerce.WISHLIST_LINK);
		clickToElement(driver, BasePageUINopCommerce.WISHLIST_LINK);
		return PageGeneratorManager.getWishlistPage(driver);
	}

	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;

	public int generatorNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	protected void sleepInSecond(long unit) {
		try {
			Thread.sleep(unit * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
