package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerPageUI;

public class CustomerPageObject extends BasePage {
    WebDriver driver;

    public CustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameTxtAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
    }

    public String getLastNameTxtAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
    }

    public String getEmailTxtAttributeValue() {
        waitForElementVisible(driver, CustomerPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, CustomerPageUI.EMAIL_TEXTBOX, "value");
    }
}
