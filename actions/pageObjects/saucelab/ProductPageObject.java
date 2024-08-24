package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPageObject extends BasePage {
    WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectItemInSortDropdown(String sortItem) {
        waitForElementClickable(driver, ProductPageUI.SORT_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductPageUI.SORT_DROPDOWN, sortItem);
        sleepInSecond(2);
    }

    public boolean isProductNameSortByAscending() {
        /**B1: Luu data lai*/
        waitForListElementsVisible(driver, ProductPageUI.PRODUCT_NAME_TEXT);
        List<WebElement> productNameList = getListWebElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);

        List<String> actualProductName = new ArrayList<String>();
        for (WebElement productName : productNameList) {
            actualProductName.add(productName.getText());
        }

        /**B2: Clone data tu buoc 1 thanh du lieu moi*/
        List<String> expectedProductName = new ArrayList<String>(actualProductName);
        /*for (String name : actualProductName) {
            expectedProductName.add(name);
        }*/

        /**B3: Cho sort du lieu o buoc 2*/
        Collections.sort(expectedProductName);

        /**B4: Verify*/
        return actualProductName.equals(expectedProductName);
    }

    public boolean isProductNameSortByDescending() {
        /**B1: Luu data lai*/
        waitForListElementsVisible(driver, ProductPageUI.PRODUCT_NAME_TEXT);
        List<WebElement> productNameList = getListWebElements(driver, ProductPageUI.PRODUCT_NAME_TEXT);

        List<String> actualProductName = new ArrayList<String>();
        for (WebElement productName : productNameList) {
            actualProductName.add(productName.getText()); // DESC
        }

        /**B2: Clone data tu buoc 1 thanh du lieu moi*/
        List<String> expectedProductName = new ArrayList<String>(actualProductName);
        /*for (String name : actualProductName) {
            expectedProductName.add(name); // DESC
        }*/

        /**B3: Cho sort du lieu o buoc 2*/
        // Vi dang la DESC roi neu ma reverse thi ve ASC -> Nen can sort truoc r moi reverse
        Collections.sort(expectedProductName); // ASC
        Collections.reverse(expectedProductName); // DESC

        /**B4: Verify*/
        return actualProductName.equals(expectedProductName);
    }

    public boolean isProductPriceSortByAscending() {
        /**B1: Luu data lai*/
        waitForListElementsVisible(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
        List<WebElement> productPriceList = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

        List<Float> actualProductPrice = new ArrayList<Float>();
        for (WebElement productPrice : productPriceList) {
            actualProductPrice.add(Float.parseFloat(productPrice.getText().replace("$", "")));
        }

        /**B2: Clone data tu buoc 1 thanh du lieu moi*/
        List<Float> expectedProductPrice = new ArrayList<Float>(actualProductPrice);
        /*for (Float price : actualProductPrice) {
            expectedProductPrice.add(price);
        }*/

        /**B3: Cho sort du lieu o buoc 2*/
        Collections.sort(expectedProductPrice);

        /**B4: Verify*/
        return actualProductPrice.equals(expectedProductPrice);
    }

    public boolean isProductPriceSortByDescending() {
        /**B1: Luu data lai*/
        waitForListElementsVisible(driver, ProductPageUI.PRODUCT_PRICE_TEXT);
        List<WebElement> productPriceList = getListWebElements(driver, ProductPageUI.PRODUCT_PRICE_TEXT);

        List<Float> actualProductPrice = new ArrayList<Float>();
        for (WebElement productPrice : productPriceList) {
            actualProductPrice.add(Float.parseFloat(productPrice.getText().replace("$", "")));
        }

        /**B2: Clone data tu buoc 1 thanh du lieu moi*/
        List<Float> expectedProductPrice = new ArrayList<Float>(actualProductPrice);
        /*for (Float price : actualProductPrice) {
            expectedProductPrice.add(price);
        }*/

        /**B3: Cho sort du lieu o buoc 2*/
        Collections.sort(expectedProductPrice);
        Collections.reverse(expectedProductPrice);

        /**B4: Verify*/
        return actualProductPrice.equals(expectedProductPrice);
    }
}