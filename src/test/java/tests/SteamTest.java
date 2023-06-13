package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.steamTests.driver.DriverManager;
import org.steamTests.models.GameData;
import org.steamTests.models.UserData;
import org.steamTests.steps.InfoAboutGameStep;
import org.steamTests.steps.LoginStep;
import org.steamTests.steps.SteamBaseSteps;
import org.steamTests.utils.JsonReader;
import org.steamTests.utils.RetryUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Log4j2
public class SteamTest extends BaseTest {

    protected WebDriver driver;

    private SteamBaseSteps steamBaseSteps;
    private InfoAboutGameStep infoAboutGameStep;
    private LoginStep loginStep;

    @BeforeClass
    public void startPage() {
        log.info("Before class driver");
        driver = DriverManager.getDriver();
        steamBaseSteps = new SteamBaseSteps(driver);
        infoAboutGameStep = new InfoAboutGameStep(driver);
        loginStep = new LoginStep(driver);
    }

    @Test(retryAnalyzer = RetryUtils.class,
            description = "Compare people online whit people in games and check shop page is opened")
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {

        steamBaseSteps.clickAboutButton();
        Assert.assertTrue(steamBaseSteps.comparePeopleOnlineAndPeopleInGames());
    }

    @Test(retryAnalyzer = RetryUtils.class,
            description = "Check shop page is opened")
    public void openShop() {

        steamBaseSteps.clickOnShop();
        Assert.assertTrue(steamBaseSteps.checkShopPageIsOpened());
    }

    @Test(dataProvider = "userSuccessfulData",
            dataProviderClass = JsonReader.class,
            retryAnalyzer = RetryUtils.class,
            description = "Check successful login and password")
    public void testLoginAndPasswordCheck(UserData userData) {

        loginStep.clickLoginButton();
        loginStep.setLogin(userData.getSuccessfulLogin());
        loginStep.setPassword(userData.getSuccessfulPassword());
        loginStep.clickEnterButton();
        Assert.assertTrue(loginStep.successfulLogin());
    }

    @Test(dataProvider = "gameData",
            dataProviderClass = JsonReader.class,
            retryAnalyzer = RetryUtils.class,
            description = "Comparison of the selected product with the product in the cart")
    public void shoppingCartTest(GameData gameData) {

        steamBaseSteps.clickOnShop();
        steamBaseSteps.setGamesSearch(gameData.getGameName());
        steamBaseSteps.selectGame();
        infoAboutGameStep.getPrimeStatusText();
        infoAboutGameStep.getPriceValueText();
        infoAboutGameStep.clickOnTheButtonGameToCart();
        infoAboutGameStep.getNameOfProductInCart();
        infoAboutGameStep.getPriceInCart();
        Assert.assertTrue(infoAboutGameStep.getProductName().equals(infoAboutGameStep.getProductNameInCart()));
        Assert.assertTrue(infoAboutGameStep.getPriceValueOfProduct().equals(infoAboutGameStep.getPriceValueOfProductInCart()));
    }

    @Test(description = "Check log out")
    public void logOut() {

        steamBaseSteps.clickOnProfileButton();
        steamBaseSteps.clickLogOut();
        Assert.assertTrue(loginStep.loginButtonIsDisplayed());
    }
}
