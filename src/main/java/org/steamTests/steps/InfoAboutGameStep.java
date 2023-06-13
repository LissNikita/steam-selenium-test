package org.steamTests.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.steamTests.pages.CartPage;
import org.steamTests.pages.SelectedGamePage;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class InfoAboutGameStep {

    private SelectedGamePage selectedGamePage;
    private CartPage cartPage;

    public InfoAboutGameStep(WebDriver driver) {
        selectedGamePage = new SelectedGamePage(driver);
        cartPage = new CartPage(driver);
    }

    ////////SELECT_GAME_PAGE_Step////////////////////////////////////////////////////////////////
    private final String NAME_OF_PRODUCT = "Купить прайм-статус";
    private final String VALUE_OF_PRICE = "$14.99 USD";

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

    @Step("Get text of product name")
    public String getPrimeStatusText() {
        log.info("Get text of product name");
        WaitUtils.waitForVisibility(selectedGamePage.setNameOfProduct(NAME_OF_PRODUCT));
        String[] correctValue = selectedGamePage.setNameOfProduct(NAME_OF_PRODUCT).getText().split("Купить ");
        return productName = correctValue[1];
    }

    @Step("Get text of product price")
    public String getPriceValueText() {
        log.info("Get text of product price");
        WaitUtils.waitForVisibility(selectedGamePage.setPriceOfProduct(VALUE_OF_PRICE));
        String[] correctValue = selectedGamePage.setPriceOfProduct(VALUE_OF_PRICE).getText().split(" USD");
        return priceValueOfProduct = correctValue[0];
    }

    ////////CART_PAGE_Step/////////////////////////////////////////////////////////////////////////
    private final String PRODUCT_NAME_IN_CART = "прайм-статус";
    private final String PRODUCT_PRICE_IN_CART = "$14.99";

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
        WaitUtils.waitForVisibility(cartPage.setNameOfProductInCart(PRODUCT_NAME_IN_CART));
        return productNameForCompareInCart = cartPage.setNameOfProductInCart(PRODUCT_NAME_IN_CART).getText();
    }

    public String getPriceInCart() {
        log.info("Get price of product in cart");
        WaitUtils.waitForVisibility(cartPage.setPriceOfProductInCart(PRODUCT_PRICE_IN_CART));
        return priceValueOfProductForCompareInCart = cartPage.setPriceOfProductInCart(PRODUCT_PRICE_IN_CART).getText();
    }
}
