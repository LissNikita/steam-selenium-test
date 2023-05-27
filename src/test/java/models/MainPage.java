package models;

import core.BeforeAndAfterMethods;
import core.SetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends SetWebDriver {

    private WebElement sliderWithNewGames;
    private WebElement aboutButton;

    public WebDriverWait createNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isDisplayed() {
        sliderWithNewGames = (createNewWebDriverWaitElement())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'home_cluster_ctn home_ctn']")));
        return sliderWithNewGames.isDisplayed();
    }

    public void clickAboutButton() {
        aboutButton = (createNewWebDriverWaitElement())
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text()) = 'О STEAM']")));
        aboutButton.click();
    }
}
