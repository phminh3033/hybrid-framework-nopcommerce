package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTxt(String emailAddress) {
        sendKeyToElement(driver, LoginPageUI.EMAIL_TXT, emailAddress);
    }

    public void enterToPasswordTxt(String password) {
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver,LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
    }
}
