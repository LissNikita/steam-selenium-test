package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public WebElement getSliderWithNewGames() {
        return sliderWithNewGames;
    }

    public WebElement getAboutButton() {
        return aboutButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getMessageButton() {
        return messageButton;
    }
}
