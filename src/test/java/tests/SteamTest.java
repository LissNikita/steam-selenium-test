package tests;

import core.BeforeAndAfterMethods;
import models.*;
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

        Assert.assertTrue(aboutPage.comparePeopleOnlineAndPeopleInGames(), "People in game >= than people online");

        Assert.assertTrue(aboutPage.checkMonitorVideoGradientIsDisplayed(), "The button is absent!");
        aboutPage.clickOnShop();

        Assert.assertTrue(shopPage.checkShopPageIsOpened(), "Shop page is not opened");
    }

    @Test(priority = 2)
    public void testLoginAndPasswordCheck() {

        MainPage mainPage = new MainPage();
        AuthorizationPage authorizationPage = new AuthorizationPage();

        Assert.assertTrue(mainPage.loginButtonIsDisplayed(), "The button is not visible!");

        mainPage.clickLoginButton();

        authorizationPage.setLogin(Property.getPropertyValue("LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("PASSWORD"));
        authorizationPage.clickEnterButton();

        Assert.assertTrue(mainPage.successfulLogin(), "No successes log");
    }

    @Test(priority = 4)
    public void shoppingCartTest() {
        AboutPage aboutPage = new AboutPage();
        ShopPage shopPage = new ShopPage();
        CartPage cartPage = new CartPage();
        SelectedGamePage selectedGamePage = new SelectedGamePage();
        GameListPage gameListPage = new GameListPage();

        aboutPage.clickOnShop();

        shopPage.setGamesSearch(Property.getPropertyValue("GAME"));

        gameListPage.selectGame();

        selectedGamePage.getPrimeStatusText();
        selectedGamePage.getPriceValueText();

        selectedGamePage.clickOnTheButtonGameToCart();

        Assert.assertTrue(selectedGamePage.checkACartIsDisplayed(), "The cart was no add");

        cartPage.getNameOfProduct();
        cartPage.getPrice();

        Assert.assertTrue(selectedGamePage.productName().equals(cartPage.productName()), "Product names don't match!");

        Assert.assertTrue(selectedGamePage.getPriceValueOfProduct().equals(cartPage.getPriceValueOfProduct()), "Product prices don't match");
    }
}
