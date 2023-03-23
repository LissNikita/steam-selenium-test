import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageobjects.*;

import java.util.Objects;
import java.util.Properties;

public class SteamTest {

    public static WebDriver driver;

    @Test
    public void testOpenSteamCompareHowManyPeopleOnlineAndInGames() {



//        WebDriver driver = new ChromeDriver();

//        AboutPage aboutPage = new AboutPage();
//        ShopPage shopPage = new ShopPage();
         System.setProperty(Objects.requireNonNull(Browser.returnInfoAboutKeys()), Objects.requireNonNull(Browser.returnInfoAboutWayToDriver()));
         driver = Browser.returnInfoAboutDriver();



            MainPage mainPage = new MainPage(driver);
            AboutPage aboutPage = new AboutPage(driver);
            ShopPage shopPage = new ShopPage(driver);


            mainPage.open();

            Assert.assertTrue(mainPage.isDisplayed(), "Main page is not opened");

            mainPage.clickAboutButton();
            Assert.assertTrue(aboutPage.isDisplayed(), "About page is not opened");

           // Assert.assertTrue(aboutPage.compareOnlinePeopleAndInGamesPeople(), "People in game >= than people online");

            Assert.assertTrue(aboutPage.checkMonitorVideoGradientIsDisplayed(), "The button is absent!");
            aboutPage.clickOnShop();

            Assert.assertTrue(shopPage.checkShopPageIsOpened(), "Shop page is not opened");
















//        WebElement open1 = driver.findElement(By.xpath("//a[normalize-space(text()) = 'О STEAM']"));
//
//        WebElement wait = (new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(text()) = 'О STEAM']"))));
//
//        System.out.println("Screen opened : " + open1.isDisplayed());
//        System.out.println();
//
//        open1.click();
//
//        WebElement openAbout = driver.findElement(By.xpath("//div[@class = 'about_subtitle'][1]"));
//        System.out.println("Screen with ABOUT is opened: " + openAbout.isDisplayed());
//
//        System.out.println();
//
//        // тут онлайн и в игре чекаем покемонов
//        WebElement readHowManyPeopleOnline = driver.findElement(By.xpath("//div[@class = 'online_stat_label gamers_online']/parent::div"));
//        String getOnline = readHowManyPeopleOnline.getText();
//        String[] renderOnline = getOnline.split("В СЕТИ");
//        String[] withoutOnline = renderOnline[1].split(",");
//        String sumOnline = "";
//        for (String a : withoutOnline) {
//            sumOnline = sumOnline + a;
//        }
//        int onlineINT = Integer.parseInt(sumOnline.trim());
//        System.out.println("How many people Online : " + onlineINT);
//
//        WebElement readHowManyPeoplePlayNow = driver.findElement(By.xpath("//div[@class = 'online_stat_label gamers_in_game']/parent::div"));
//        String getPlayNow = readHowManyPeoplePlayNow.getText();
//        String[] renderInGame = getPlayNow.split("В ИГРЕ");
//        String[] withoutInGame = renderInGame[1].split(",");
//        String sumInGame = "";
//        for (String b : withoutInGame) {
//            sumInGame = sumInGame + b;
//        }
//        int ingameINT = Integer.parseInt(sumInGame.trim());
//
//        System.out.println("How many people Play right now : " + ingameINT);
//
//        System.out.println();
//
//
//        System.out.println("People in game < People online?");
//        if (ingameINT < onlineINT) {
//            System.out.println("Everything okey!");
//        } else {
//            System.out.println("Something  wrong!");
//        }
//        System.out.println();
//
//// Тут мы кликаем на Shop
//        WebElement shop = driver.findElement(By.xpath("//a[normalize-space(text()) = 'МАГАЗИН']"));
//        shop.click();
//
//        WebElement mainpage = driver.findElement(By.xpath("//div[@class = 'home_cluster_ctn home_ctn']"));
//        System.out.println("The shop is opened : " + mainpage.isDisplayed());
//

//        driver.quit();

    }
    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
}
