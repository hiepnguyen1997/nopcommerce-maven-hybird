package commons;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

import exception.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ChromeBrowserManagement;
import utilities.EdgeBrowserManagement;
import utilities.FireBrowserManagement;
import utilities.H_LessChromeBrowserManagement;
import utilities.H_LessFirefoxBrowserManagement;

public class BaseTest {
	private WebDriver driver;
	protected final Log log;
	private int longTime = 30;
	private int shortTime = 5;

//	@BeforeSuite
//	public void initBeforeSuite() {
//		deleteAllFileInFolder();
//	}

	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriverMananment(String browserName, String webURL) {
		BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
		switch (browser) {
		
		case CHROME:
			driver = new ChromeBrowserManagement().getWebDiver();
			break;
			
		case FIREFOX:
			driver = new FireBrowserManagement().getWebDiver();
			break;
			
		case EDGE:
			driver = new EdgeBrowserManagement().getWebDiver();
			break;
			
		case H_CHROME:
			driver = new H_LessChromeBrowserManagement().getWebDiver();
			break;
			
		case H_FIREFOX:
			driver = new H_LessFirefoxBrowserManagement().getWebDiver();
			break;

		default:
			throw new BrowserNotSupport(browserName);
		}
		driver.manage().timeouts().implicitlyWait(longTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(webURL);
		return driver;
	}

//	protected WebDriver getBrowserDriver(String browserName) throws BrowserNotSupport {
//		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
//		if (browserList == BrowserList.FIREFOX) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.setAcceptInsecureCerts(true);
//			driver = new FirefoxDriver(options);
//		} else if (browserList == BrowserList.H_FIREFOX) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions option = new FirefoxOptions();
//			option.addArguments("-headless");
//			option.addArguments("window-size=1920x1080");
//			driver = new FirefoxDriver(option);
//		} else if (browserList == BrowserList.CHROME) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			HashMap<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_settings.popups", 0);
//			prefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE_PATH);
//			// options.addArguments("--lang=en");
//			options.addArguments("--incognito");
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "true");
//			driver = new ChromeDriver(options);
//		} else if (browserList == BrowserList.H_CHROME) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions option = new ChromeOptions();
//			option.addArguments("headless");
//			option.addArguments("window-size=1920x1080");
//			driver = new ChromeDriver(option);
//		} else if (browserList == BrowserList.EDGE) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		} else {
//			throw new BrowserNotSupport(browserName);
//		}
//		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		return driver;
//	}
//
//	protected WebDriver getBrowserDriver(String browserName, String urlName) throws BrowserNotSupport {
//		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
//		if (browserList == BrowserList.FIREFOX) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions options = new FirefoxOptions();
//			options.setAcceptInsecureCerts(true);
//			driver = new FirefoxDriver(options);
//		} else if (browserList == BrowserList.H_FIREFOX) {
//			WebDriverManager.firefoxdriver().setup();
//			FirefoxOptions option = new FirefoxOptions();
//			option.addArguments("-headless");
//			option.addArguments("window-size=1920x1080");
//			driver = new FirefoxDriver(option);
//		} else if (browserList == BrowserList.CHROME) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
//			HashMap<String, Object> prefs = new HashMap<String, Object>();
//			prefs.put("profile.default_content_settings.popups", 0);
//			prefs.put("download.default_directory", GlobalConstants.DOWNLOAD_FILE_PATH);
//			options.addArguments("--incognito");
//			System.setProperty("webdriver.chrome.args", "--disable-logging");
//			System.setProperty("webdriver.chrome.silentOutput", "true");
//			driver = new ChromeDriver(options);
//		} else if (browserList == BrowserList.H_CHROME) {
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions option = new ChromeOptions();
//			option.addArguments("headless");
//			option.addArguments("window-size=1920x1080");
//			driver = new ChromeDriver(option);
//		} else if (browserList == BrowserList.EDGE) {
//			WebDriverManager.edgedriver().setup();
//			driver = new EdgeDriver();
//		} else {
//			throw new BrowserNotSupport(browserName);
//		}
//		driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//		driver.get(urlName);
//		return driver;
//	}
//
//
//	protected String getEnvironmentName(String environmentName) {
//		String url = "";
//		EnvironmentList environmentList = EnvironmentList.valueOf(environmentName.toUpperCase());
//		if (environmentList == EnvironmentList.STAGING) {
//			url = GlobalConstants.USER_PAGE_URL;
//		} else if (environmentList == EnvironmentList.DEV) {
//			url = GlobalConstants.ADMIN_PAGE_URL;
//		} else {
//			throw new RuntimeException("Environment name is invalid.");
//		}
//		return url;
//	}

	public WebDriver getDriverInstance() {
		return this.driver;
	}
	protected boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;

			// Add lỗi vào ReportNG
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertFalse(condition);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			log.info(" -------------------------- FAILED -------------------------- ");
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public void deleteAllFileInFolder() {
		try {
			String pathFolderDownloadAllure = GlobalConstants.PROJECT_PATH +"/allure-results";
			File file = new File(pathFolderDownloadAllure);
			File[] listOfFiles = file.listFiles();
			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					new File(listOfFiles[i].toString()).delete();
				}
			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected String getCurrentDay() {
		DateTime nowUTC = new DateTime();
		int day = nowUTC.getDayOfMonth();
		// if (day < 10) {
		// String dayValue = "0" + day;
		// return dayValue;
		// }
		return String.valueOf(day);
	}

	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		// if (month < 10) {
		// String monthValue = "0" + month;
		// return monthValue;
		// }
		return String.valueOf(month);
	}

	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getToday() {
		return getCurrentMonth() + "/" + getCurrentDay() + "/" + getCurrentYear();
	}

	public int generatorNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);
	}

	protected void delay(long unit) {
		try {
			Thread.sleep(unit * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
