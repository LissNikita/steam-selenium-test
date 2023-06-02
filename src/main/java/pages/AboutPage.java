package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.EditTextUtils;
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

    public boolean isDisplayed() {
        WaitUtils.waitForVisibility(checkThePageOfAbout);
        return checkThePageOfAbout.isDisplayed();
    }

    public int getValuePeopleOnline() {
        WaitUtils.waitForVisibility(valuePeopleOnline);
        String getOnline = valuePeopleOnline.getText();
        String[] deletedText = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(getOnline, "В СЕТИ");
        String[] deletedPunctuations = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
        for (String divideText : deletedPunctuations) {
            EditTextUtils
                    .sumOfPlayersOnline()
                    .append(divideText);
        }
        return EditTextUtils
                .createdFromStringIntoInt(EditTextUtils.getSumOnline());
    }

    public int getValuePeopleInGames() {
        WaitUtils.waitForVisibility(valuePeopleInGames);
        String getTextValuePeopleInGames = valuePeopleInGames.getText();
        String[] deletedText = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(getTextValuePeopleInGames, "В ИГРЕ");
        String[] deletedPunctuations = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
        for (String divideText : deletedPunctuations) {
            EditTextUtils
                    .sumOfPlayersInGames()
                    .append(divideText);
        }
        return EditTextUtils
                .createdFromStringIntoInt(EditTextUtils.getSumInGames());
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
