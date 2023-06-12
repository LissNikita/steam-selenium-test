package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public WebElement getValuePeopleOnline() {
        return valuePeopleOnline;
    }

    public WebElement getValuePeopleInGames() {
        return valuePeopleInGames;
    }

    public WebElement getCheckMonitorThePageOfAbout() {
        return checkMonitorThePageOfAbout;
    }

    public WebElement getShopButton() {
        return shopButton;
    }
}
