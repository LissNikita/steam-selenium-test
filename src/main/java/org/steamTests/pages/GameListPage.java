package org.steamTests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.Property;
import org.steamTests.utils.WaitUtils;

public class GameListPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/?snr=1_7_7_151_150_1']")
    private WebElement somethingGame;

    public GameListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void selectGame() {
        WaitUtils.waitForClickable(somethingGame);
        System.out.println("The game (" + Property.getPropertyValue("GAME_NAME") + ") was found!");
        somethingGame.click();
    }
}
