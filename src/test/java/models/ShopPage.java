package models;

import core.BeforeAndAfterMethods;
import core.SetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;
import java.util.Arrays;

public class ShopPage extends SetWebDriver {

    private WebElement sliderWithNewGames;

    private WebElement somethingGame;

    private WebElement buttonAddToCart;

    private WebElement cart;

    private WebElement primeStatus;

    private WebElement priceOfProduct;

    private String priceValueOfShop;

    private String productName;

    public String getPriceValueOfShop() {
        return priceValueOfShop;
    }

    public String productName() {
        return productName;
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

    public String getPrimeStatusText(){
        primeStatus = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'Купить прайм-статус']")));
        String [] correctValue = primeStatus.getText().split("Купить ");
        return productName = correctValue[1];
    }

    public String getPriceValue(){
        priceOfProduct = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '$14.99 USD')]")));
        String [] correctValue = priceOfProduct.getText().split(" USD");
        return priceValueOfShop = correctValue[0];
    }



}
