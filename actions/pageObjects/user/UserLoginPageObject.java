package pageObjects.user;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.UserLoginPageUI;
import pojoData.nopcommerce.UserInfo;

public class UserLoginPageObject extends BaseElement {
    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToEmailTxt(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TXT);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_TXT, emailAddress);
    }

    public void enterToPasswordTxt(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TXT);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TXT, password);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementClickable(driver, UserLoginPageUI.LOGIN_BTN);
        clickToElement(driver, UserLoginPageUI.LOGIN_BTN);
        //return new HomePageObject(driver); // PageManager 2
        return PageGeneratorManager.getHomePage(driver); // PageManager 3
    }

    public HomePageObject loginToUser(String emailAddress, String password) {
        enterToEmailTxt(emailAddress);
        enterToPasswordTxt(password);
        return clickToLoginButton();
    }

    public HomePageObject loginToApplication(UserInfo userInfo) {
        enterToEmailTxt(userInfo.getEmailAddress());
        enterToPasswordTxt(userInfo.getPassword());
        return clickToLoginButton();
    }
}
