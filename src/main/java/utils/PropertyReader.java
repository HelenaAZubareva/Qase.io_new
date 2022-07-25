package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
//    private static Properties properties;

//    public PropertyReader() {
//        properties = new Properties();
//        try {
//            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


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

    public static String getHeadless() {
        return properties.getProperty("headless");
    }

    public static String getBrowserSize() {
        return properties.getProperty("browser.size");
    }
    public static String getTimeout() {
        return properties.getProperty("timeout");
    }
    public static String getScreenshots() {
        return properties.getProperty("screenshots");
    }

    public  static String getToken() {
        return properties.getProperty("token");
    }

    public  static String getBaseUrlApi() {
        return properties.getProperty("baseUrlApi");
    }



}