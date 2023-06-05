package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

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
        WaitUtils.waitForVisibility(sliderWithNewGames);
        return sliderWithNewGames.isDisplayed();
    }

    public void clickAboutButton() {
        WaitUtils.waitForClickable(aboutButton);
        aboutButton.click();
    }

    public void clickLoginButton() {
        WaitUtils.waitForClickable(loginButton);
        loginButton.click();
    }

    public boolean successfulLogin() {
        WaitUtils.waitForVisibility(messageButton);
        return messageButton.isDisplayed();
    }

    public boolean loginButtonIsDisplayed(){
        WaitUtils.waitForVisibility(loginButton);
        return loginButton.isDisplayed();
    }
}
