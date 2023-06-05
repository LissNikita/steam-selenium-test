package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class MainPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'home_cluster_ctn home_ctn']")
    private WebElement sliderWithNewGames;
    @FindBy(xpath = "//a[normalize-space(text()) = 'О STEAM']")
    private WebElement aboutButton;
    @FindBy(xpath = "//a[@class='global_action_link']")
    private WebElement loginButton;
    @FindBy(id = "header_notification_link")
    private WebElement messageButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isDisplayed() {
        log.info("Check, Is slider displayed");
        WaitUtils.waitForVisibility(sliderWithNewGames);
        return sliderWithNewGames.isDisplayed();
    }

    public void clickAboutButton() {
        log.info("Click on about button");
        WaitUtils.waitForClickable(aboutButton);
        aboutButton.click();
    }

    public void clickLoginButton() {
        log.info("Click on login button");
        WaitUtils.waitForClickable(loginButton);
        loginButton.click();
    }

    public boolean successfulLogin() {
        log.info("Check, is login successful");
        WaitUtils.waitForVisibility(messageButton);
        return messageButton.isDisplayed();
    }

    public boolean loginButtonIsDisplayed() {
        log.info("Check, is login button displayed");
        WaitUtils.waitForVisibility(loginButton);
        return loginButton.isDisplayed();
    }
}
