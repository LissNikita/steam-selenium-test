package models;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class ShopPage {

    private final WebDriver driver;
    private WebElement sliderWithNewGames;

    private WebElement somethingGame;

    private WebElement buttonAddToCart;

    private WebElement cart;

    private WebElement primeStatus;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait createNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean checkShopPageIsOpened() {
        sliderWithNewGames = (createNewWebDriverWaitElement())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'home_cluster_ctn home_ctn']")));
        return sliderWithNewGames.isDisplayed();
    }

    public void setGamesSearch (String yourGame){
        somethingGame = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='store_nav_search_term']")));
        somethingGame.sendKeys(yourGame, Keys.ENTER);
    }

    public void selectGame(){
        somethingGame = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/?snr=1_7_7_151_150_1']")));
            System.out.println("The game (" + Property.getPropertyValue("GAME_NAME") + ") was found!");
            somethingGame.click();
    }

    public void clickOnTheButtonGameToCart(){
        buttonAddToCart = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.id("btn_add_to_cart_54029")));
        buttonAddToCart.click();
    }

    public boolean checkACartIsDisplayed(){
        cart = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.id("cart_link")));
        return cart.isDisplayed();
    }

    public void payPrimeStatus(){
        primeStatus = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'Купить прайм-статус']")));
        String textPrimeStatus = primeStatus.getText();
    }

}
