package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;

public class SelectedGamePage {

    private WebDriver driver;

    @FindBy(id = "btn_add_to_cart_54029")
    private WebElement buttonAddToCart;
    @FindBy(id = "cart_link")
    private WebElement cart;
    @FindBy(xpath = "//h1[text() = 'Купить прайм-статус']")
    private WebElement primeStatus;
    @FindBy(xpath = "//div[contains(text(), '$14.99 USD')]")///////////////////////////
    private WebElement priceOfProduct;
    private String priceValueOfProduct;
    private String productName;

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
        WaitUtils.waitForVisibility(primeStatus);
        String[] correctValue = primeStatus.getText().split("Купить ");
        return productName = correctValue[1];
    }

    public String getPriceValueText() {
        WaitUtils.waitForVisibility(priceOfProduct);
        String[] correctValue = priceOfProduct.getText().split(" USD");
        return priceValueOfProduct = correctValue[0];
    }
}
