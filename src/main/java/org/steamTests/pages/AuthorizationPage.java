package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.WaitUtils;

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

    private String errorMessage = "Пожалуйста, проверьте свой пароль и имя аккаунта и попробуйте снова.";

    public String getErrorMessage() {
        log.info("Get error message");
        return errorMessage;
    }

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setLogin(String yourLogin) {
        log.info("Set login");
        WaitUtils.waitForVisibility(login);
        login.sendKeys(yourLogin);
    }

    public void setPassword(String yourPassword) {
        log.info("Set password");
        WaitUtils.waitForVisibility(password);
        password.sendKeys(yourPassword);
    }

    public void clickEnterButton() {
        log.info("Click enter button");
        WaitUtils.waitForVisibility(enterButton);
        enterButton.click();
    }

    public String getMessageUnsuccessfulLogin() {
        log.info("Get message unsuccessful login");
        WaitUtils.waitForVisibility(messageErrorLogin);
        return messageErrorLogin.getText();
    }
}
