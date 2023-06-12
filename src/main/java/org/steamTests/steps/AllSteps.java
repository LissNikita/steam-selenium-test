package org.steamTests.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.steamTests.pages.*;
import org.steamTests.utils.EditTextUtils;
import org.steamTests.utils.Property;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class AllSteps {

    private ShopPage shopPage;
    private SelectedGamePage selectedGamePage;
    private MainPage mainPage;
    private GameListPage gameListPage;
    private CartPage cartPage;
    private AuthorizationPage authorizationPage;
    private AboutPage aboutPage;

    public AllSteps(WebDriver driver) {
        shopPage = new ShopPage(driver);
        selectedGamePage = new SelectedGamePage(driver);
        mainPage = new MainPage(driver);
        gameListPage = new GameListPage(driver);
        cartPage = new CartPage(driver);
        authorizationPage = new AuthorizationPage(driver);
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

////////SELECT_GAME_PAGE_Step////////////////////////////////////////////////////////////////

    private final String nameOfProduct = "Купить прайм-статус";
    private final String valueOfPrice = "$14.99 USD";

    private String priceValueOfProduct;
    private String productName;

    public String getPriceValueOfProduct() {
        return priceValueOfProduct;
    }

    public String getProductName() {
        return productName;
    }

    @Step("Click on the button to add the game to the cart")
    public void clickOnTheButtonGameToCart() {
        log.info("Click on the button to add the game to the cart");
        WaitUtils.waitForClickable(selectedGamePage.getButtonAddToCart());
        selectedGamePage.getButtonAddToCart().click();
    }

    @Step("Check, is cart displayed")
    public boolean checkACartIsDisplayed() {
        log.info("Check, is cart displayed");
        WaitUtils.waitForVisibility(selectedGamePage.getCart());
        return selectedGamePage.getCart().isDisplayed();
    }

    @Step("Get text of product name")
    public String getPrimeStatusText() {
        log.info("Get text of product name");
        WaitUtils.waitForVisibility(selectedGamePage.setNameOfProduct(nameOfProduct));
        String[] correctValue = selectedGamePage.setNameOfProduct(nameOfProduct).getText().split("Купить ");
        return productName = correctValue[1];
    }

    @Step("Get text of product price")
    public String getPriceValueText() {
        log.info("Get text of product price");
        WaitUtils.waitForVisibility(selectedGamePage.setPriceOfProduct(valueOfPrice));
        String[] correctValue = selectedGamePage.setPriceOfProduct(valueOfPrice).getText().split(" USD");
        return priceValueOfProduct = correctValue[0];
    }
////////MAIN_PAGE_Step/////////////////////////////////////////////////////////////////////////

    public boolean isDisplayed() {
        log.info("Check, Is slider displayed");
        WaitUtils.waitForVisibility(mainPage.getSliderWithNewGames());
        return mainPage.getSliderWithNewGames().isDisplayed();
    }

    public void clickAboutButton() {
        log.info("Click on about button");
        WaitUtils.waitForClickable(mainPage.getAboutButton());
        mainPage.getAboutButton().click();
    }

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

    ////////GAME_LIST_PAGE_Step/////////////////////////////////////////////////////////////////////////
    public void selectGame() {
        log.info("Select game");
        WaitUtils.waitForClickable(gameListPage.getSomethingGame());
        log.info("The game (" + Property.getPropertyValue("GAME_NAME") + ") was found!");
        gameListPage.getSomethingGame().click();
    }

    ////////CART_PAGE_Step/////////////////////////////////////////////////////////////////////////

    private final String productNameInCart = "прайм-статус";
    private final String productPriceInCart = "$14.99";

    private String productNameForCompareInCart;
    private String priceValueOfProductForCompareInCart;

    public String getPriceValueOfProductInCart() {
        return priceValueOfProductForCompareInCart;
    }

    public String getProductNameInCart() {
        return productNameForCompareInCart;
    }

    public String getNameOfProductInCart() {
        log.info("Get name of product in cart");
        WaitUtils.waitForVisibility(cartPage.setNameOfProductInCart(productNameInCart));
        return productNameForCompareInCart = cartPage.setNameOfProductInCart(productNameInCart).getText();
    }

    public String getPriceInCart() {
        log.info("Get price of product in cart");
        WaitUtils.waitForVisibility(cartPage.setPriceOfProductInCart(productPriceInCart));
        return priceValueOfProductForCompareInCart = cartPage.setPriceOfProductInCart(productPriceInCart).getText();
    }

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
