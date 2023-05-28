package models;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import core.SetWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Property;

import java.time.Duration;

public class CartPage extends SetWebDriver {

    @FindBy(xpath = "//a[contains(text(), 'прайм-статус')]")
    private WebElement nameOfProduct;

    @FindBy(xpath = "//div[contains(text(), '$14.99')][1]")
    private WebElement priceOfProduct;

    private String productName;
    private String priceValueOfProduct;

    public String getPriceValueOfProduct() {
        return priceValueOfProduct;
    }

    public String productName() {
        return productName;
    }

    private void waitForVisibility(WebElement webElement) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public CartPage() {
        driver.get(Property.getPropertyValue("CART_PAGE"));
        PageFactory.initElements(driver, this);
    }

    public String getNameOfProduct() {
        waitForVisibility(nameOfProduct);
        return productName = nameOfProduct.getText();
    }

    public String getPrice() {
        waitForVisibility(priceOfProduct);
        return priceValueOfProduct = priceOfProduct.getText();
    }
}
