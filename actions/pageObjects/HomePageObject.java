package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    /*
        BasePage basePage = new BasePage(); // 2
    */

    WebDriver driver; // 1 & 3

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterLink() {
        /*
            // 1
            driver.findElement(By.xpath(HomePageUI.REGISTER_LINK)).click();

            // 2
            basePage.clickToElement(driver, HomePageUI.REGISTER_LINK);
        */

        // 3
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public void clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}
