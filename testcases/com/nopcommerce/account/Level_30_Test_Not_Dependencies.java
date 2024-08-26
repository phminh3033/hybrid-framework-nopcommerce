package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.user.HomePageObject;
import pageObjects.user.SearchPageObject;


public class Level_30_Test_Not_Dependencies extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private SearchPageObject searchPage;

    @Parameters("browser")
    @BeforeMethod
    /** BeforeMethod chay cho tung testcase - AfterMethod dong browser lai */
    public void beforeMethod(String browserName) {
        driver = getBrowserDriver(browserName);
        homePage = PageGeneratorManager.getHomePage(driver);
        searchPage = homePage.clickToSearchLink();
    }

    @Test
    public void shouldBeSearchByEmptyData() {
        searchPage.enterToSearchTextbox("");
        searchPage.clickToSearchBtn();
    }

    @Test
    public void shouldBeSearchByProductNameNotExist() {
        searchPage.enterToSearchTextbox("Macbook Pro 2050");
        searchPage.clickToSearchBtn();
    }

    @Test
    public void shouldBeSearchByContainsProductName() {
        searchPage.enterToSearchTextbox("Lenovo");
        searchPage.clickToSearchBtn();
    }

    @Test
    public void shouldBeSearchByProductName() {
        searchPage.enterToSearchTextbox("HP Spectre XT Pro UltraBook");
        searchPage.clickToSearchBtn();
    }

    @AfterMethod
    public void afterMethod() {
        closingBrowser();
    }
}
