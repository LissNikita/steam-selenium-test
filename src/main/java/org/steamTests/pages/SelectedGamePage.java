package org.steamTests.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class SelectedGamePage {

    private WebDriver driver;

    @FindBy(id = "btn_add_to_cart_54029")
    private WebElement buttonAddToCart;
    @FindBy(id = "cart_link")
    private WebElement cart;

    public SelectedGamePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebElement setPriceOfProduct(String valueOfPrice) {
        return driver.findElement(By.xpath("//div[contains(text(), '" + valueOfPrice + "')]"));
    }

    public WebElement setNameOfProduct(String productName) {
        return driver.findElement(By.xpath("//h1[text() = '" + productName + "']"));
    }

    public WebElement getButtonAddToCart() {
        return buttonAddToCart;
    }

    public WebElement getCart() {
        return cart;
    }
}
