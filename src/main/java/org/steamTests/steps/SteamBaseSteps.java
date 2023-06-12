package org.steamTests.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.steamTests.pages.*;
import org.steamTests.utils.EditTextUtils;
import org.steamTests.utils.Property;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class SteamBaseSteps {

    private ShopPage shopPage;
    private MainPage mainPage;
    private GameListPage gameListPage;
    private CartPage cartPage;
    private AboutPage aboutPage;

    public SteamBaseSteps(WebDriver driver) {
        shopPage = new ShopPage(driver);
        mainPage = new MainPage(driver);
        gameListPage = new GameListPage(driver);
        cartPage = new CartPage(driver);
        aboutPage = new AboutPage(driver);
    }

    ///////////SHOP_PAGE_Step//////////////////////////////////////////////////////////////////////
    @Step("Check, is shop page open")
    public boolean checkShopPageIsOpened() {
        log.info("Check, is shop page open");
        WaitUtils.waitForVisibility(shopPage.getSomethingGame());
        return shopPage.getSomethingGame().isDisplayed();
    }

    @Step("Set games search")
    public void setGamesSearch(String yourGame) {
        log.info("Set games search");
        WaitUtils.waitForVisibility(shopPage.getSomethingGame());
        shopPage.getSomethingGame().sendKeys(yourGame, Keys.ENTER);
    }

    /////MAIN_PAGE_Step/////////////////////////////////////////////////////////////////////////
    public void clickAboutButton() {
        log.info("Click on about button");
        WaitUtils.waitForClickable(mainPage.getAboutButton());
        mainPage.getAboutButton().click();
    }

    ////////GAME_LIST_PAGE_Step/////////////////////////////////////////////////////////////////////////
    public void selectGame() {
        log.info("Select game");
        WaitUtils.waitForClickable(gameListPage.getSomethingGame());
        log.info("The game (" + Property.getPropertyValue("GAME_NAME") + ") was found!");
        gameListPage.getSomethingGame().click();
    }

    ////////CART_PAGE_Step/////////////////////////////////////////////////////////////////////////
    public void clickOnProfileButton() {
        log.info("Click on profile button");
        WaitUtils.waitForClickable(cartPage.getButtonOfYourProfile());
        cartPage.getButtonOfYourProfile().click();
    }

    public void clickLogOut() {
        log.info("Click on logOut button");
        WaitUtils.waitForClickable(cartPage.getButtonLogOut());
        cartPage.getButtonLogOut().click();
    }

    ////////ABOUT_PAGE_Step/////////////////////////////////////////////////////////////////////////
    public int getValuePeopleOnline() {
        log.info("Get value people online");
        WaitUtils.waitForVisibility(aboutPage.getValuePeopleOnline());
        String getOnline = aboutPage.getValuePeopleOnline().getText();
        String[] deletedText = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(getOnline, "В СЕТИ");
        String[] deletedPunctuations = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
        for (String divideText : deletedPunctuations) {
            EditTextUtils
                    .sumOfPlayersOnline()
                    .append(divideText);
        }
        return EditTextUtils
                .createdFromStringIntoInt(EditTextUtils.getSumOnline());
    }

    public int getValuePeopleInGames() {
        log.info("Get value people in games");
        WaitUtils.waitForVisibility(aboutPage.getValuePeopleInGames());
        String getTextValuePeopleInGames = aboutPage.getValuePeopleInGames().getText();
        String[] deletedText = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(getTextValuePeopleInGames, "В ИГРЕ");
        String[] deletedPunctuations = EditTextUtils.splitTextForPeopleOnlineAndPeopleInGames(deletedText[1], ",");
        for (String divideText : deletedPunctuations) {
            EditTextUtils
                    .sumOfPlayersInGames()
                    .append(divideText);
        }
        return EditTextUtils
                .createdFromStringIntoInt(EditTextUtils.getSumInGames());
    }

    public boolean comparePeopleOnlineAndPeopleInGames() {
        log.info("Compare people online and people in games");
        return getValuePeopleInGames() < getValuePeopleOnline();
    }

    public void clickOnShop() {
        log.info("Click on shop");
        WaitUtils.waitForVisibility(aboutPage.getShopButton());
        aboutPage.getShopButton().click();
    }
}
