package pageObjects;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToEmailTxt(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TXT);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TXT, emailAddress);
    }

    public void enterToPasswordTxt(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
        //return new HomePageObject(driver); // PageManager 2
        return PageGeneratorManager.getHomePage(driver); // PageManager 3
    }
}
