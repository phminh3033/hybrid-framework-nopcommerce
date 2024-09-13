package factoryEnv;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SoucelabsFactory {
    private WebDriver driver;
    private String browserName;
    private String browserVer;
    private String osName;

    public SoucelabsFactory(String browserName, String browserVer, String osName) {
        this.browserName = browserName;
        this.browserVer = browserVer;
        this.osName = osName;
    }

    public WebDriver createDriver() {
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

        return driver;
    }
}
