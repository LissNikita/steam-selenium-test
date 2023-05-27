package tests;

import core.BeforeAndAfterMethods;
import models.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Property;

public class SteamTest extends BeforeAndAfterMethods {

    @Test(priority = 1)
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        MainPage mainPage = new MainPage();
        AboutPage aboutPage = new AboutPage();
        ShopPage shopPage = new ShopPage();

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

        LoginButton loginButton = new LoginButton();

        Assert.assertTrue(loginButton.isDisplayed(), "The button is not visible!");

        loginButton.clickLoginButton();

        loginButton.setLogin(Property.getPropertyValue("LOGIN"));
        loginButton.setPassword(Property.getPropertyValue("PASSWORD"));
        loginButton.clickEnterButton();

        Assert.assertTrue(loginButton.successfulLogin(), "No successes log");
    }

    @Test(priority = 3)
    public void shoppingCartTest() {
        AboutPage aboutPage = new AboutPage();
        ShopPage shopPage = new ShopPage();
        CartPage cartPage = new CartPage();

        aboutPage.clickOnShop();

        shopPage.setGamesSearch(Property.getPropertyValue("GAME"));

        shopPage.selectGame();

        shopPage.getPrimeStatusText();
        shopPage.getPriceValue();

        shopPage.clickOnTheButtonGameToCart();

        Assert.assertTrue(shopPage.checkACartIsDisplayed(), "The cart was no add");

        cartPage.getNameOfProduct();
        cartPage.getPrice();

        Assert.assertTrue(shopPage.productName().equals(cartPage.productName()), "Product names don't match!");

        Assert.assertTrue(shopPage.getPriceValueOfShop().equals(cartPage.getPriceValue()), "Product prices don't match");
    }
}
