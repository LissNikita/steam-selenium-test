package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class CartPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[contains(text(), 'прайм-статус')]")
    private WebElement nameOfProduct;

    @FindBy(xpath = "//div[contains(text(), '$14.99')][1]")
    private WebElement priceOfProduct;

//    public WebElement getPriceOfProduct(String sumOfPrice){
//        return priceOfProduct = driver.findElement(By.xpath("//div[contains(text(), '" + sumOfPrice + "')][1]'"));
//    }

    private String productName;
    private String priceValueOfProduct;

    public String getPriceValueOfProduct() {
        return priceValueOfProduct;
    }

    public String productName() {
        return productName;
    }

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getNameOfProduct() {
        WaitUtils.waitForVisibility(nameOfProduct);
        return productName = nameOfProduct.getText();
    }

    public String getPrice() {
        WaitUtils.waitForVisibility(priceOfProduct);
        return priceValueOfProduct = priceOfProduct.getText();
    }
}
