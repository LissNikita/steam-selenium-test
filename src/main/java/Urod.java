
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Urod {

    private static final String URL = "https://aviso.bz/";
    private static final String LOGIN = "dragonlisov";
    private static final String PASSWORD = "lisovdragon1999";
    private static SelenideElement timeForWatchingText = $x("//*[@class = 'go-link-youtube']/ancestor::div//span[@class='serf-text']");

    public static void main(String[] args) {
        Selenide.open(URL);
        login();
        navigateToEarnYoutube();
        workWithLinks();
    }

    public static void login(){
        SelenideElement loginButton = $x("//a[contains(@class, 'button-login')]");
        SelenideElement login = $x("//input[@name = 'username']");
        SelenideElement password = $x("//input[@name = 'password']");
        SelenideElement authorizationButton = $x("//button[@id = 'button-login']");

        loginButton.click();
        login.sendKeys(LOGIN);
        password.sendKeys(PASSWORD);
        authorizationButton.click();
        Selenide.sleep(3000);
    }

    public static void navigateToEarnYoutube(){
        SelenideElement ernButton = $x("//*[@id = 'mnu_title1']");
        SelenideElement enrFromYouTubeButton = $x("//a[text() = 'YouTube']");
        //SelenideElement expTasks = $x("//a[text() = 'Дорогие']");

        ernButton.click();
        enrFromYouTubeButton.click();
        //expTasks.click();
    }

    public static void workWithLinks(){
        SelenideElement firstButtonForOpenLink = $x("//*[contains(@id,'start-ads')]/span[1]");
        SelenideElement linkForYouTubeVideoButton = $x("//*[@class = 'go-link-youtube']");
        SelenideElement enrFromYouTubeButton = $x("//a[text() = 'YouTube']");
        //SelenideElement timeForWatchingText = $x("//*[@class = 'go-link-youtube']/ancestor::div//span[@class='serf-text']");
        //SelenideElement startVideoButton = $x("//div[@class = 'ytp-cued-thumbnail-overlay']");


        while (true) {
//            Selenide.refresh();
//            Selenide.sleep(2000);
            enrFromYouTubeButton.click();
            Selenide.sleep(2000);
            if (firstButtonForOpenLink.isDisplayed()) {
                firstButtonForOpenLink.scrollTo().click();
                SelenideElement errorLink = $x("//span[@class = 'youtube-error']");
                Selenide.sleep(2000);
                if(errorLink.isDisplayed()){
                    Selenide.refresh();
                    Selenide.sleep(3000);
                }else {
                    if (linkForYouTubeVideoButton.scrollTo().isDisplayed() && linkForYouTubeVideoButton.getCssValue("background").contains("rgb(96, 138, 185)")) {
                        int timeWaiting = timeForWaiting();
                        linkForYouTubeVideoButton.click();
                        Selenide.switchTo().window(1);
                        SelenideElement table = $x("//*[@id='start-video']/tbody/tr[2]/td");
                        SelenideElement timerInVideo = $x("//*[contains(@class, 'timer')]");
                        //SelenideElement pageIdForError = $x("//body[contains(@id, 'page')]");
                        //SelenideElement errorInVideo = $x("//div[@class = 'ytp-error-icon-container']");

                        Selenide.sleep(3000);
                        //WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(3));
                        if (!table.isDisplayed()) {
                            //if (Selenide.switchTo().frame("video-start").findElement(By.xpath("//div[@class = 'ytp-error-icon-container']")).isDisplayed()){
//                    if(Selenide.switchTo().frame("video-start").findElement(By.xpath("//div[@class = 'ytp-error-icon-container']")).isDisplayed()){
                            switchTo().window(getWebDriver().getWindowHandle()).close();
                            switchTo().window(0);
                            Selenide.refresh();
                            Selenide.sleep(2000);
                        } else {
                            table.scrollTo().click();
                            Selenide.sleep(timeWaiting);
                            if (timerInVideo.isDisplayed()) {
                                table.scrollTo().click();
                                Selenide.sleep(5000);
                                switchTo().window(getWebDriver().getWindowHandle()).close();
                                switchTo().window(0);
                                Selenide.refresh();
                            } else {
                                switchTo().window(getWebDriver().getWindowHandle()).close();
                                switchTo().window(0);
                                Selenide.refresh();
                            }
                        }
                    } else {
                        Selenide.refresh();
                        firstButtonForOpenLink.scrollTo().click();
                        int timeWaiting = timeForWaiting();
                        linkForYouTubeVideoButton.click();
                        Selenide.switchTo().window(1);
                        SelenideElement table = $x("//*[@id='start-video']/tbody/tr[2]/td");
                        Selenide.sleep(3000);
                        table.scrollTo().click();
                        Selenide.sleep(timeWaiting);
                        switchTo().window(getWebDriver().getWindowHandle()).close();
                        switchTo().window(0);
                        Selenide.refresh();
                    }
                }
            } else {
                Selenide.sleep(10000);
                enrFromYouTubeButton.click();
                Selenide.refresh();
            }
        }
    }

    public static int timeForWaiting(){
        if (timeForWatchingText.getText().contentEquals("10 сек   ")) {
            return 14000;
        } else if (timeForWatchingText.getText().contentEquals("15 сек   ")) {
            return 19000;
        } else if (timeForWatchingText.getText().contains("20")) {
            if(timeForWatchingText.getText().contains("1")){
                return 124000;
            }else {
                return 24000;
            }
        } else if (timeForWatchingText.getText().contains("25")) {
            if(timeForWatchingText.getText().contains("0")){
                return 254000;
            }else {
                return 29000;
            }
        } else if (timeForWatchingText.getText().contentEquals("300 сек   ")) {
            return 340000;
        } else if (timeForWatchingText.getText().contentEquals("30 сек   ")) {
            return 34000;
        } else if (timeForWatchingText.getText().contentEquals("35 сек   ")) {
            return 39000;
        }else if (timeForWatchingText.getText().contentEquals("45 сек   ")) {
            return 49000;
        }else if (timeForWatchingText.getText().contentEquals("55 сек   ")) {
            return 59000;
        }else if (timeForWatchingText.getText().contentEquals("50 сек   ")) {
            return 54000;
        }else if (timeForWatchingText.getText().contentEquals("65 сек   ")) {
            return 69000;
        }else if (timeForWatchingText.getText().contentEquals("60 сек   ")) {
            return 64000;
        }else if (timeForWatchingText.getText().contentEquals("70 сек   ")) {
            return 74000;
        }else if (timeForWatchingText.getText().contentEquals("75 сек   ")) {
            return 79000;
        }else if (timeForWatchingText.getText().contains("80")) {
            if(timeForWatchingText.getText().contains("1")){
                return 184000;
            }else {
                return 84000;
            }
        }else if (timeForWatchingText.getText().contentEquals("85 сек   ")) {
            return 89000;
        }else if (timeForWatchingText.getText().contentEquals("90 сек   ")) {
            return 94000;
        }else if (timeForWatchingText.getText().contentEquals("95 сек   ")) {
            return 99000;
        }else if (timeForWatchingText.getText().contentEquals("105 сек   ")) {
            return 109000;
        }else if (timeForWatchingText.getText().contentEquals("110 сек   ")) {
            return 114000;
        }else if (timeForWatchingText.getText().contentEquals("115 сек   ")) {
            return 119000;
        }else if (timeForWatchingText.getText().contentEquals("125 сек   ")) {
            return 129000;
        }else if (timeForWatchingText.getText().contentEquals("130 сек   ")) {
            return 134000;
        }else if (timeForWatchingText.getText().contentEquals("135 сек   ")) {
            return 139000;
        }else if (timeForWatchingText.getText().contentEquals("140 сек   ")) {
            return 144000;
        }else if (timeForWatchingText.getText().contains("40")) {
            if(timeForWatchingText.getText().contains("2")) {
                return 245000;
            }else {
                return 44000;
            }
        } else if (timeForWatchingText.getText().contains("499")) {
            return 506000;
        }else {
            return 14000;
        }
    }
}