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
import reportConfig.ExtentTestManagerV5;
import utilities.FakerConfig;

import java.lang.reflect.Method;


public class Level_23_Faker_Data extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private UserLoginPageObject userLoginPage;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CustomerPageObject customerPage;
    private FakerConfig dataFaker;

    private String firstName, lastName, password, emailAddress;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        this.browserName = browserName;
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        dataFaker = FakerConfig.getFaker();
        firstName = dataFaker.getFirstName();
        lastName = dataFaker.getLastName();
        password = dataFaker.getPassword();
        emailAddress = dataFaker.getEmail();
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

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 2: Enter to First Name txt is " + firstName);
        registerPage.enterToFirstNameTxt(firstName);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Enter to Last Name txt is " + lastName);
        registerPage.enterToLastNameTxt(lastName);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Enter to Email txt is " + emailAddress);
        registerPage.enterToEmailTxt(emailAddress);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Enter to Password txt is " + password);
        registerPage.enterToPasswordTxt(password);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 6: Enter to Confirm Password txt is " + password);
        registerPage.enterToConfirmPasswordTxt(password);

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

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 3: Enter to Password txt is " + password);
        userLoginPage.enterToPasswordTxt(password);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 4: Click to Login button");
        homePage = userLoginPage.clickToLoginButton();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 5: Click to My account button");
        customerPage = homePage.clickToMyAccountLink();

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 6: Verify " + firstName);
        Assert.assertEquals(customerPage.getFirstNameTxtAttributeValue(), firstName);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 7: Verify " + lastName);
        Assert.assertEquals(customerPage.getLastNameTxtAttributeValue(), lastName);

        ExtentTestManagerV5.getTest().log(Status.INFO, "Register - Step 8: Verify " + emailAddress);
        Assert.assertEquals(customerPage.getEmailTxtAttributeValue(), emailAddress);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
