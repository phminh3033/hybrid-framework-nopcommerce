package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    /* Web Browser */
    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitForAlterPresent(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert (WebDriver driver) {
        //driver.switchTo().alert().accept();
        waitForAlterPresent(driver).accept();
    }

    public void cancelAlert (WebDriver driver) {
        //driver.switchTo().alert().dismiss();
        waitForAlterPresent(driver).dismiss();
    }

    public String getTextOfAlert (WebDriver driver) {
        //return driver.switchTo().alert().getText();
        return waitForAlterPresent(driver).getText();
    }

    public void sendKeyToAlert (WebDriver driver, String value) {
        //driver.switchTo().alert().sendKeys(value);
        waitForAlterPresent(driver).sendKeys(value);
    }
}
