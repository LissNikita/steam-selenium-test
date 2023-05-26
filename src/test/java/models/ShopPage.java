package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {

    private final WebDriver driver;
    private WebElement sliderWithNewGames;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait createNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean checkShopPageIsOpened() {
        sliderWithNewGames = (createNewWebDriverWaitElement())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class = 'home_cluster_ctn home_ctn']")));
        return sliderWithNewGames.isDisplayed();
    }
}
