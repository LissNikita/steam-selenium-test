package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.EditTextUtils;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class AboutPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class = 'online_stat_label gamers_online']/parent::div")
    private WebElement valuePeopleOnline;
    @FindBy(xpath = "//div[@class = 'online_stat_label gamers_in_game']/parent::div")
    private WebElement valuePeopleInGames;
    @FindBy(xpath = "//div[@id = 'about_monitor_video_gradient']")
    private WebElement checkMonitorThePageOfAbout;
    @FindBy(xpath = "//a[normalize-space(text()) = 'МАГАЗИН']")
    private WebElement shopButton;

    public AboutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getValuePeopleOnline() {
        log.info("Get value people online");
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
        log.info("Get value people in games");
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
        log.info("Compare people online and people in games");
        return getValuePeopleInGames() < getValuePeopleOnline();
    }

    public void clickOnShop() {
        log.info("Click on shop");
        WaitUtils.waitForVisibility(shopButton);
        shopButton.click();
    }

}
