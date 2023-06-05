package tests;

import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.steamTests.utils.Property;

abstract public class BaseTest {

    protected WebDriver driver;
    private final String URL = Property.getPropertyValue("URL_MainSteamPage");

    @BeforeTest
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @BeforeMethod
    public void preparation() {
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterTest
    public void setDown() {
        DriverManager.quitDriver();
    }
}
