package models;

import core.SetWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class AboutPage extends SetWebDriver {

    @FindBy(xpath = "//div[@class = 'online_stat_label gamers_online']/parent::div")
    private WebElement valuePeopleOnline;
    @FindBy(xpath = "//div[@class = 'online_stat_label gamers_in_game']/parent::div")
    private WebElement valuePeopleInGames;
    @FindBy(xpath = "//div[@class = 'about_subtitle']")
    private WebElement checkThePageOfAbout;
    @FindBy(xpath = "//div[@id = 'about_monitor_video_gradient']")
    private WebElement checkMonitorThePageOfAbout;
    @FindBy(xpath = "//a[normalize-space(text()) = 'МАГАЗИН']")
    private WebElement shopButton;

    private void waitForVisibility(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public AboutPage() {
        driver.get(Property.getPropertyValue("ABOUT_PAGE"));
        PageFactory.initElements(driver, this);
    }

    private String[] splitTextForPeopleOnlineAndPeopleInGames(String textWhichYouNeedToCreated, String textWhichYouNeedToDeleted) {
        return textWhichYouNeedToCreated.split(textWhichYouNeedToDeleted);
    }

    private int createdFromStringIntoInt(StringBuilder elementForCreateIntoInt) {
        return Integer.parseInt(elementForCreateIntoInt.toString().trim());
    }

    public boolean isDisplayed() {
        waitForVisibility(checkThePageOfAbout);
        return checkThePageOfAbout.isDisplayed();
    }

    public int getValuePeopleOnline() {
        waitForVisibility(valuePeopleOnline);
        String getOnline = valuePeopleOnline.getText();
        String[] deletedText = splitTextForPeopleOnlineAndPeopleInGames(getOnline, "В СЕТИ");
        String[] deletedPunctuations = splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
        StringBuilder sumOnline = new StringBuilder();
        for (String divideText : deletedPunctuations) {
            sumOnline.append(divideText);
        }
        return createdFromStringIntoInt(sumOnline);
    }

    public int getValuePeopleInGames() {
        waitForVisibility(valuePeopleInGames);
        String getTextValuePeopleInGames = valuePeopleInGames.getText();
        String[] deletedText = splitTextForPeopleOnlineAndPeopleInGames(getTextValuePeopleInGames, "В ИГРЕ");
        String[] deletedPunctuations = splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
        StringBuilder sumInGames = new StringBuilder();
        for (String divideText : deletedPunctuations) {
            sumInGames.append(divideText);
        }
        return createdFromStringIntoInt(sumInGames);
    }

    public boolean comparePeopleOnlineAndPeopleInGames() {
        return getValuePeopleInGames() < getValuePeopleOnline();
    }

    public void clickOnShop() {
        waitForVisibility(shopButton);
        shopButton.click();
    }

    public boolean checkMonitorVideoGradientIsDisplayed() {
        waitForVisibility(checkMonitorThePageOfAbout);
        return checkThePageOfAbout.isDisplayed();
    }
}
