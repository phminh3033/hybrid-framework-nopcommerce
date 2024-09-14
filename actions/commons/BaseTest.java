package commons;

/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/

import browserFactory.BrowserList;
import factoryEnv.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    private Platform platform;
    protected final Logger log;

    public WebDriver getDriver() {
        return driver;
    }

    public BaseTest() {
        //log = LogManager.getLogger(BaseTest.class);
        log = LogManager.getLogger(getClass()); // goi chinh CLASS BaseTest
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        /*
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

        /* Enum
        if (browser == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME) {
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

    /*
        // Selenium 3.x
        switch (browser) {
            case FIREFOX:
                String projectPath = System.getProperty("user.dir");
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

    /*
        // WebDriverManager - Selenium 3.x
        switch (browser) {
            case FIREFOX:
                // WebDriverManager 4.x/5.x (cung dung duoc): Download driver + setting bien moi truong
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

                // WebDriverManager 5.x: Download driver + setting bien moi truong + Khoi tao browser
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            case FIREFOX_HEADLESS:
                FirefoxOptions ffHeadlessOptions = new FirefoxOptions();
                ffHeadlessOptions.addArguments("--headless");
                ffHeadlessOptions.addArguments("window-size=1360x768");
                driver = new FirefoxDriver(ffHeadlessOptions);
                break;
            case CHROME_HEADLESS:
                ChromeOptions chHeadlessOptions = new ChromeOptions();
                chHeadlessOptions.addArguments("--headless");
                chHeadlessOptions.addArguments("window-size=1360x768");
                driver = new ChromeDriver(chHeadlessOptions);
                break;
            case EDGE_HEADLESS:
                EdgeOptions edgeHeadlessOptions = new EdgeOptions();
                edgeHeadlessOptions.addArguments("--headless");
                edgeHeadlessOptions.addArguments("window-size=1360x768");
                driver = new EdgeDriver(edgeHeadlessOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        //driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get("http://demo.nopcommerce.local");

        return driver;
    }

    protected WebDriver getBrowserDriver(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        /*
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

        /* Enum
        if (browser == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME) {
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

    /*
        // Selenium 3.x
        switch (browser) {
            case FIREFOX:
                String projectPath = System.getProperty("user.dir");
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

    /*
        // WebDriverManager - Selenium 3.x
        switch (browser) {
            case FIREFOX:
                // WebDriverManager 4.x/5.x (cung dung duoc): Download driver + setting bien moi truong
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

                // WebDriverManager 5.x: Download driver + setting bien moi truong + Khoi tao browser
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        //driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);

        return driver;
    }

    protected WebDriver getBrowserEnv(String browserName, String serverName) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        //driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        System.out.println(getUrlBySeverName(serverName));
        driver.get(getUrlBySeverName(serverName));

        return driver;
    }

    protected WebDriver getBrowserDriverCapabilities(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());

        /*
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

        /* Enum
        if (browser == BrowserList.FIREFOX) {
            driver = new FirefoxDriver();
        } else if (browser == BrowserList.CHROME) {
            driver = new ChromeDriver();
        } else if (browser == BrowserList.EDGE) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        */

    /*
        // Selenium 3.x
        switch (browser) {
            case FIREFOX:
                String projectPath = System.getProperty("user.dir");
                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

    /*
        // WebDriverManager - Selenium 3.x
        switch (browser) {
            case FIREFOX:
                // WebDriverManager 4.x/5.x (cung dung duoc): Download driver + setting bien moi truong
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

                // WebDriverManager 5.x: Download driver + setting bien moi truong + Khoi tao browser
                driver = WebDriverManager.firefoxdriver().create();
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }
    */

        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX:
                FirefoxOptions ffOptions = new FirefoxOptions();

                // config Download file KHONG hien download dialog khi bam nut down
                // Nhieu qua, luoi -> xem topic 106

                ffOptions.addPreference("intl.accept_languages", "vi-vn,vi");
                ffOptions.addArguments("--private"); // Run on an danh mode

                driver = new FirefoxDriver(ffOptions);
                break;
            case CHROME:
                Map<String, Object> chPrefs = new HashMap<String, Object>();
                chPrefs.put("profile.default_content_setting_values.notifications", 2); // Tat luu address
                chPrefs.put("credentials_enable_service", false);
                chPrefs.put("profile.password_manager_enabled", false); // Tat luu password
                chPrefs.put("autofill.profile_enabled", false); // Tat autofill suggestion
                chPrefs.put("autofill.credit_card_enable", false); // Tat save CARD info

                // Download file KHONG hien download dialog khi bam nut down
                chPrefs.put("profile.default_content_settings.popups", 0);
                chPrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);

                ChromeOptions chOptions = new ChromeOptions();

                chOptions.addArguments("--lang=fr");
                chOptions.addArguments("--disable-notifications"); // tat thong bao
                chOptions.addArguments("--disable-geolocation"); // tat thong bao dinh vi vi tri
                //chOptions.addArguments("--incognito"); // Run on an danh mode

                // Run with Profile
                chOptions.addArguments("user-data-dir=C:\\Users\\minh.pham.h\\AppData\\Local\\Google\\Chrome\\User Data");
                chOptions.addArguments("profile-directory=Profile 6");

                // tat thong bao trinh duyet dang chay o auto mode
                chOptions.setExperimentalOption("useAutomationExtension", false);
                chOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

                chOptions.setExperimentalOption("prefs", chPrefs); // Tat cac thong bao config o tren

                driver = new ChromeDriver(chOptions);
                break;
            case EDGE:
                Map<String, Object> edgePrefs = new HashMap<String, Object>();
                edgePrefs.put("profile.default_content_setting_values.notifications", 2); // Tat luu address
                edgePrefs.put("credentials_enable_service", false);
                edgePrefs.put("profile.password_manager_enabled", false); // Tat luu password
                edgePrefs.put("autofill.profile_enabled", false); // Tat autofill suggestion
                edgePrefs.put("autofill.credit_card_enable", false); // Tat save CARD info

                // Download file KHONG hien download dialog khi bam nut down
                edgePrefs.put("profile.default_content_settings.popups", 0);
                edgePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);

                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--lang=fr");
                edgeOptions.addArguments("--disable-notifications"); // tat thong bao
                edgeOptions.addArguments("--disable-geolocation"); // tat thong bao dinh vi vi tri
                edgeOptions.addArguments("--inprivate"); // Run on an danh mode

                // tat thong bao trinh duyet dang chay o auto mode
                edgeOptions.setExperimentalOption("useAutomationExtension", false);
                edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

                edgeOptions.setExperimentalOption("prefs", edgePrefs); // Tat cac thong bao config o tren

                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        //driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);

        return driver;
    }

    protected WebDriver getBrowserDriverWithExtensions(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        Path path = null;
        File extensionFilePath = null;
        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX_EXTENSION:
                // options 1: selenium v3
                /*FirefoxProfile profile = new FirefoxProfile();
                File ffFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer-6.10.70.xpi");
                profile.addExtension(ffFile);
                FirefoxOptions ffOptions = new FirefoxOptions();
                ffOptions.setProfile(profile);
                driver = new FirefoxDriver(ffOptions);*/

                // options 2: selenium v4
                driver = new FirefoxDriver();
                Path xpiPath = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer-6.10.70.xpi");
                FirefoxDriver ffDriver = (FirefoxDriver) driver;
                ffDriver.installExtension(xpiPath);
                driver = ffDriver;

                break;
            case CHROME_EXTENSION:
                // options 1: selenium v3
                /*File chromeFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
                ChromeOptions chOptions = new ChromeOptions();
                chOptions.addExtensions(chromeFile);
                driver = new ChromeDriver(chOptions);*/

                // options 2: selenium v4
                ChromeOptions chOptions = new ChromeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                chOptions.addExtensions(extensionFilePath);
                driver = new ChromeDriver(chOptions);
                break;
            case EDGE_EXTENSION:
                // options 1: selenium v3
                /*File edgeFile = new File(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addExtensions(edgeFile);
                driver = new EdgeDriver(edgeOptions);*/

                // options 2: selenium v4
                EdgeOptions edgeOptions = new EdgeOptions();
                path = Paths.get(GlobalConstants.BROWSER_EXTENSIONS + "wappalyzer.crx");
                extensionFilePath = new File(path.toUri());
                edgeOptions.addExtensions(extensionFilePath);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        //driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);

        return driver;
    }

    protected WebDriver getBrowserDriverWithLogs(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        // SeleniumManager - Selenium 4.x (tu 4.6.x tro len)
        switch (browser) {
            case FIREFOX:
                // Log to file
                //FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOGS + "FirefoxDriver.log")).build();

                // Log to Console
                //FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogOutput(System.out).build();

                // Log to Level
                System.setProperty(GeckoDriverService.GECKO_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOGS + "FirefoxLevel.log");
                FirefoxDriverService ffService = new GeckoDriverService.Builder().withLogLevel(FirefoxDriverLogLevel.DEBUG).build();

                driver = new FirefoxDriver(ffService);
                break;
            case CHROME:
                // Log to file
                //ChromeDriverService chService = new ChromeDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOGS + "ChromeDriver.log")).build();

                // Log to Console
                //ChromeDriverService chService = new ChromeDriverService.Builder().withLogOutput(System.out).build();

                // Log to Level
                System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOGS + "ChromeLevel.log");
                ChromeDriverService chService = new ChromeDriverService.Builder().withLogLevel(ChromiumDriverLogLevel.DEBUG).build();

                driver = new ChromeDriver(chService);
                break;
            case EDGE:
                // Log to file
                //EdgeDriverService edgeService = new EdgeDriverService.Builder().withLogFile(new File(GlobalConstants.BROWSER_LOGS + "EdgeDriver.log")).build();

                // Log to Console
                //EdgeDriverService edgeService = new EdgeDriverService.Builder().withLogOutput(System.out).build();

                // Log to Level
                System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, GlobalConstants.BROWSER_LOGS + "EdgeLevel.log");
                EdgeDriverService edgeService = new EdgeDriverService.Builder().withLoglevel(ChromiumDriverLogLevel.DEBUG).build();

                driver = new EdgeDriver(edgeService);
                break;
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        //driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get(url);

        return driver;
    }

    /**
     * Run with Selenium GRID
     */
    protected WebDriver getBrowserDriverGRID(String browserName, String url, String osName, String ipAddress, String portNumber) {
        if (osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else if (osName.toLowerCase().contains("mac")) {
            platform = Platform.MAC;
        } else {
            platform = Platform.LINUX;
        }

        /** Selenium 4*/
        Capabilities capability = null;
        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = edgeOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    /**
     * Run with CLOUD
     */

    /*================BrowserStack================*/
    protected WebDriver getBrowserDriverBrowserStack(String browserName, String url, String osName, String osVer) {
        MutableCapabilities capabilities = new MutableCapabilities();
        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        capabilities.setCapability("browserName", browserName);
        bstackOptions.put("os", osName);
        bstackOptions.put("osVersion", osVer);
        bstackOptions.put("browserVersion", "latest");
        /*bstackOptions.put("userName", "minhpham_CVw30P");
        bstackOptions.put("accessKey", "Y6enyZBKLZqDpAK63svF");
        bstackOptions.put("consoleLogs", "info");*/
        bstackOptions.put("sessionName", "Run on " + osName + " " + osVer + " with " + browserName);
        bstackOptions.put("projectName", "AutoTestFacebookCloud");
        bstackOptions.put("debug", "true");
        capabilities.setCapability("bstack:options", bstackOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BROWSERSTACK_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    /*================SauceLabs================*/
    protected WebDriver getBrowserDriverSauceLabs(String browserName, String browserVer, String url, String osName) {
        MutableCapabilities capabilities = null;

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setPlatformName(osName);
                fOptions.setBrowserVersion(browserVer);
                fOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
                capabilities = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setPlatformName(osName);
                cOptions.setBrowserVersion(browserVer);
                cOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
                capabilities = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setPlatformName(osName);
                eOptions.setBrowserVersion(browserVer);
                eOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
                capabilities = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setPlatformName(osName);
                sOptions.setBrowserVersion(browserVer);
                sOptions.setImplicitWaitTimeout(Duration.ofSeconds(5));
                capabilities = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", GlobalConstants.SAUCELABS_USERNAME);
        sauceOptions.put("accessKey", GlobalConstants.SAUCELABS_ACCESS_KEY);
        sauceOptions.put("build", "auto-course-build");
        sauceOptions.put("name", "Run on " + osName + " with " + browserName + " " + browserVer);
        capabilities.setCapability("sauce:options", sauceOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCELABS_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    /*================BitBar SmartBear================*/
    protected WebDriver getBrowserDriverBitBar(String browserName, String url, String osName, String osVer) {
        MutableCapabilities capabilities = new MutableCapabilities();
        capabilities.setCapability("platformName", osName);
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", "latest");

        HashMap<String, String> bitbarOptions = new HashMap<String, String>();
        bitbarOptions.put("project", "Auto Course Facebook");
        bitbarOptions.put("testrun", "Run on " + osName + " " + osVer + " with " + browserName);
        bitbarOptions.put("apiKey", GlobalConstants.BITBAR_ACCESS_KEY);
        bitbarOptions.put("osVersion", osVer);
        bitbarOptions.put("resolution", "1920x1080");
        bitbarOptions.put("seleniumVersion", "4");
        capabilities.setCapability("bitbar:options", bitbarOptions);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.BITBAR_URL), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    /*================Config all================*/
    protected WebDriver getBrowserDriver(String envName, String url, String browserName, String browserVer, String osName, String osVer, String ipAddress, String portNumber) {
        switch (envName) {
            case "local":
                driver = new LocalFactory(browserName).createDriver();
                break;
            case "grid":
                driver = new GridFactory(browserName, osName, ipAddress, portNumber).createDriver();
                break;
            case "browserstack":
                driver = new BrowserstackFactory(browserName, osName, osVer).createDriver();
                break;
            case "saucelabs":
                driver = new SoucelabsFactory(browserName, browserVer, osName).createDriver();
                break;
            case "bitbar":
                driver = new BitBarFactory(browserName, osName, osVer).createDriver();
                break;
            default:
                throw new RuntimeException("Environment name is not valid!"); // throw: dung de bat loi
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    /**
     * =========================================================================
     */

    protected void closingBrowser() {
        String cmd = null;
        try {
            String osName = GlobalConstants.OS_NAME.toLowerCase();
            log.info("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            log.info("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI 'IMAGENAME eq " + browserDriverName + "*'";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            log.info("Command line: " + cmd);

            // 1 - Close browser
            if (driver != null) {
                driver.manage().deleteAllCookies(); // IE khi close browser r nhung van luu cookies
                driver.quit();
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        } finally { // finally: Luon dc chay cho du vao try hay catch
            // 2 - Quit driver (executable)
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

    protected String getRandomEmail() {
        Random random = new Random();
        return "auto" + random.nextInt(999) + "@gmail.net";
    }

    protected String getRandomEmail(String prefix) {
        Random random = new Random();
        return prefix + random.nextInt(999) + "@gmail.net";
    }

    private String getUrlBySeverName(String serverName) {
        ServerList server = ServerList.valueOf(serverName.toUpperCase());
        switch (server) {
            case DEV:
                serverName = "http://demo.nopcommerce.local";
                break;
            case TEST:
                serverName = "http://test.nopcommerce.local";
                break;
            case STAGING:
                serverName = "http://staging.nopcommerce.local";
                break;
            default:
                throw new IllegalArgumentException("Server name is not valid: " + serverName);
        }
        return serverName;
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
            log.info("-----------------PASSED-----------------");
        } catch (Throwable e) {
            log.info("-----------------FAILED-----------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
            log.info("-----------------PASSED-----------------");
        } catch (Throwable e) {
            log.info("-----------------FAILED-----------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e); // Add vao TestNG
            Reporter.getCurrentTestResult().setThrowable(e); // Add vao ReportNG
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("-----------------PASSED-----------------");
        } catch (Throwable e) {
            log.info("-----------------FAILED-----------------");
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }


    /*------------------------------------------Delete report img screenshot----------------------------------------------*/
    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGScreenshot");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-json");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        System.out.println(listOfFiles[i].isFile());
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
