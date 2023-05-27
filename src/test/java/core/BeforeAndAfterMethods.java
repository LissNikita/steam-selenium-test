package core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Property;
import utils.PropertyMethods;

import java.util.concurrent.TimeUnit;

abstract public class BeforeAndAfterMethods {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = PropertyMethods.returnInfoAboutDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        SetWebDriver.setDriver(driver);
        final String URL = Property.getPropertyValue("URL_MainSteamPage");
        driver.get(URL);
    }

    @AfterTest
    public void setDown() {
        driver.close();
        driver.quit();
    }
}
