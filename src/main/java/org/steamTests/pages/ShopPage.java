package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class ShopPage {

    private WebDriver driver;

    @FindBy(id = "store_nav_search_term")
    private WebElement somethingGame;

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getSomethingGame() {
        return somethingGame;
    }
}
