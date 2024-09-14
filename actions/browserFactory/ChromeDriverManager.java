package browserFactory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        Map<String, Object> chPrefs = new HashMap<String, Object>();
        chPrefs.put("profile.default_content_setting_values.notifications", 2); // Tat luu address
        chPrefs.put("credentials_enable_service", false);
        chPrefs.put("profile.password_manager_enabled", false); // Tat luu password
        chPrefs.put("autofill.profile_enabled", false); // Tat autofill suggestion
        chPrefs.put("autofill.credit_card_enable", false); // Tat save CARD info

        // Download file KHONG hien download dialog khi bam nut down
        chPrefs.put("profile.default_content_settings.popups", 0);
        chPrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);

        ChromeOptions chOptions = new ChromeOptions();

        chOptions.addArguments("--lang=fr");
        chOptions.addArguments("--disable-notifications"); // tat thong bao
        chOptions.addArguments("--disable-geolocation"); // tat thong bao dinh vi vi tri
        chOptions.addArguments("--incognito"); // Run on an danh mode

        // Run with Profile
        chOptions.addArguments("user-data-dir=C:\\Users\\minh.pham.h\\AppData\\Local\\Google\\Chrome\\User Data");
        chOptions.addArguments("profile-directory=Profile 6");

        // tat thong bao trinh duyet dang chay o auto mode
        chOptions.setExperimentalOption("useAutomationExtension", false);
        chOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        chOptions.setExperimentalOption("prefs", chPrefs); // Tat cac thong bao config o tren

        return new ChromeDriver(chOptions);
    }
}
