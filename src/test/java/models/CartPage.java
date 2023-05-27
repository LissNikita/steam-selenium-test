package models;

import core.SetWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends SetWebDriver {

    @FindBy(xpath = "//a[contains(text(), 'прайм-статус')]")
    private WebElement nameOfProduct;

    @FindBy(xpath = "//div[contains(text(), '$14.99')][1]")
    private WebElement priceOfProduct;

    private String productName;
    private String priceValue;

    public String getPriceValue() {
        return priceValue;
    }

    public String productName() {
        return productName;
    }

    private void waitForVisibility(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public CartPage() {
        driver.get("https://store.steampowered.com/cart/");
        PageFactory.initElements(driver, this);
    }

    public String getNameOfProduct(){
        waitForVisibility(nameOfProduct);
        return productName = nameOfProduct.getText();
    }

    public String getPrice(){
        waitForVisibility(priceOfProduct);
        return  priceValue = priceOfProduct.getText();
    }
}
