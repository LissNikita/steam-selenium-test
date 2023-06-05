package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class ShopPage {

    private WebDriver driver;

    @FindBy(id = "store_nav_search_term")
    private WebElement somethingGame;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean checkShopPageIsOpened() {
        log.info("Check, is shop page open");
        WaitUtils.waitForVisibility(somethingGame);
        return somethingGame.isDisplayed();
    }

    public void setGamesSearch(String yourGame) {
        log.info("Set games search");
        WaitUtils.waitForVisibility(somethingGame);
        somethingGame.sendKeys(yourGame, Keys.ENTER);
    }
}
