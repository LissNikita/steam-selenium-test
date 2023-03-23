package pageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AfterTestingMethods {


    @AfterTest
    public void closeDriver(WebDriver driver){
        driver.quit();
    }
}
