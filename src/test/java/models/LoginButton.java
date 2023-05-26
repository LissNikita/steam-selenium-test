package models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class LoginButton {

    private final WebDriver driver;
    private WebElement loginButton;

    private WebElement enterButton;

    private WebElement messageButton;

    private WebElement login;

    private WebElement password;

    public LoginButton(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriverWait createNewWebDriverWaitElement(){
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isDisplayed(){
        loginButton = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='global_action_link']")));
        return loginButton.isDisplayed();
    }

    public void clickLoginButton(){
        loginButton = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='global_action_link']")));
        loginButton.click();
    }

    public void setLogin(String yourLogin){
        login = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text' and contains (@class, 'newlogindialog_TextInput_2eKVn')]")));
        login.sendKeys(yourLogin);
    }

    public void setPassword(String yourPassword){
        password = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password' and contains (@class, 'newlogindialog_TextInput_2eKVn')]")));
        password.sendKeys(yourPassword);
    }

    public void clickEnterButton(){
        enterButton = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'newlogindialog_SubmitButton_2QgFE' and contains(@type, 'submit')]")));
        enterButton.click();
    }

    public boolean successfulLogin(){
        messageButton = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='header_notification_link']")));
        return messageButton.isDisplayed();
    }
}
