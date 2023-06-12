package tests;

import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.steamTests.models.UserData;
import org.steamTests.pages.AuthorizationPage;
import org.steamTests.pages.MainPage;
import org.steamTests.steps.AllSteps;
import org.steamTests.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeTest extends BaseTest{

    protected WebDriver driver;
    private AllSteps allSteps;


    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        allSteps = new AllSteps(driver);
    }

    @Test(dataProvider = "userUnsuccessfulData", dataProviderClass = JsonReader.class, description = "Check negative login")
    public void negativeLog(UserData userData){

        allSteps.clickLoginButton();
        allSteps.setLogin(userData.getUnsuccessfulLogin());
        allSteps.setPassword(userData.getUnsuccessfulPassword());
        allSteps.clickEnterButton();
        Assert.assertTrue(allSteps.getMessageUnsuccessfulLogin().equals(allSteps.getErrorMessage()), "Too many attempts, try again later");
    }
}
