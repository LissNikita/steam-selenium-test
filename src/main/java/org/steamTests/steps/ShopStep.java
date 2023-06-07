package org.steamTests.steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.steamTests.pages.ShopPage;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class ShopStep {

    private ShopPage shopPage;

    public ShopStep(WebDriver driver){
        shopPage = new ShopPage(driver);
    }

    public boolean checkShopPageIsOpened() {
        log.info("Check, is shop page open");
        WaitUtils.waitForVisibility(shopPage.getSomethingGame());
        return shopPage.getSomethingGame().isDisplayed();
    }

    public void setGamesSearch(String yourGame) {
        log.info("Set games search");
        WaitUtils.waitForVisibility(shopPage.getSomethingGame());
        shopPage.getSomethingGame().sendKeys(yourGame, Keys.ENTER);
    }

}
