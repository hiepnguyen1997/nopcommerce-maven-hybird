package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class H_LessChromeBrowserManagement implements BrowserFactory{

	@Override
	public WebDriver getWebDiver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("headless");
		option.addArguments("window-size=1920x1080");
		return new ChromeDriver(option);
	}

}
