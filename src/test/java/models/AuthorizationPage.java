package models;

import core.SetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage extends SetWebDriver {

    private WebElement enterButton;

    private WebElement login;

    private WebElement password;

    public WebDriverWait createNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setLogin(String yourLogin) {
        login = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text' and contains (@class, 'newlogindialog_TextInput_2eKVn')]")));
        login.sendKeys(yourLogin);
    }

    public void setPassword(String yourPassword) {
        password = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password' and contains (@class, 'newlogindialog_TextInput_2eKVn')]")));
        password.sendKeys(yourPassword);
    }

    public void clickEnterButton() {
        enterButton = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'newlogindialog_SubmitButton_2QgFE' and contains(@type, 'submit')]")));
        enterButton.click();
    }
}
