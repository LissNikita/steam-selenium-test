package tests;

import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.steamTests.models.UserData;
import org.steamTests.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.steamTests.utils.Property;

public class SteamTest extends BaseTest {

    protected WebDriver driver;

    private MainPage mainPage;
    private ShopPage shopPage;
    private AboutPage aboutPage;
    private AuthorizationPage authorizationPage;
    private CartPage cartPage;
    private SelectedGamePage selectedGamePage;
    private GameListPage gameListPage;

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {new UserData("csgo")},
                {new UserData("CSGO")},
                {new UserData("Counter-Strike: Global Offensive")}
        };
    }

    @BeforeClass
    public void startPage() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        shopPage = new ShopPage(driver);
        aboutPage = new AboutPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        cartPage = new CartPage(driver);
        selectedGamePage = new SelectedGamePage(driver);
        gameListPage = new GameListPage(driver);
    }

    @Test
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        Assert.assertTrue(mainPage.isDisplayed(), "Main page is not opened");
        mainPage.clickAboutButton();
        Assert.assertTrue(aboutPage.comparePeopleOnlineAndPeopleInGames(), "People in game >= than people online");
        aboutPage.clickOnShop();
        Assert.assertTrue(shopPage.checkShopPageIsOpened(), "Shop page is not opened");
    }

    @Test
    public void testLoginAndPasswordCheck() {

        mainPage.clickLoginButton();
        authorizationPage.setLogin(Property.getPropertyValue("LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("PASSWORD"));
        authorizationPage.clickEnterButton();
        Assert.assertTrue(mainPage.successfulLogin(), "No successes log");
    }

    @Test(dataProvider = "data-provider")
    public void shoppingCartTest(UserData userData) {

        aboutPage.clickOnShop();
        shopPage.setGamesSearch(userData.getGameName());
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

    @Test
    public void logOut(){

        cartPage.clickOnProfileButton();
        cartPage.clickLogOut();
        Assert.assertTrue(mainPage.loginButtonIsDisplayed(), "You didn't log out.");
    }
}
