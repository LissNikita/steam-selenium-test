package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AboutPage {

    private WebElement valuePeopleOnline;

    private WebElement valuePeopleInGames;

    private WebElement checkThePageOfAbout;

    private WebElement shopButton;

    private WebDriver driver;

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement waitElementLocatedForPeopleOnlineAndPeopleInGames(String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    private String[] splitTextForPeopleOnlineAndPeopleInGames(String textWhichYouNeedToCreated, String textWhichYouNeedToDeleted) {
        return textWhichYouNeedToCreated.split(textWhichYouNeedToDeleted);
    }

    private int createdFromStringIntoInt(StringBuilder elementForCreateIntoInt) {
        return Integer.parseInt(elementForCreateIntoInt.toString().trim());
    }

    public boolean isDisplayed() {
        checkThePageOfAbout = waitElementLocatedForPeopleOnlineAndPeopleInGames("//div[@class = 'about_subtitle'][1]");
        return checkThePageOfAbout.isDisplayed();
    }

    public int getValuePeopleOnline() {
        valuePeopleOnline = waitElementLocatedForPeopleOnlineAndPeopleInGames("//div[@class = 'online_stat_label gamers_online']/parent::div");
        String getOnline = valuePeopleOnline.getText();
        String[] deletedText = splitTextForPeopleOnlineAndPeopleInGames(getOnline, "В СЕТИ");
//        String[] deletedText = getOnline.split("В СЕТИ");
        String[] deletedPunctuations = splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
//        String[] deletedPunctuations = deletedText[1].split(",");
        StringBuilder sumOnline = new StringBuilder();
        for (String divideText : deletedPunctuations) {
            sumOnline.append(divideText);
        }
        return createdFromStringIntoInt(sumOnline);
    }

    public int getValuePeopleInGames() {
        valuePeopleInGames = waitElementLocatedForPeopleOnlineAndPeopleInGames("//div[@class = 'online_stat_label gamers_in_game']/parent::div");
        String getTextValuePeopleInGames = valuePeopleInGames.getText();
        String[] deletedText = splitTextForPeopleOnlineAndPeopleInGames(getTextValuePeopleInGames, "В ИГРЕ");
//        String [] deletedText = getTextValuePeopleInGames.split("В ИГРЕ");
        String[] deletedPunctuations = splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
//        String [] deletedPunctuations = deletedText[1].split(",");
        StringBuilder sumInGames = new StringBuilder();
        for (String divideText : deletedPunctuations) {
            sumInGames.append(divideText);
        }
        return createdFromStringIntoInt(sumInGames);
    }

    public boolean compareOnlinePeopleAndInGamesPeople() {
        return getValuePeopleInGames() < getValuePeopleOnline();
    }

    public void clickOnShop() {
        shopButton = (new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space(text()) = 'МАГАЗИН']"))));
        shopButton.click();
    }

    public boolean checkMonitorVideoGradientIsDisplayed() {
        checkThePageOfAbout = waitElementLocatedForPeopleOnlineAndPeopleInGames("//div[@id = 'about_monitor_video_gradient']");
        return checkThePageOfAbout.isDisplayed();
    }
}
