package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;

    private WebElement nameOfProduct;

    private WebElement priceOfProduct;

    public WebElement setPriceOfProduct(String valueOfPrice) {
        return priceOfProduct = driver.findElement(By.xpath("//div[contains(text(), '" + valueOfPrice + "')][1]"));
    }

    public WebElement setNameOfProduct(String productName) {
        return nameOfProduct = driver.findElement(By.xpath("//a[contains(text(), '" + productName + "')]"));
    }

    private String productNameForCompare;
    private String priceValueOfProductForCompare;

    public String getPriceValueOfProduct() {
        return priceValueOfProductForCompare;
    }

    public String productName() {
        return productNameForCompare;
    }

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getNameOfProduct() {
        WaitUtils.waitForVisibility(setNameOfProduct("прайм-статус"));
        return productNameForCompare = nameOfProduct.getText();
    }

    public String getPrice() {
        WaitUtils.waitForVisibility(setPriceOfProduct("$14.99"));
        return priceValueOfProductForCompare = priceOfProduct.getText();
    }
}
