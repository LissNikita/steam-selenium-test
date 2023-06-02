package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class PropertyMethods {

    public static WebDriver returnInfoAboutDriver() {
        if (Property.getPropertyValue("CHOSE_DRIVER").equals("Firefox")) {
            return WebDriverManager.firefoxdriver().create();
        } else if (Property.getPropertyValue("CHOSE_DRIVER").equals("Chrome")) {
            return WebDriverManager.chromedriver().create();
        }
        return null;
    }

    public static String returnInfoAboutWayToDriver() {
        if (Property.getPropertyValue("CHOSE_DRIVER").equals("Firefox")) {
            return Property.getPropertyValue("WAY_TO_FIREFOX");
        } else if (Property.getPropertyValue("CHOSE_DRIVER").equals("Chrome")) {
            return Property.getPropertyValue("WAY_TO_CHROME");
        }
        return null;
    }

    public static String returnInfoAboutKeys() {
        if (Property.getPropertyValue("CHOSE_DRIVER").equals("Firefox")) {
            return Property.getPropertyValue("DRIVER_KEY_FIREFOX");
        } else if (Property.getPropertyValue("CHOSE_DRIVER").equals("Chrome")) {
            return Property.getPropertyValue("DRIVER_KEY_CHROME");
        }
        return null;
    }
}
