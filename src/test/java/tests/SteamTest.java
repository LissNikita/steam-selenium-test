package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import models.AboutPage;
import utils.PropertyMethods;
import models.MainPage;
import models.ShopPage;

public class SteamTest {

    private static WebDriver driver;

    @Test
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

         driver = PropertyMethods.returnInfoAboutDriver();

            MainPage mainPage = new MainPage(driver);
            AboutPage aboutPage = new AboutPage(driver);
            ShopPage shopPage = new ShopPage(driver);

            mainPage.open();

            Assert.assertTrue(mainPage.isDisplayed(), "Main page is not opened");

            mainPage.clickAboutButton();
            Assert.assertTrue(aboutPage.isDisplayed(), "About page is not opened");

            Assert.assertTrue(aboutPage.compareOnlinePeopleAndInGamesPeople(), "People in game >= than people online");

            Assert.assertTrue(aboutPage.checkMonitorVideoGradientIsDisplayed(), "The button is absent!");
            aboutPage.clickOnShop();

            Assert.assertTrue(shopPage.checkShopPageIsOpened(), "Shop page is not opened");
    }
    @AfterTest
    public void closeDriver(){
        driver.quit();
    }
}
