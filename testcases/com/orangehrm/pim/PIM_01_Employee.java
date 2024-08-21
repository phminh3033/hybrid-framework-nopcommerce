package com.orangehrm.pim;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangehrm.*;
import pojoData.orangeHRM.EmployeeInfo;
import reportConfig.ExtentTestManagerV5;

import java.lang.reflect.Method;

public class PIM_01_Employee extends BaseTest {
    private WebDriver driver;
    private String browserName;
    private EmployeeInfo employeeInfo;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        this.browserName = browserName;
        employeeInfo = EmployeeInfo.getEmployeeInfo();

        employeeInfo.setFirstName("Michael");
        employeeInfo.setLastName("Qwen");
        employeeInfo.setDriverLicense("DF456G45");
        employeeInfo.setLicenseExp("2025-11-06");
        employeeInfo.setNationality("Vietnamese");
        employeeInfo.setMaritalStatus("Married");
        employeeInfo.setDob("1999-05-21");
        employeeInfo.setGender("Male");

        /**firstName = "Michael";
         lastName = "Qwen";
         driverLicense = "DF456G45";
         licenseExp = "2025-11-06";
         nationality = "Vietnamese";
         maritalStatus = "Married";
         dob = "1999-05-21";
         gender = "Male";*/

        driver = getBrowserDriver(browserName, url);
        loginPage = PageGeneratorManager.getLoginPage(driver);

        loginPage.enterToUsernameTxt(GlobalConstants.ORANGE_HRM_ADMIN_USERNAME);
        loginPage.enterToPasswordTxt(GlobalConstants.ORANGE_HRM_ADMIN_PASSWORD);
        dashboardPage = loginPage.clickLoginBtn();
        employeeListPage = dashboardPage.openPIMModule();
    }

    @Test
    public void Employee_01_Add_New(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "Employee_01_Add_New");
        addEmployeePage = employeeListPage.clickToAddEmployeeBtn();

        addEmployeePage.enterToFirstnameTxt(employeeInfo.getFirstName());
        addEmployeePage.enterToLastnameTxt(employeeInfo.getLastName());
        employeeInfo.setEmployeeID(addEmployeePage.getEmployeeID());

        addEmployeePage.clickSaveBtn();

        Assert.assertTrue(addEmployeePage.isSuccessMsgDisplayed("Successfully Saved"));
        addEmployeePage.waitForSpinnerIconInvisible();

        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);

        Assert.assertTrue(personalDetailsPage.isPersonalDetailHeaderDisplayed());

        personalDetailsPage.waitForSpinnerIconInvisible();

        Assert.assertEquals(personalDetailsPage.getFirstnameValue(), employeeInfo.getFirstName());
        Assert.assertEquals(personalDetailsPage.getLastnameValue(), employeeInfo.getLastName());
        Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeInfo.getEmployeeID());

        employeeListPage = personalDetailsPage.clickToEmployeeListTab();
        employeeListPage.enterToEmployeeIDTxt(employeeInfo.getEmployeeID());
        employeeListPage.clickToSearchBtn();

        Assert.assertTrue(employeeListPage.isValueDisplayedAtColName("Id", "1", employeeInfo.getEmployeeID()));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColName("First (& Middle) Name", "1", employeeInfo.getFirstName()));
        Assert.assertTrue(employeeListPage.isValueDisplayedAtColName("Last Name", "1", employeeInfo.getLastName()));
    }

    @Test
    public void Employee_02_Personal_Details(Method method) {
        ExtentTestManagerV5.startTest(method.getName() + "- Run on " + browserName.toUpperCase(), "Employee_02_Personal_Details");
        personalDetailsPage = employeeListPage.clickToEditIconByEmployeeID(employeeInfo.getEmployeeID());
        Assert.assertTrue(personalDetailsPage.isPersonalDetailHeaderDisplayed());

        Assert.assertEquals(personalDetailsPage.getFirstnameValue(), employeeInfo.getFirstName());
        Assert.assertEquals(personalDetailsPage.getLastnameValue(), employeeInfo.getLastName());
        Assert.assertEquals(personalDetailsPage.getEmployeeIDValue(), employeeInfo.getEmployeeID());

        personalDetailsPage.setPersonalDetail(employeeInfo);

        /**personalDetailsPage.enterToDriverLicenseNumTxt(employeeInfo.getDriverLicense());
        personalDetailsPage.enterToLicenseExpiryDatePicker(employeeInfo.getLicenseExp());
        personalDetailsPage.selectToNationalityDropdown(employeeInfo.getNationality());
        personalDetailsPage.selectToMaritalStatusDropdown(employeeInfo.getMaritalStatus());
        personalDetailsPage.enterToDoBDatePicker(employeeInfo.getDob());
        personalDetailsPage.selectToRadioBtnByLabelName(employeeInfo.getGender());
        personalDetailsPage.clickToSaveBtnAtPersonalDetailsPart();*/

        Assert.assertTrue(addEmployeePage.isSuccessMsgDisplayed("Successfully Updated"));
        addEmployeePage.waitForSpinnerIconInvisible();

        Assert.assertEquals(personalDetailsPage.getDriverLicenseValue(), employeeInfo.getDriverLicense());
        Assert.assertEquals(personalDetailsPage.getLicenseExpValue(), employeeInfo.getLicenseExp());
        Assert.assertEquals(personalDetailsPage.getDoBValue(), employeeInfo.getDob());
        Assert.assertEquals(personalDetailsPage.getNationalityDropdownSelectedText(), employeeInfo.getNationality());
        Assert.assertEquals(personalDetailsPage.getMaritalStatusDropdownSelectedText(), employeeInfo.getMaritalStatus());
        Assert.assertTrue(personalDetailsPage.isRadioBtnSelectedByLabelName(employeeInfo.getGender()));
    }

    @AfterClass
    public void afterClass() {
        closingBrowser();
    }
}