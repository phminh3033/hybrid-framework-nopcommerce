package com.jquery.table;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;


public class Level_13_Handle_DataTable extends BaseTest {
    WebDriver driver;
    HomePageObject homePage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
    }

    //@Test
    public void TC_01_Search() {
        // Search data tren header cua table
        homePage.enterToColTextboxByName("Females", "24128");
        homePage.enterToColTextboxByName("Total", "107000");
        homePage.enterToColTextboxByName("Males", "4490");
        homePage.enterToColTextboxByName("Country", "Western Europe");
    }

    //@Test
    public void TC_02_Paging() {
        homePage.clickToPageNumber("2");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("2"));

        homePage.clickToPageNumber("4");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("4"));

        homePage.clickToPageNumber("6");
        homePage.sleepInSecond(2);
        Assert.assertTrue(homePage.isPageActiveByNumber("6"));
    }

    @Test
    public void TC_03_Displayed() {
        // Verify for any row
        Assert.assertTrue(homePage.isRowValueDisplayed("338282", "Argentina", "349238", "687522"));

        /*
        Neu nam o page khac, co 2 cach:
        + click trang + verify
        + search + verify
        */
    }

    @Test
    public void TC_04_Click_Icon_Button_Checkbox() {
        // Click vao bat ky
        // Tim duoc data unit
        homePage.clickToRowActionByCountryName("Afghanistan", "remove");
        homePage.clickToRowActionByCountryName("AFRICA", "remove");
        homePage.clickToRowActionByCountryName("Albania", "remove");
        homePage.clickToRowActionByCountryName("Arab Rep of Egypt", "remove");
        homePage.clickToRowActionByCountryName("Aruba", "remove");
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("Afghanistan", "edit");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);

        homePage.clickToRowActionByCountryName("Albania", "edit");
        homePage.sleepInSecond(2);
        homePage.refreshCurrentPage(driver);
    }

    @Test
    public void TC_05_Action_By_Index() {

    }

    @Test
    public void TC_06_Get_All_Row_Value() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
