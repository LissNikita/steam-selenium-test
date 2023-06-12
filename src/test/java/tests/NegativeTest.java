package tests;

import org.openqa.selenium.WebDriver;
import org.steamTests.driver.DriverManager;
import org.steamTests.models.UserData;
import org.steamTests.steps.LoginStep;
import org.steamTests.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeTest extends BaseTest {

    protected WebDriver driver;
    private LoginStep loginStep;

    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        loginStep = new LoginStep(driver);
    }

    @Test(dataProvider = "userUnsuccessfulData", dataProviderClass = JsonReader.class, description = "Check negative login")
    public void negativeLog(UserData userData) {

        loginStep.clickLoginButton();
        loginStep.setLogin(userData.getUnsuccessfulLogin());
        loginStep.setPassword(userData.getUnsuccessfulPassword());
        loginStep.clickEnterButton();
        Assert.assertTrue(loginStep.getMessageUnsuccessfulLogin().equals(loginStep.getErrorMessage()), "Too many attempts, try again later");
    }
}
