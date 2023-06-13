package org.steamTests.utils;

import org.steamTests.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static void waitForVisibility(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForClickable(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
