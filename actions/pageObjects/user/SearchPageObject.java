package pageObjects.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.user.SearchPageUI;

public class SearchPageObject extends BasePage {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToSearchTextbox(String value) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TXT);
        sendKeyToElement(driver, SearchPageUI.SEARCH_TXT, value);
    }

    public void clickToSearchBtn() {
        waitForElementClickable(driver, SearchPageUI.SEARCH_BTN);
        clickToElement(driver, SearchPageUI.SEARCH_BTN);
    }
}
