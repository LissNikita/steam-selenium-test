package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.Property;

public class SteamTest extends BaseTest {

    private MainPage mainPage;
    private ShopPage shopPage;
    private AboutPage aboutPage;
    private AuthorizationPage authorizationPage;
    private CartPage cartPage;
    private SelectedGamePage selectedGamePage;
    private GameListPage gameListPage;

    @BeforeClass
    public void startPage() {
        mainPage = new MainPage(driver);
        shopPage = new ShopPage(driver);
        aboutPage = new AboutPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        cartPage = new CartPage(driver);
        selectedGamePage = new SelectedGamePage(driver);
        gameListPage = new GameListPage(driver);
    }

    @Test(priority = 1, retryAnalyzer = RetryUtils.class)
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not opened");
        mainPage.clickAboutButton();
        Assert.assertTrue(aboutPage.isDisplayed(), "About page is not opened");
        Assert.assertTrue(aboutPage.comparePeopleOnlineAndPeopleInGames(), "People in game >= than people online");
        Assert.assertTrue(aboutPage.checkMonitorVideoGradientIsDisplayed(), "The button is absent!");
        aboutPage.clickOnShop();
        Assert.assertTrue(shopPage.checkShopPageIsOpened(), "Shop page is not opened");
    }

    @Test(priority = 2, retryAnalyzer = RetryUtils.class)
    public void testLoginAndPasswordCheck() {

        mainPage.clickLoginButton();
        authorizationPage.setLogin(Property.getPropertyValue("LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("PASSWORD"));
        authorizationPage.clickEnterButton();
        Assert.assertTrue(mainPage.successfulLogin(), "No successes log");
    }

    @Test(priority = 3, retryAnalyzer = RetryUtils.class)
    public void shoppingCartTest() {

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
        cartPage.clickOnProfileButton();
        cartPage.clickLogOut();
    }

    @Test(priority = 4, retryAnalyzer = RetryUtils.class)
    public void negativeAuthorization() {

        mainPage.clickLoginButton();
        authorizationPage.setLogin(Property.getPropertyValue("NEGATIVE_LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("NEGATIVE_PASSWORD"));
        authorizationPage.clickEnterButton();
        Assert.assertTrue(authorizationPage.getMessageUnsuccessfulLogin().equals(authorizationPage.getErrorMessage()));

    }
}
