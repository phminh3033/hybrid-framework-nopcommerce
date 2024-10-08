package com.nopcommerce.account;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_31_Multiple_Env_02 extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
    }

    @Test
    public void User_01_Register_Validate() {
    }

    @Test
    public void User_02_Register_Success() {
    }

    @Test
    public void User_03_Login_Success() {
    }

    @AfterClass
    public void afterClass() {
        //closingBrowser();
    }
}
