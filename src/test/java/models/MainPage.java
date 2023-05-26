package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class MainPage {

    private WebElement sliderWithNewGames;
    private WebElement aboutButton;

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

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
