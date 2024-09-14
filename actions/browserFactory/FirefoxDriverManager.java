package browserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        FirefoxOptions ffOptions = new FirefoxOptions();

        // config Download file KHONG hien download dialog khi bam nut down
        // Nhieu qua, luoi -> xem topic 106

        ffOptions.addPreference("intl.accept_languages", "vi-vn,vi");
        ffOptions.addArguments("--private"); // Run on an danh mode

        return new FirefoxDriver(ffOptions);
    }
}
