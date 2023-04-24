package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class MainPage {
    private static final String URL = Property.getPropertyValue("URL_MainSteamPage");
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    private WebElement sliderWithNewGames;
    private WebElement aboutButton;

    public MainPage() {
    }

    public WebDriverWait creatNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isDisplayed() {
        sliderWithNewGames = (creatNewWebDriverWaitElement())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'home_cluster_ctn home_ctn']")));
        return sliderWithNewGames.isDisplayed();
    }

    public void clickAboutButton() {
        aboutButton = (creatNewWebDriverWaitElement())
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text()) = 'О STEAM']")));
        aboutButton.click();
    }
}
