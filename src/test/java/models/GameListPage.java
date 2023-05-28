package models;

import core.SetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class GameListPage extends SetWebDriver {

    private WebElement somethingGame;

    public WebDriverWait createNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void selectGame() {
        somethingGame = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/?snr=1_7_7_151_150_1']")));
        System.out.println("The game (" + Property.getPropertyValue("GAME_NAME") + ") was found!");
        somethingGame.click();
    }
}
