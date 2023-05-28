package models;

import core.SetWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectedGamePage extends SetWebDriver {

    private WebElement buttonAddToCart;

    private WebElement cart;

    private WebElement primeStatus;

    private WebElement priceOfProduct;

    private String priceValueOfShop;

    private String productName;

    public String getPriceValueOfShop() {
        return priceValueOfShop;
    }

    public String productName() {
        return productName;
    }

    public WebDriverWait createNewWebDriverWaitElement() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickOnTheButtonGameToCart() {
        buttonAddToCart = createNewWebDriverWaitElement().until(ExpectedConditions.elementToBeClickable(By.id("btn_add_to_cart_54029")));
        buttonAddToCart.click();
    }

    public boolean checkACartIsDisplayed() {
        cart = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.id("cart_link")));
        return cart.isDisplayed();
    }

    public String getPrimeStatusText() {
        primeStatus = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text() = 'Купить прайм-статус']")));
        String[] correctValue = primeStatus.getText().split("Купить ");
        return productName = correctValue[1];
    }

    public String getPriceValue() {
        priceOfProduct = createNewWebDriverWaitElement().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '$14.99 USD')]")));
        String[] correctValue = priceOfProduct.getText().split(" USD");
        return priceValueOfShop = correctValue[0];
    }
}
