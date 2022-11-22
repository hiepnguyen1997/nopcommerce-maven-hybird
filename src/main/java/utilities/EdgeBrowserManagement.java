package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.apache.commons.lang3.SystemUtils.IS_OS_WINDOWS;
import static org.apache.commons.lang3.SystemUtils.IS_OS_MAC;

public class EdgeBrowserManagement implements BrowserFactory{

	@Override
	public WebDriver getWebDiver() {
		if (!IS_OS_WINDOWS && !IS_OS_MAC) {
			throw new BrowserNotSupport("Edge browser is not supported on: " + System.getProperty("os.name"));
		}
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		return new EdgeDriver(options);
	}

}
