package pageObjects.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.MyAccountSideBarPageUI;

public class MyAccountSideBarPageObject extends BasePage {
    WebDriver driver;

    public MyAccountSideBarPageObject(WebDriver driver) {
        this.driver = driver;
    }

    /*------------------------------------------Pages----------------------------------------------*/

    public CustomerPageObject openCustomerPage() {
        waitForElementVisible(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.CUSTOMER_LINK_TEXT);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public AddressPageObject openAddressPage() {
        waitForElementVisible(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ADDRESS_LINK_TEXT);
        return PageGeneratorManager.getAddressPage(driver);
    }

    public OrdersPageObject openOrdersPage() {
        waitForElementVisible(driver, MyAccountSideBarPageUI.ORDERS_LINK_TEXT);
        clickToElement(driver, MyAccountSideBarPageUI.ORDERS_LINK_TEXT);
        return PageGeneratorManager.getOrdersPage(driver);
    }
}
