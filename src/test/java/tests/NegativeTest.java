package tests;

import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.steamTests.pages.AuthorizationPage;
import org.steamTests.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.steamTests.utils.Property;

public class NegativeTest extends BaseTest{

    protected WebDriver driver;

    private MainPage mainPage;
    private AuthorizationPage authorizationPage;

    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);
    }

    @Test
    public void negativeLog(){

        mainPage.clickLoginButton();
        authorizationPage.setLogin(Property.getPropertyValue("NEGATIVE_LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("NEGATIVE_PASSWORD"));
        authorizationPage.clickEnterButton();
        Assert.assertTrue(authorizationPage.getMessageUnsuccessfulLogin().equals(authorizationPage.getErrorMessage()));
    }
}
