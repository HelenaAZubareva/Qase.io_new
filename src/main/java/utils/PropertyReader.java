package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
        private static Properties properties;

        static {
            properties = new Properties();
            try {
                properties.load(PropertyReader.class.getClassLoader().getResourceAsStream("config.properties"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public static String getEmail() {
        return properties.getProperty("email");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }

    public static String getLoginUrl() {
        return properties.getProperty("login.url");
    }
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }
    public static String getProjectsPageUrl() {
        return properties.getProperty("projectsPage.url");
    }
    public static String getLoginPageUrl() {
        return properties.getProperty("loginPage.url");
    }
    public static Boolean getHeadless() {
        return Boolean.valueOf(properties.getProperty("headless"));
    }

    public static String getBrowserSize() {
        return properties.getProperty("browser.size");
    }
    public static Long getTimeout() {
        return Long.valueOf(properties.getProperty("timeout"));
    }
    public static Boolean getScreenshots() {
        return Boolean.valueOf(properties.getProperty("screenshots"));
    }

    public  static String getToken() {
        return properties.getProperty("token");
    }

    public  static String getBaseUrlApi() {
        return properties.getProperty("baseUrlApi");
    }

    public static String getProjectApiUri() {
        return properties.getProperty("projectApi.uri");
    }
    public static String getAllProjectApiUri() {
        return properties.getProperty("allProjectApiUri.uri");
    }
    public static String getRunApiUri() {
        return properties.getProperty("runApi.uri");
    }
    public static String getDefectApiUri() {
        return properties.getProperty("defectApi.uri");
    }

    public static String getCasesApiUri() {
        return properties.getProperty("casesApi.uri");
    }
    public static String getSuitesApiUri() {
        return properties.getProperty("suiteApi.uri");
    }
    public static String getResultApiUri() {
        return properties.getProperty("resultApi.uri");
    }

}
