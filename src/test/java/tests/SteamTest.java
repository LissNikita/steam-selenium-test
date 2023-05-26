package tests;

import models.LoginButton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import models.AboutPage;
import utils.Property;
import utils.PropertyMethods;
import models.MainPage;
import models.ShopPage;

public class SteamTest {

    private static WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = PropertyMethods.returnInfoAboutDriver();
        driver.manage().window().maximize();
        final String URL = Property.getPropertyValue("URL_MainSteamPage");
        driver.get(URL);
    }

    @Test(priority = 1)
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        MainPage mainPage = new MainPage(driver);
        AboutPage aboutPage = new AboutPage(driver);
        ShopPage shopPage = new ShopPage(driver);

        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not opened");

        mainPage.clickAboutButton();
        Assert.assertTrue(aboutPage.isDisplayed(), "About page is not opened");

        Assert.assertTrue(aboutPage.compareOnlinePeopleAndInGamesPeople(), "People in game >= than people online");

        Assert.assertTrue(aboutPage.checkMonitorVideoGradientIsDisplayed(), "The button is absent!");
        aboutPage.clickOnShop();

        Assert.assertTrue(shopPage.checkShopPageIsOpened(), "Shop page is not opened");
    }

    @Test(priority = 2)
    public void testLoginAndPasswordCheck(){

        LoginButton loginButton = new LoginButton(driver);

        Assert.assertTrue(loginButton.isDisplayed(), "The button is not visible!");

        loginButton.clickLoginButton();

        loginButton.setLogin(Property.getPropertyValue("LOGIN"));
        loginButton.setPassword(Property.getPropertyValue("PASSWORD"));
        loginButton.clickEnterButton();

        Assert.assertTrue(loginButton.successfulLogin(), "No successes log");

    }

    @AfterTest
    public void setDown() {
        driver.close();
        driver.quit();
    }
}
