package tests;

import core.BeforeAndAfterMethods;
import models.AuthorizationPage;
import models.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Property;

public class NegativeTest extends BeforeAndAfterMethods {

    @Test(priority = 4)
    public void negativeAuthorization() {
        MainPage mainPage = new MainPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();

        mainPage.clickLoginButton();
        authorizationPage.setLogin(Property.getPropertyValue("NEGATIVE_LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("NEGATIVE_PASSWORD"));
        authorizationPage.clickEnterButton();

        Assert.assertTrue(authorizationPage.getMessageUnsuccessfulLogin().equals(authorizationPage.getErrorMessage()));

    }
}
