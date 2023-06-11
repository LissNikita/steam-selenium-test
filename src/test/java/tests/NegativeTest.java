package tests;

import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.steamTests.models.UserData;
import org.steamTests.pages.AuthorizationPage;
import org.steamTests.pages.MainPage;
import org.steamTests.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

    @Test(dataProvider = "userUnsuccessfulData", dataProviderClass = JsonReader.class, description = "Check negative login")
    public void negativeLog(UserData userData){

        mainPage.clickLoginButton();
        authorizationPage.setLogin(userData.getUnsuccessfulLogin());
        authorizationPage.setPassword(userData.getUnsuccessfulPassword());
        authorizationPage.clickEnterButton();
        Assert.assertTrue(authorizationPage.getMessageUnsuccessfulLogin().equals(authorizationPage.getErrorMessage()));
    }
}
