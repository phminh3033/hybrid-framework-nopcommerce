package com.facebook.home;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;
import reportConfig.ExtentTestManagerV5;

import java.lang.reflect.Method;

public class Level_33_CLOUD_SauceLabs extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    private String browserName, osName;

    @Parameters({"browser", "browserVer", "url", "osName"})
    @BeforeClass
    public void beforeClass(String browserName, String browserVer, String url, String osName) {
        this.browserName = browserName;
        this.osName = osName;

        driver = getBrowserDriverSauceLabs(browserName, browserVer, url, osName);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Home_01_Element_Displayed(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase() + " - " + osName, "Home_01_Element_Displayed");
        /*homePage.clickToCreateAccountBtn();

        verifyTrue(homePage.isFirstNameTxtDisplayed());
        verifyTrue(homePage.isSurNameTxtDisplayed());
        verifyTrue(homePage.isEmailTxtDisplayed());
        verifyTrue(homePage.isPassTxtDisplayed());

        homePage.enterToEmailTxt(getRandomEmail());*/
    }

    @Test
    public void User_01_Register_Validate(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase() + " - " + osName, "User_01_Register_Validate");
    }

    @Test
    public void User_02_Register_Success(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase() + " - " + osName, "User_02_Register_Success");
    }

    @Test
    public void User_03_Login_Success(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase() + " - " + osName, "User_03_Login_Success");
    }

    @AfterClass
    public void afterClass() {
        closingBrowser();
    }
}