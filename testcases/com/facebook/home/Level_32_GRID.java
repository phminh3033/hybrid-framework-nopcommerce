package com.facebook.home;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;
import reportConfig.ExtentTestManagerV5;
import utilities.EnvConfig;

import java.lang.reflect.Method;

public class Level_32_GRID extends BaseTest {
    private WebDriver driver;
    HomePageObject homePage;
    EnvConfig envConfig;
    private String browserName, osName;

    @Parameters({"server", "browser", "url", "osName", "ipAddress", "port"})
    @BeforeClass
    public void beforeClass(String serverName, String browserName, String url, String osName, String ipAddress, String portNumber) {
        ConfigFactory.setProperty("server", serverName);
        envConfig = ConfigFactory.create(EnvConfig.class);
        this.browserName = browserName;
        this.osName = osName;
        System.out.println(envConfig.appUrl());

        driver = getBrowserDriver(browserName, url, osName, ipAddress, portNumber);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    @Test
    public void Home_01_Element_Displayed(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase() + " - " + osName, "Home_01_Element_Displayed");
        homePage.clickToCreateAccountBtn();

        verifyTrue(homePage.isFirstNameTxtDisplayed());
        verifyTrue(homePage.isSurNameTxtDisplayed());
        verifyTrue(homePage.isEmailTxtDisplayed());
        verifyTrue(homePage.isPassTxtDisplayed());

        homePage.enterToEmailTxt(getRandomEmail());
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