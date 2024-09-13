package factoryEnv;

import commons.GlobalConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackFactory {
    private WebDriver driver;
    private String browserName;
    private String osName;
    private String osVer;

    public BrowserstackFactory(String browserName, String osName, String osVer) {
        this.browserName = browserName;
        this.osName = osName;
        this.osVer = osVer;
    }

    public WebDriver createDriver() {
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
        return driver;
    }
}
