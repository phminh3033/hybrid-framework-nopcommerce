package browserFactory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EdgeDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        Map<String, Object> edgePrefs = new HashMap<String, Object>();
        edgePrefs.put("profile.default_content_setting_values.notifications", 2); // Tat luu address
        edgePrefs.put("credentials_enable_service", false);
        edgePrefs.put("profile.password_manager_enabled", false); // Tat luu password
        edgePrefs.put("autofill.profile_enabled", false); // Tat autofill suggestion
        edgePrefs.put("autofill.credit_card_enable", false); // Tat save CARD info

        // Download file KHONG hien download dialog khi bam nut down
        edgePrefs.put("profile.default_content_settings.popups", 0);
        edgePrefs.put("download.default_directory", GlobalConstants.DOWNLOAD_PATH);

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--lang=fr");
        edgeOptions.addArguments("--disable-notifications"); // tat thong bao
        edgeOptions.addArguments("--disable-geolocation"); // tat thong bao dinh vi vi tri
        edgeOptions.addArguments("--inprivate"); // Run on an danh mode

        // tat thong bao trinh duyet dang chay o auto mode
        edgeOptions.setExperimentalOption("useAutomationExtension", false);
        edgeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        edgeOptions.setExperimentalOption("prefs", edgePrefs); // Tat cac thong bao config o tren

        return new EdgeDriver(edgeOptions);
    }
}
