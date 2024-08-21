package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import staticVariable.UserObject;
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
import reportConfig.ExtentTestManagerV5;

import java.lang.reflect.Method;


public class Level_26_Data_In_Internal_Static extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private UserLoginPageObject userLoginPage;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;

    private String emailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browserName = browserName;
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        /**Dung khi data test qua nhieu*/
        emailAddress = getRandomEmail();
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

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Enter to First Name txt is " + UserObject.FIRST_NAME);
        registerPage.enterToFirstNameTxt(UserObject.FIRST_NAME);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Enter to Last Name txt is " + UserObject.LAST_NAME);
        registerPage.enterToLastNameTxt(UserObject.LAST_NAME);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Enter to Email txt is " + emailAddress);
        registerPage.enterToEmailTxt(emailAddress);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Enter to Password txt is " + UserObject.PASSWORD);
        registerPage.enterToPasswordTxt(UserObject.PASSWORD);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 6: Enter to Confirm Password txt is " + UserObject.PASSWORD);
        registerPage.enterToConfirmPasswordTxt(UserObject.PASSWORD);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 7: Click to Register button");
        registerPage.clickToRegisterButton();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 8: Verify success msg is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMsgTxt(), "Your registration completed");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 9: Log out");
        homePage = registerPage.clickToLogoutBtn();
    }

    @Test
    public void User_03_Login_Success(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "User_03_Login_Success");

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 1: Click to Login link");
        userLoginPage = homePage.clickToLoginLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Enter to Email txt is " + emailAddress);
        userLoginPage.enterToEmailTxt(emailAddress);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Enter to Password txt is " + UserObject.PASSWORD);
        userLoginPage.enterToPasswordTxt(UserObject.PASSWORD);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Click to Login button");
        homePage = userLoginPage.clickToLoginButton();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Click to My account button");
        customerPage = homePage.clickToMyAccountLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 6: Verify " + UserObject.FIRST_NAME);
        Assert.assertEquals(customerPage.getFirstNameTxtAttributeValue(), UserObject.FIRST_NAME);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 7: Verify " + UserObject.LAST_NAME);
        Assert.assertEquals(customerPage.getLastNameTxtAttributeValue(), UserObject.LAST_NAME);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 8: Verify " + emailAddress);
        Assert.assertEquals(customerPage.getEmailTxtAttributeValue(), emailAddress);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
