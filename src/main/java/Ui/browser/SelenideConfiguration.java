package Ui.browser;

import com.codeborne.selenide.Configuration;
import utils.PropertyReader;

import static com.codeborne.selenide.Browsers.*;

public class SelenideConfiguration {




    public static void configureBrowser(String browser) {
        setUpBasicConfigure();

        switch (browser) {
            case "edge":
                Configuration.browser = EDGE;
                break;
            case "firefox":
                Configuration.browser = FIREFOX;
                break;
            default:
                Configuration.browser = CHROME;
                break;
        }
    }
    public static void setUpBasicConfigure() {
        Configuration.baseUrl = PropertyReader.getBaseUrl();
        Configuration.headless = Boolean.parseBoolean(PropertyReader.getHeadless());
        Configuration.browserSize = PropertyReader.getBrowserSize();
        Configuration.timeout = Long.parseLong(PropertyReader.getTimeout());
        Configuration.screenshots = Boolean.parseBoolean(PropertyReader.getScreenshots());
    }
}
