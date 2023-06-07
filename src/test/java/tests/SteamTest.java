package tests;

import lombok.extern.log4j.Log4j2;
import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.steamTests.models.UserData;
import org.steamTests.pages.*;
import org.steamTests.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.steamTests.utils.Property;
@Log4j2
public class SteamTest extends BaseTest {

    protected WebDriver driver;

    private MainPage mainPage;
    private ShopPage shopPage;
    private AboutPage aboutPage;
    private AuthorizationPage authorizationPage;
    private CartPage cartPage;
    private SelectedGamePage selectedGamePage;
    private GameListPage gameListPage;

    @BeforeClass
    public void startPage() {
        log.info("Before class driver");
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        shopPage = new ShopPage(driver);
        aboutPage = new AboutPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        cartPage = new CartPage(driver);
        selectedGamePage = new SelectedGamePage(driver);
        gameListPage = new GameListPage(driver);
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        mainPage.clickAboutButton();
        Assert.assertTrue(aboutPage.comparePeopleOnlineAndPeopleInGames(), "People in game >= than people online");
        aboutPage.clickOnShop();
        Assert.assertTrue(shopPage.checkShopPageIsOpened(), "Shop page is not opened");
    }

    @Test(retryAnalyzer = RetryUtils.class)
    public void testLoginAndPasswordCheck() {

        mainPage.clickLoginButton();
        authorizationPage.setLogin(Property.getPropertyValue("LOGIN"));
        authorizationPage.setPassword(Property.getPropertyValue("PASSWORD"));
        authorizationPage.clickEnterButton();
        Assert.assertTrue(mainPage.successfulLogin(), "No successes log");
    }

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class)
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

    @Test//(expectedExceptions = {org.openqa.selenium.TimeoutException.class})
    public void logOut(){

        cartPage.clickOnProfileButton();
        cartPage.clickLogOut();
        Assert.assertTrue(mainPage.loginButtonIsDisplayed(), "You didn't log out.");
    }
}
