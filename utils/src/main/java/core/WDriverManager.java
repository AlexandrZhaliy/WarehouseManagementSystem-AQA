package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;

import static enums.EnvProperties.CONTAINER_ENGINE;
import static enums.EnvProperties.SELENOID_URL;



public class WDriverManager {
    public static boolean HOLD_BROWSER_OPEN = false;
    public static boolean CLEAR_COOKIES = true;
    public static final boolean CLEAR_REPORTS_DIR = true;


    public static void setupDriver() {

        if (Boolean.parseBoolean(CONTAINER_ENGINE.getName())) {
            Configuration.browser = "chrome";
            Configuration.reportsFolder = "builds/reports/tests";
            Configuration.timeout = 10000;
            Configuration.browserSize = "1920x1080";
            Configuration.remote = SELENOID_URL.getName();
            Configuration.fileDownload = FileDownloadMode.FOLDER;
            Configuration.proxyEnabled = false;
            ChromeOptions options = new ChromeOptions();
            options.setCapability("selenoid:options", new HashMap<String, Object>() {{
                /* How to add test badge */
                put("name", "Test badge...");
                put("args", new ArrayList<String>() {{
                    add("--no-sandbox");
                }});
                /* How to set session timeout */
                put("sessionTimeout", "15m");

                /* How to set timezone */
                put("env", new ArrayList<String>() {{
                    add("TZ=UTC");
                    add("LC_ALL=ru_RU.UTF-8");
                }});
                put("enableVNC", true);

                /* How to add "trash" button */
                put("labels", new HashMap<String, Object>() {{
                    put("manual", "true");
                }});
            }});
            Configuration.browserCapabilities = options;
        } else {
            WebDriverManager.chromedriver().setup();
            Configuration.browser = "chrome";
            Configuration.browserSize = "1920x1080";
            Configuration.holdBrowserOpen = HOLD_BROWSER_OPEN;
            Configuration.reportsFolder = "builds/reports/tests";
            Configuration.timeout = 10000;
            Configuration.headless = false;
            Configuration.fileDownload = FileDownloadMode.FOLDER;
            Configuration.proxyEnabled = false;
        }
    }

    public static void addListener() {
        WebDriverRunner.addListener(new CustomWebDriverEventListener());
    }

    public static void addListener(Boolean isEnabled) {
        if (isEnabled) {
            addListener();
        }

    }
}
