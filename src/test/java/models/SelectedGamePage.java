package models;

import core.SetWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class SelectedGamePage extends SetWebDriver {

    @FindBy(id = "btn_add_to_cart_54029")
    private WebElement buttonAddToCart;
    @FindBy(id = "cart_link")
    private WebElement cart;
    @FindBy(xpath = "//h1[text() = 'Купить прайм-статус']")
    private WebElement primeStatus;
    @FindBy(xpath = "//div[contains(text(), '$14.99 USD')]")
    private WebElement priceOfProduct;
    private String priceValueOfProduct;
    private String productName;

    public String getPriceValueOfProduct() {
        return priceValueOfProduct;
    }

    public String productName() {
        return productName;
    }

    public SelectedGamePage() {
        driver.get(Property.getPropertyValue("SELECTED_GAME_PAGE"));
        PageFactory.initElements(driver, this);
    }

    public void waitForVisibility(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForClickable(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void clickOnTheButtonGameToCart() {
        waitForClickable(buttonAddToCart);
        buttonAddToCart.click();
    }

    public boolean checkACartIsDisplayed() {
        waitForVisibility(cart);
        return cart.isDisplayed();
    }

    public String getPrimeStatusText() {
        waitForVisibility(primeStatus);
        String[] correctValue = primeStatus.getText().split("Купить ");
        return productName = correctValue[1];
    }

    public String getPriceValueText() {
        waitForVisibility(priceOfProduct);
        String[] correctValue = priceOfProduct.getText().split(" USD");
        return priceValueOfProduct = correctValue[0];
    }
}
