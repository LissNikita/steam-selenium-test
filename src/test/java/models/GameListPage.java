package models;

import core.SetWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class GameListPage extends SetWebDriver {

    @FindBy(xpath = "//a[@href='https://store.steampowered.com/app/730/CounterStrike_Global_Offensive/?snr=1_7_7_151_150_1']")
    private WebElement somethingGame;

    public GameListPage() {
        driver.get(Property.getPropertyValue("GAME_LIST_PAGE"));
        PageFactory.initElements(driver, this);
    }

    public void waitForClickable(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void selectGame() {
        waitForClickable(somethingGame);
        System.out.println("The game (" + Property.getPropertyValue("GAME_NAME") + ") was found!");
        somethingGame.click();
    }
}
