package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.CustomerPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.UserLoginPageObject;
import pojoData.nopcommerce.UserInfo;
import reportConfig.ExtentTestManagerV5;

import java.lang.reflect.Method;


public class Level_27_Data_Internal_POJO extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private UserInfo userInfo;
    private UserLoginPageObject userLoginPage;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browserName = browserName;
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        userInfo = UserInfo.getUserInfo();
        userInfo.setFirstName("John");
        userInfo.setLastName("Quit");
        userInfo.setEmailAddress(getRandomEmail());
        userInfo.setPassword("123456");

    }

    @Test
    public void User_01_Register_Validate(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "User_01_Register_Validate");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 1: Verify Register link is displayed");
        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Verify error msg at First Name txt");
        Assert.assertEquals(registerPage.getFirstNameErrorMsgText(), "First name is required.");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Verify error msg at Last Name txt");
        Assert.assertEquals(registerPage.getLastNameErrorMsgText(), "Last name is required.");
    }

    @Test
    public void User_02_Register_Success(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "User_02_Register_Success");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 1: Click to Register link");
        registerPage = homePage.clickToRegisterLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Enter to register form");
        registerPage.setToRegisterForm(userInfo);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Verify success msg is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Log out");
        homePage = registerPage.clickToLogoutBtn();
    }

    @Test
    public void User_03_Login_Success(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "User_03_Login_Success");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 1: Click to Login link");
        userLoginPage = homePage.clickToLoginLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Login to application");
        homePage = userLoginPage.loginToApplication(userInfo);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Click to My account button");
        customerPage = homePage.clickToMyAccountLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Verify " + userInfo.getFirstName());
        Assert.assertEquals(customerPage.getFirstNameTxtAttributeValue(), userInfo.getFirstName());

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Verify " + userInfo.getLastName());
        Assert.assertEquals(customerPage.getLastNameTxtAttributeValue(), userInfo.getLastName());

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 6: Verify " + userInfo.getEmailAddress());
        Assert.assertEquals(customerPage.getEmailTxtAttributeValue(), userInfo.getEmailAddress());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
