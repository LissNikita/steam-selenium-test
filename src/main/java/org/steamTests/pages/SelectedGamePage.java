package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.WaitUtils;

@Log4j2
public class SelectedGamePage {

    private WebDriver driver;

    private final String productValue = "Купить прайм-статус";
    private final String valueOfPrice = "$14.99 USD";

    @FindBy(id = "btn_add_to_cart_54029")
    private WebElement buttonAddToCart;
    @FindBy(id = "cart_link")
    private WebElement cart;

    private WebElement primeStatus;
    private WebElement priceOfProduct;

    private String priceValueOfProduct;
    private String productName;

    public WebElement setPriceOfProduct(String valueOfPrice) {
        return priceOfProduct = driver.findElement(By.xpath("//div[contains(text(), '" + valueOfPrice + "')]"));
    }

    public WebElement setNameOfProduct(String productName) {
        return primeStatus = driver.findElement(By.xpath("//h1[text() = '" + productName + "']"));
    }

    public String getPriceValueOfProduct() {
        return priceValueOfProduct;
    }

    public String productName() {
        return productName;
    }

    public SelectedGamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnTheButtonGameToCart() {
        log.info("Сlick on the button to add the game to the cart");
        WaitUtils.waitForClickable(buttonAddToCart);
        buttonAddToCart.click();
    }

    public boolean checkACartIsDisplayed() {
        log.info("Check, is cart displayed");
        WaitUtils.waitForVisibility(cart);
        return cart.isDisplayed();
    }

    public String getPrimeStatusText() {
        log.info("Get text of product name");
        WaitUtils.waitForVisibility(setNameOfProduct(productValue));
        String[] correctValue = primeStatus.getText().split("Купить ");
        return productName = correctValue[1];
    }

    public String getPriceValueText() {
        log.info("Get text of product price");
        WaitUtils.waitForVisibility(setPriceOfProduct(valueOfPrice));
        String[] correctValue = priceOfProduct.getText().split(" USD");
        return priceValueOfProduct = correctValue[0];
    }
}
