package utilities;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowserManagement implements BrowserFactory{

	@Override
	public WebDriver getWebDiver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE_PATH);
		options.addArguments("--incognito");
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		return new ChromeDriver(options);
	}

}
