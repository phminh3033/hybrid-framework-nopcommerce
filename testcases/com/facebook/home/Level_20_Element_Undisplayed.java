package com.facebook.home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;


public class Level_20_Element_Undisplayed extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Home_01_Element_Displayed() {
        homePage.clickToCreateAccountBtn();

        verifyTrue(homePage.isFirstNameTxtDisplayed());
        verifyTrue(homePage.isSurNameTxtDisplayed());
        verifyTrue(homePage.isEmailTxtDisplayed());
        verifyTrue(homePage.isPassTxtDisplayed());

        homePage.enterToEmailTxt(getRandomEmail());

        log.info("Verify Confirm Email txt is displayed");
        verifyTrue(homePage.isConfirmEmailTxtDisplayed());
    }

    @Test(enabled = false)
    public void Home_02_Element_Undisplayed_In_HTML() {
        homePage.enterToEmailTxt("");
        homePage.sleepInSecond(2);

        // Element van co trong HTML
        log.info("Verify Confirm Email txt is not displayed");
        verifyFalse(homePage.isConfirmEmailTxtDisplayed());
        verifyTrue(homePage.isConfirmEmailTxtUnDisplayed());
    }

    @Test(enabled = false)
    public void Home_03_Element_Undisplayed_NOT_In_HTML_01() {
        homePage.clickToCloseSignUpPopup();

        log.info("Verify Firstname txt is not displayed");
        verifyFalse(homePage.isFirstNameTxtDisplayed());

        log.info("Verify Surname txt is not displayed");
        verifyFalse(homePage.isSurNameTxtDisplayed());

        log.info("Verify Email txt is not displayed");
        verifyFalse(homePage.isEmailTxtDisplayed());

        log.info("Verify Pass txt is not displayed");
        verifyFalse(homePage.isPassTxtDisplayed());
    }

    @Test(enabled = false)
    public void Home_03_Element_Undisplayed_NOT_In_HTML_02() {
        log.info("Verify Firstname txt is not displayed");
        verifyTrue(homePage.isFirstNameTxtUnDisplayed());

        log.info("Verify Surname txt is not displayed");
        verifyTrue(homePage.isSurNameTxtUnDisplayed());

        log.info("Verify Email txt is not displayed");
        verifyTrue(homePage.isEmailTxtUnDisplayed());

        log.info("Verify Pass txt is not displayed");
        verifyTrue(homePage.isPassTxtUnDisplayed());
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }
}
