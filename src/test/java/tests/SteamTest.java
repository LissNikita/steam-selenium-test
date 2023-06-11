package tests;

import lombok.extern.log4j.Log4j2;
import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.steamTests.models.GameData;
import org.steamTests.models.UserData;
import org.steamTests.pages.*;
import org.steamTests.steps.ShopStep;
import org.steamTests.utils.JsonReader;
import org.steamTests.utils.RetryUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Log4j2
public class SteamTest extends BaseTest {

    protected WebDriver driver;

    private ShopStep shopStep;

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
        shopStep = new ShopStep(driver);
        mainPage = new MainPage(driver);
        //shopPage = new ShopPage(driver);
        aboutPage = new AboutPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        cartPage = new CartPage(driver);
        selectedGamePage = new SelectedGamePage(driver);
        gameListPage = new GameListPage(driver);
    }

    @Test(retryAnalyzer = RetryUtils.class, description = "Compare people online whit people in games")
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        mainPage.clickAboutButton();
        Assert.assertTrue(aboutPage.comparePeopleOnlineAndPeopleInGames(), "People in game >= than people online");
        aboutPage.clickOnShop();
        Assert.assertTrue(shopStep.checkShopPageIsOpened(), "Shop page is not opened");
    }

    @Test(dataProvider = "userSuccessfulData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class, description = "Check successful login and password")
    public void testLoginAndPasswordCheck(UserData userData) {

        mainPage.clickLoginButton();
        authorizationPage.setLogin(userData.getSuccessfulLogin());
        authorizationPage.setPassword(userData.getSuccessfulPassword());
        authorizationPage.clickEnterButton();
        Assert.assertTrue(mainPage.successfulLogin(), "No successes log");
    }

    @Test(dataProvider = "gameData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class, description = "Comparison of the selected product with the product in the cart")
    public void shoppingCartTest(GameData gameData) {

        aboutPage.clickOnShop();
        shopStep.setGamesSearch(gameData.getGameName());
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

    @Test(description = "Check log out")
    public void logOut(){

        cartPage.clickOnProfileButton();
        cartPage.clickLogOut();
        Assert.assertTrue(mainPage.loginButtonIsDisplayed(), "You didn't log out.");
    }
}
