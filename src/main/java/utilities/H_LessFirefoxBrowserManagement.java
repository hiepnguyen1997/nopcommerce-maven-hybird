package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class H_LessFirefoxBrowserManagement implements BrowserFactory{

	@Override
	public WebDriver getWebDiver() {
		WebDriverManager.firefoxdriver().browserVersion("95").setup();
		FirefoxOptions option = new FirefoxOptions();
		option.addArguments("-headless");
		option.addArguments("window-size=1920x1080");
		return new FirefoxDriver(option);
	}

}
