package org.steamTests.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.WaitUtils;

public class ShopPage {

    private WebDriver driver;

    @FindBy(id = "store_nav_search_term")
    private WebElement somethingGame;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean checkShopPageIsOpened() {
        WaitUtils.waitForVisibility(somethingGame);
        return somethingGame.isDisplayed();
    }

    public void setGamesSearch(String yourGame) {
        WaitUtils.waitForVisibility(somethingGame);
        somethingGame.sendKeys(yourGame, Keys.ENTER);
    }
}
