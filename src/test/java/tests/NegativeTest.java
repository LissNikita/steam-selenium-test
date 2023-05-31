package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import utils.Property;

public class NegativeTest extends BaseTest {

    private AuthorizationPage authorizationPage;
    private MainPage mainPage;

    @BeforeClass
    public void preparationForTest() {
        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
    }

    @Test(priority = 4)
    public void negativeAuthorization() {

        mainPage.clickLoginButton();
        authorizationPage.setLogin(Property.getPropertyValue("NEGATIVE_LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("NEGATIVE_PASSWORD"));
        authorizationPage.clickEnterButton();

        Assert.assertTrue(authorizationPage.getMessageUnsuccessfulLogin().equals(authorizationPage.getErrorMessage()));

    }
}
