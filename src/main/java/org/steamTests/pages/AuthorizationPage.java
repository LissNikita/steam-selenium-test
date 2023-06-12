package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class AuthorizationPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@type='text' and contains (@class, 'newlogindialog_TextInput_2eKVn')]")
    private WebElement login;
    @FindBy(xpath = "//input[@type='password' and contains (@class, 'newlogindialog_TextInput_2eKVn')]")
    private WebElement password;
    @FindBy(xpath = "//button[@class = 'newlogindialog_SubmitButton_2QgFE' and contains(@type, 'submit')]")
    private WebElement enterButton;

    @FindBy(xpath = "//div[contains (text(), 'Пожалуйста, проверьте свой пароль и имя аккаунта и попробуйте снова.')]")
    private WebElement messageErrorLogin;

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getLogin() {
        return login;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getEnterButton() {
        return enterButton;
    }

    public WebElement getMessageErrorLogin() {
        return messageErrorLogin;
    }
}
