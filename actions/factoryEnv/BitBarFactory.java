package factoryEnv;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BitBarFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String osVer;

    public BitBarFactory(String browserName, String osName, String osVer) {
        this.browserName = browserName;
        this.osName = osName;
        this.osVer = osVer;
    }

    public WebDriver createDriver() {
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

        return driver;
    }
}
