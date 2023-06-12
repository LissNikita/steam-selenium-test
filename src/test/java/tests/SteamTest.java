package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.steamTests.driver.DriverManager;
import org.steamTests.models.GameData;
import org.steamTests.models.UserData;
import org.steamTests.steps.AllSteps;
import org.steamTests.utils.JsonReader;
import org.steamTests.utils.RetryUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Log4j2
public class SteamTest extends BaseTest {

    protected WebDriver driver;

    private AllSteps allSteps;

    @BeforeClass
    public void startPage() {
        log.info("Before class driver");
        driver = DriverManager.getDriver();
        allSteps = new AllSteps(driver);
    }

    @Test(retryAnalyzer = RetryUtils.class, description = "Compare people online whit people in games and check shop page is opened")
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        allSteps.clickAboutButton();
        // Assert.assertTrue(aboutPage.comparePeopleOnlineAndPeopleInGames(), "People in game >= than people online");
        allSteps.clickOnShop();
        Assert.assertTrue(allSteps.checkShopPageIsOpened(), "Shop page is not opened");
    }

    @Test(dataProvider = "userSuccessfulData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class, description = "Check successful login and password")
    public void testLoginAndPasswordCheck(UserData userData) {

        allSteps.clickLoginButton();
        allSteps.setLogin(userData.getSuccessfulLogin());
        allSteps.setPassword(userData.getSuccessfulPassword());
        allSteps.clickEnterButton();
        Assert.assertTrue(allSteps.successfulLogin(), "No successes log");
    }

    @Test(dataProvider = "gameData", dataProviderClass = JsonReader.class, retryAnalyzer = RetryUtils.class, description = "Comparison of the selected product with the product in the cart")
    public void shoppingCartTest(GameData gameData) {

        allSteps.clickOnShop();
        allSteps.setGamesSearch(gameData.getGameName());
        allSteps.selectGame();
        allSteps.getPrimeStatusText(driver);
        allSteps.getPriceValueText(driver);
        allSteps.clickOnTheButtonGameToCart();
        Assert.assertTrue(allSteps.checkACartIsDisplayed(), "The cart was no add");
        allSteps.getNameOfProductInCart(driver);
        allSteps.getPriceInCart(driver);
        Assert.assertTrue(allSteps.getProductName().equals(allSteps.getProductNameInCart()), "Product names don't match!");
        Assert.assertTrue(allSteps.getPriceValueOfProduct().equals(allSteps.getPriceValueOfProductInCart()), "Product prices don't match");
    }

    @Test(description = "Check log out")
    public void logOut() {

        allSteps.clickOnProfileButton();
        allSteps.clickLogOut();
        Assert.assertTrue(allSteps.loginButtonIsDisplayed(), "You didn't log out.");
    }
}
