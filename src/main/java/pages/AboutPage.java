package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class AboutPage {

    private WebDriver driver;

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


    public AboutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private String[] splitTextForPeopleOnlineAndPeopleInGames(String textWhichYouNeedToCreated, String textWhichYouNeedToDeleted) {
        return textWhichYouNeedToCreated.split(textWhichYouNeedToDeleted);
    }

    private int createdFromStringIntoInt(StringBuilder elementForCreateIntoInt) {
        return Integer.parseInt(elementForCreateIntoInt.toString().trim());
    }

    public boolean isDisplayed() {
        WaitUtils.waitForVisibility(checkThePageOfAbout);
        return checkThePageOfAbout.isDisplayed();
    }

    public int getValuePeopleOnline() {
        WaitUtils.waitForVisibility(valuePeopleOnline);
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
        WaitUtils.waitForVisibility(valuePeopleInGames);
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
        WaitUtils.waitForVisibility(shopButton);
        shopButton.click();
    }

    public boolean checkMonitorVideoGradientIsDisplayed() {
        WaitUtils.waitForVisibility(checkMonitorThePageOfAbout);
        return checkThePageOfAbout.isDisplayed();
    }
}
