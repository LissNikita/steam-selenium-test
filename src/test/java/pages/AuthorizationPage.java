package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

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
        return errorMessage;
    }

    public AuthorizationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setLogin(String yourLogin) {
        WaitUtils.waitForVisibility(login);
        login.sendKeys(yourLogin);
    }

    public void setPassword(String yourPassword) {
        WaitUtils.waitForVisibility(password);
        password.sendKeys(yourPassword);
    }

    public void clickEnterButton() {
        WaitUtils.waitForVisibility(enterButton);
        enterButton.click();
    }

    public String getMessageUnsuccessfulLogin() {
        WaitUtils.waitForVisibility(messageErrorLogin);
        return messageErrorLogin.getText();
    }
}
