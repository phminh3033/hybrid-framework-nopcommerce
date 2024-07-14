package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
    }

    public String getFirstNameErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG);
    }

    public String getLastNameErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MSG);
    }

    public String getEmailErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MSG);
    }

    public String getConfirmPasswordErrorMsgText() {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
        return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MSG);
    }

    public void clickToNopCommerceLogo() {
        waitForElementClickable(driver, RegisterPageUI.NOPCOMMERCE_LOGO);
        clickToElement(driver, RegisterPageUI.NOPCOMMERCE_LOGO);
    }

    public void enterToFirstNameTxt(String firstName) {
        waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTxt(String lastName) {
        waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    public void enterToEmailTxt(String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordTxt(String password) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void enterToConfirmPasswordTxt(String confirmPassword) {
        waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public String getRegisterSuccessMsgTxt() {
        waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
        return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETED_MSG);
    }
}
