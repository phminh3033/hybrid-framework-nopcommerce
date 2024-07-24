package commons;

import java.io.File;

public class GlobalConstants {
    /*
     * Server URL: Dev/Testing/Staging/Product
     * Database:
     * Timeout: Short/Long
     * Username/Pass
     * Thirt party: Sanbox Paypal
     * Download/Upload folder
     * Relative project path
     * OS Name
     * Could Testing Browserstack/Saucelab/CrossbrowserTesting (Access Token / ID)
     *
     * */

    public static final String DEV_USER_URL = "https://demo.nopcommerce.com";
    public static final String DEV_ADMIN_URL = "https://admin-demo.nopcommerce.com";
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;
    public static final String DEV_ADMIN_USERNAME = "admin@yourstore.com";
    public static final String DEV_ADMIN_PASS = "admin";
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String RELATIVE_PROJECT_PATH = System.getProperty("user.dir");
    public static final String UPLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_PATH = RELATIVE_PROJECT_PATH + File.separator + "downloadFiles" + File.separator;
    public static final String REPORT_IMG_PATH = RELATIVE_PROJECT_PATH + File.separator + "reportNGScreenshot" + File.separator;
}
