package com.facebook.home;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;
import reportConfig.ExtentTestManagerV5;
import utilities.EnvConfig;

import java.lang.reflect.Method;

public class Level_34_Apply_All extends BaseTest {
    private WebDriver driver;
    EnvConfig envConfig;
    HomePageObject homePage;
    private String browserName, osName;

    @Parameters({"envName", "server", "browser", "browserVer", "osName", "osVer", "ipAddress", "portNumber"})
    @BeforeClass
    public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("latest") String browserVer, @Optional("windows") String osName, @Optional("10") String osVer, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber) {
        this.browserName = browserName;
        this.osName = osName;
        ConfigFactory.setProperty("server", serverName);
        envConfig = ConfigFactory.create(EnvConfig.class);

        driver = getBrowserDriver(envName, envConfig.appUrl(), browserName, browserVer, osName, osVer, ipAddress, portNumber);
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