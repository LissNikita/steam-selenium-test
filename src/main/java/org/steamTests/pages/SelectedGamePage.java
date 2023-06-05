package org.steamTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.steamTests.utils.WaitUtils;

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
        WaitUtils.waitForClickable(buttonAddToCart);
        buttonAddToCart.click();
    }

    public boolean checkACartIsDisplayed() {
        WaitUtils.waitForVisibility(cart);
        return cart.isDisplayed();
    }

    public String getPrimeStatusText() {
        WaitUtils.waitForVisibility(setNameOfProduct(productValue));
        String[] correctValue = primeStatus.getText().split("Купить ");
        return productName = correctValue[1];
    }

    public String getPriceValueText() {
        WaitUtils.waitForVisibility(setPriceOfProduct(valueOfPrice));
        String[] correctValue = priceOfProduct.getText().split(" USD");
        return priceValueOfProduct = correctValue[0];
    }
}
