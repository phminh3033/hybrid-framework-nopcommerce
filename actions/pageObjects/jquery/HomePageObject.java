package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToColTextboxByName(String colName, String valueToSend) {
        waitForElementVisible(driver, HomePageUI.COL_TXT_BY_NAME, colName);
        sendKeyToElement(driver, HomePageUI.COL_TXT_BY_NAME, valueToSend, colName);
    }

    public void clickToPageNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
        clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
    }

    public boolean isPageActiveByNumber(String pageNumber) {
        waitForElementVisible(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
        return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
    }

    public boolean isRowValueDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total);
        return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total);
    }

    public void clickToRowActionByCountryName(String country, String rowAction) {
        waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
        clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, country, rowAction);
    }
}
