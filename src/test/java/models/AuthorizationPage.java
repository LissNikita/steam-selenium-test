package models;

import core.SetWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class AuthorizationPage extends SetWebDriver {

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
        return errorMessage;
    }

    public AuthorizationPage() {
        driver.get(Property.getPropertyValue("AUTHORIZATION_PAGE"));
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibility(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void setLogin(String yourLogin) {
        waitForVisibility(login);
        login.sendKeys(yourLogin);
    }

    public void setPassword(String yourPassword) {
        waitForVisibility(password);
        password.sendKeys(yourPassword);
    }

    public void clickEnterButton() {
        waitForVisibility(enterButton);
        enterButton.click();
    }

    public String getMessageUnsuccessfulLogin(){
        waitForVisibility(messageErrorLogin);
        return messageErrorLogin.getText();
    }
}
