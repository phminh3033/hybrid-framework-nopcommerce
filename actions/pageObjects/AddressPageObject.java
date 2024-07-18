package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AddressPageObject extends BasePage {
    WebDriver driver;

    public AddressPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
