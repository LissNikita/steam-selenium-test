package org.steamTests.steps;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.steamTests.pages.AuthorizationPage;
import org.steamTests.pages.MainPage;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class LoginStep {

    private MainPage mainPage;

    private AuthorizationPage authorizationPage;

    public LoginStep(WebDriver driver) {
        mainPage = new MainPage(driver);
        authorizationPage = new AuthorizationPage(driver);
    }

    ////////MAIN_PAGE_Step/////////////////////////////////////////////////////////////////////////
    public void clickLoginButton() {
        log.info("Click on login button");
        WaitUtils.waitForClickable(mainPage.getLoginButton());
        mainPage.getLoginButton().click();
    }

    public boolean successfulLogin() {
        log.info("Check, is login successful");
        WaitUtils.waitForVisibility(mainPage.getMessageButton());
        return mainPage.getMessageButton().isDisplayed();
    }

    public boolean loginButtonIsDisplayed() {
        log.info("Check, is login button displayed");
        WaitUtils.waitForVisibility(mainPage.getLoginButton());
        return mainPage.getLoginButton().isDisplayed();
    }

    ////////AUTHORIZATION_PAGE_Step/////////////////////////////////////////////////////////////////////////
    private final String errorMessage = "Пожалуйста, проверьте свой пароль и имя аккаунта и попробуйте снова.";

    public String getErrorMessage() {
        log.info("Get error message");
        return errorMessage;
    }

    public void setLogin(String yourLogin) {
        log.info("Set login");
        WaitUtils.waitForVisibility(authorizationPage.getLogin());
        authorizationPage.getLogin().sendKeys(yourLogin);
    }

    public void setPassword(String yourPassword) {
        log.info("Set password");
        WaitUtils.waitForVisibility(authorizationPage.getPassword());
        authorizationPage.getPassword().sendKeys(yourPassword);
    }

    public void clickEnterButton() {
        log.info("Click enter button");
        WaitUtils.waitForVisibility(authorizationPage.getEnterButton());
        authorizationPage.getEnterButton().click();
    }

    public String getMessageUnsuccessfulLogin() {
        log.info("Get message unsuccessful login");
        WaitUtils.waitForVisibility(authorizationPage.getMessageErrorLogin());
        return authorizationPage.getMessageErrorLogin().getText();
    }
}
