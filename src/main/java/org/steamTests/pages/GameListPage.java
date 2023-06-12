package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class GameListPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/?snr=1_7_7_151_150_1']")
    private WebElement somethingGame;

    public GameListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getSomethingGame() {
        return somethingGame;
    }
}
