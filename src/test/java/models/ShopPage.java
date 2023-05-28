package models;

import core.SetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class ShopPage extends SetWebDriver {

    private WebElement somethingGame;
    private WebElement sliderWithNewGames;

    public WebDriverWait createNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean checkShopPageIsOpened() {
        sliderWithNewGames = (createNewWebDriverWaitElement())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'home_cluster_ctn home_ctn']")));
        return sliderWithNewGames.isDisplayed();
    }

    public void setGamesSearch(String yourGame) {
        somethingGame = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='store_nav_search_term']")));
        somethingGame.sendKeys(yourGame, Keys.ENTER);
    }
}
