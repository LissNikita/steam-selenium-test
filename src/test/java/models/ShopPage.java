package models;

import core.SetWebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class ShopPage extends SetWebDriver {

    @FindBy(id = "store_nav_search_term")
    private WebElement somethingGame;
    @FindBy(xpath = "//input[@id='store_nav_search_term']")
    private WebElement sliderWithNewGames;

    public ShopPage() {
        driver.get(Property.getPropertyValue("SHOP_PAGE"));
        PageFactory.initElements(driver, this);
    }

    private void waitForVisibility(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public boolean checkShopPageIsOpened() {
        waitForVisibility(sliderWithNewGames);
        return sliderWithNewGames.isDisplayed();
    }

    public void setGamesSearch(String yourGame) {
        waitForVisibility(somethingGame);
        somethingGame.sendKeys(yourGame, Keys.ENTER);
    }
}
