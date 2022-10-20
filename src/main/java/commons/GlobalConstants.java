package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_PATH = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
	public static final String DOWNLOAD_FILE_PATH = PROJECT_PATH + File.separator + "downloadFile";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "reportNGScreenShots" + File.separator;
	public static final String EXTENT_V2_SCREENSHOT = PROJECT_PATH + File.separator + "extentV2" + File.separator;
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLog";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final long LONG_TIMEOUT = 30;
	public static final long SHORT_TIMEOUT = 5;
	public static final String JAVA_VERSION = System.getProperty("java.version");
	
}
