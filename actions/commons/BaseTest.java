package commons;

/*import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    protected final Logger log;

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
            default:
                throw new RuntimeException("Browser name is not valid");
        }

        //driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.get("https://demo.nopcommerce.com/");

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

    //protected  Void closingBrowser (){}

    protected String getRandomEmail() {
        Random random = new Random();
        return "auto" + random.nextInt(999) + "@gmail.net";
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
