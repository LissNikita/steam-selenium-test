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
    private WebElement loginButton;
    private WebElement messageButton;

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

    public boolean loginButtonIsDisplayed() {
        loginButton = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='global_action_link']")));
        return loginButton.isDisplayed();
    }

    public void clickLoginButton() {
        loginButton = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='global_action_link']")));
        loginButton.click();
    }

    public boolean successfulLogin() {
        messageButton = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='header_notification_link']")));
        return messageButton.isDisplayed();
    }
}
