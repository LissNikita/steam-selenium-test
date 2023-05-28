package models;

import core.SetWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class MainPage extends SetWebDriver {

    @FindBy(xpath = "//div[@class = 'home_cluster_ctn home_ctn']")
    private WebElement sliderWithNewGames;
    @FindBy(xpath = "//a[normalize-space(text()) = 'О STEAM']")
    private WebElement aboutButton;
    @FindBy(xpath = "//a[@class='global_action_link']")
    private WebElement loginButton;
    @FindBy(id = "header_notification_link")
    private WebElement messageButton;

    public MainPage() {
        driver.get(Property.getPropertyValue("MAIN_PAGE"));
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibility(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForClickable(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public boolean isDisplayed() {
        waitForVisibility(sliderWithNewGames);
        return sliderWithNewGames.isDisplayed();
    }

    public void clickAboutButton() {
        waitForClickable(aboutButton);
        aboutButton.click();
    }

    public boolean loginButtonIsDisplayed() {
        waitForVisibility(loginButton);
        return loginButton.isDisplayed();
    }

    public void clickLoginButton() {
        waitForClickable(loginButton);
        loginButton.click();
    }

    public boolean successfulLogin() {
        waitForVisibility(messageButton);
        return messageButton.isDisplayed();
    }
}
