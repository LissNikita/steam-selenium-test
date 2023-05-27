package tests;

import core.BeforeAndAfterMethods;
import models.AboutPage;
import models.LoginButton;
import models.MainPage;
import models.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Property;
import utils.PropertyMethods;

import java.util.concurrent.TimeUnit;

public class SteamTest extends BeforeAndAfterMethods {

    //private static WebDriver driver;

//    @BeforeTest
//    public void setUp() {
//        driver = PropertyMethods.returnInfoAboutDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        final String URL = Property.getPropertyValue("URL_MainSteamPage");
//        driver.get(URL);
//    }

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
    public void testLoginAndPasswordCheck() {

        LoginButton loginButton = new LoginButton(driver);

        Assert.assertTrue(loginButton.isDisplayed(), "The button is not visible!");

        loginButton.clickLoginButton();

        loginButton.setLogin(Property.getPropertyValue("LOGIN"));
        loginButton.setPassword(Property.getPropertyValue("PASSWORD"));
        loginButton.clickEnterButton();

        Assert.assertTrue(loginButton.successfulLogin(), "No successes log");

    }

    @Test(priority = 3)
    public void shoppingCartTest(){
        AboutPage aboutPage = new AboutPage(driver);
        ShopPage shopPage = new ShopPage(driver);

        aboutPage.clickOnShop();

        shopPage.setGamesSearch(Property.getPropertyValue("GAME"));

        shopPage.selectGame();

        shopPage.clickOnTheButtonGameToCart();

        Assert.assertTrue(shopPage.checkACartIsDisplayed(), "The cart was no add");

        WebElement addedElement = driver.findElement(By.xpath("//a[contains(text(), 'прайм-статус')]"));
        System.out.println(addedElement.getText());

    }

//    @AfterTest
//    public void setDown() {
//        driver.close();
//        driver.quit();
//    }
}
