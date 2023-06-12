package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class CartPage {

    private WebDriver driver;

    @FindBy(id = "account_pulldown")
    private WebElement buttonOfYourProfile;

    @FindBy(xpath = "//a[@href='javascript:Logout();']")
    private WebElement buttonLogOut;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getButtonOfYourProfile() {
        return buttonOfYourProfile;
    }

    public WebElement getButtonLogOut() {
        return buttonLogOut;
    }
}
