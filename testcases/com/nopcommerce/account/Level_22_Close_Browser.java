package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;


public class Level_22_Close_Browser extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        registerPage.clickToBtnByText("Register");

        Assert.assertEquals(registerPage.getTxtErrorMsgByID("FirstName"), "First name is required..");
        Assert.assertEquals(registerPage.getTxtErrorMsgByID("LastName"), "Last name is required.");
    }

    @Test
    public void User_01_Register_Empty_data() {
    }

    @Test
    public void User_02_Register_Invalid_Email() {
    }

    @Test
    public void User_03_Register_Invalid_Pass() {
    }

    @Test
    public void User_04_Register_Incorrect_Confirm_Pass() {
    }

    @Test
    public void User_05_Register_Success() {
    }

    @Test
    public void User_06_Login_Success() {
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closingBrowser();
        //driver.quit();
    }
}