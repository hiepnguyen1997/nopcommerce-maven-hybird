package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireBrowserManagement implements BrowserFactory{

	@Override
	public WebDriver getWebDiver() {
		WebDriverManager.firefoxdriver().browserVersion("95").setup();
		FirefoxOptions options = new FirefoxOptions();
		options.setAcceptInsecureCerts(true);
		return new FirefoxDriver(options);
	}

}
