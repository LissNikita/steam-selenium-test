package driver;

import org.openqa.selenium.WebDriver;

abstract public class WebDriverManager {

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }
}
