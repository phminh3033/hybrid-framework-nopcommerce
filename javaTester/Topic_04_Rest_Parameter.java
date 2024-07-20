import org.testng.annotations.Test;

public class Topic_04_Rest_Parameter {
    String addressLink = "//div[@class='side-2']//a[text()='Addresses']";
    String customerLink = "//div[@class='side-2']//a[text()='Customer info']";
    String orderLink = "//div[@class='side-2']//a[text()='Orders']";

    String sidebarLink = "//div[@class='side-2']//a[text()='%s']";
    String dynamicLink = "//div[@class='%s']//a[text()='%s']";

    //td[@data-key='females' and text()="384187"]/following-sibling::td[@data-key='country' and text()="Afghanistan"]/following-sibling::td[@data-key='males' and text()="407124"]/following-sibling::td[@data-key='total' and text()="791312"]
    String dynamicCountry = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";

    @Test
    public void TC_01_Rest_Param() {
        clickToElement(addressLink);
        clickToElement(customerLink);
        clickToElement(orderLink);

        clickToElement(sidebarLink, "Addresses");
        clickToElement(sidebarLink, "Customer info");
        clickToElement(sidebarLink, "Orders");

        clickToElement(dynamicLink, "header", "Register");
        clickToElement(dynamicLink, "footer", "Addresses");
        clickToElement(dynamicLink, "footer", "Blog");

        clickToElement(dynamicCountry, "384187", "Afghanistan", "407124", "791312");
    }

    /*------------------------------------------Tính đa hình (Polymorphism)----------------------------------------------*/

    public void clickToElement(String pageLocator) {
        System.out.println("Click: " + pageLocator);
    }

    /*public void clickToElement(String pageLocator, String pageName) {
        pageLocator = String.format(pageLocator, pageName);
        System.out.println("Click: " + pageLocator);
    }

    public void clickToElement(String pageLocator, String pageType, String pageName) {
        pageLocator = String.format(pageLocator, pageType, pageName);
        System.out.println("Click: " + pageLocator);
    }

    public void clickToElement(String locatorvalue,String females, String country, String males, String total) {
        locatorvalue = String.format(locatorvalue, females, country, males, total);
        System.out.println("Click: " + locatorvalue);
    }*/

    // Var Arguments (ky thuat) = Rest Parameter (tinh nang)
    // Ham de click vao 1 element KHONG co dinh (dynamic) vmoi bat ki tham so nao
    public void clickToElement(String locatorValue, String... value){
        locatorValue = String.format(locatorValue, (Object[]) value);
        System.out.println("Click: " + locatorValue);
    }
}
