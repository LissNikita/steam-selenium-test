
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
    private static final String LOGIN = "";
    private static final String PASSWORD = "";
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

        ernButton.click();
        enrFromYouTubeButton.click();
    }

    public static void workWithLinks(){
        SelenideElement firstButtonForOpenLink = $x("//*[contains(@id,'start-ads')]/span[1]");
        SelenideElement linkForYouTubeVideoButton = $x("//*[@class = 'go-link-youtube']");
        SelenideElement enrFromYouTubeButton = $x("//a[text() = 'YouTube']");
        //SelenideElement timeForWatchingText = $x("//*[@class = 'go-link-youtube']/ancestor::div//span[@class='serf-text']");
        //SelenideElement startVideoButton = $x("//div[@class = 'ytp-cued-thumbnail-overlay']");


        while (true) {
            Selenide.refresh();
            enrFromYouTubeButton.click();
            Selenide.sleep(2000);
            if (firstButtonForOpenLink.isDisplayed()) {
                firstButtonForOpenLink.scrollTo().click();
                SelenideElement errorLink = $x("//span[@class = 'youtube-error']");
                Selenide.sleep(2000);
                if(errorLink.isDisplayed()){
                    Selenide.refresh();
                }else {
                    if (linkForYouTubeVideoButton.scrollTo().isDisplayed() && linkForYouTubeVideoButton.getCssValue("background").contains("rgb(96, 138, 185)")) {
                        int timeWaiting = timeForWaiting();
                        linkForYouTubeVideoButton.click();
                        Selenide.switchTo().window(1);
                        SelenideElement table = $x("//*[@id='start-video']/tbody/tr[2]/td");
                        SelenideElement timerInVideo = $x("//*[contains(@class, 'timer')]");
                        SelenideElement pageIdForError = $x("//body[contains(@id, 'page')]");
                        //SelenideElement errorInVideo = $x("//div[@class = 'ytp-error-icon-container']");

                        Selenide.sleep(3000);
                        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(3));
                        boolean a = !wait.until(ExpectedConditions.elementToBeClickable(table)).isEnabled();
                        if (a) {
                            //if (Selenide.switchTo().frame("video-start").findElement(By.xpath("//div[@class = 'ytp-error-icon-container']")).isDisplayed()){
//                    if(Selenide.switchTo().frame("video-start").findElement(By.xpath("//div[@class = 'ytp-error-icon-container']")).isDisplayed()){
                            switchTo().window(getWebDriver().getWindowHandle()).close();
                            switchTo().window(0);
                            Selenide.refresh();
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
                Selenide.sleep(60000);
                enrFromYouTubeButton.click();
                Selenide.refresh();
            }
        }
    }

    public static int timeForWaiting(){
        if (timeForWatchingText.getText().contains("10")) {
            return 14000;
        } else if (timeForWatchingText.getText().contains("15")) {
            return 19000;
        } else if (timeForWatchingText.getText().contains("20")) {
            if(timeForWatchingText.getText().contains("1")){
                return 124000;
            }else {
                return 24000;
            }
        } else if (timeForWatchingText.getText().contains("25")) {
            return 29000;
        } else if (timeForWatchingText.getText().contentEquals("300 сек   ")) {
            return 304000;
        } else if (timeForWatchingText.getText().contentEquals("30 сек   ")) {
            return 34000;
        } else if (timeForWatchingText.getText().contains("35")) {
            return 39000;
        }else if (timeForWatchingText.getText().contains("45")) {
            return 49000;
        }else if (timeForWatchingText.getText().contains("55")) {
            return 59000;
        }else if (timeForWatchingText.getText().contains("50")) {
            return 54000;
        }else if (timeForWatchingText.getText().contains("65")) {
            return 69000;
        }else if (timeForWatchingText.getText().contains("60")) {
            return 64000;
        }else if (timeForWatchingText.getText().contains("70")) {
            return 74000;
        }else if (timeForWatchingText.getText().contains("75")) {
            return 79000;
        }else if (timeForWatchingText.getText().contains("80")) {
            if(timeForWatchingText.getText().contains("1")){
                return 184000;
            }else {
                return 84000;
            }
        }else if (timeForWatchingText.getText().contains("85")) {
            return 89000;
        }else if (timeForWatchingText.getText().contains("90")) {
            return 94000;
        }else if (timeForWatchingText.getText().contains("95")) {
            return 99000;
        }else if (timeForWatchingText.getText().contains("105")) {
            return 109000;
        }else if (timeForWatchingText.getText().contains("110")) {
            return 114000;
        }else if (timeForWatchingText.getText().contains("115")) {
            return 119000;
        }else if (timeForWatchingText.getText().contains("125")) {
            return 129000;
        }else if (timeForWatchingText.getText().contains("130")) {
            return 134000;
        }else if (timeForWatchingText.getText().contains("135")) {
            return 139000;
        }else if (timeForWatchingText.getText().contains("14")) {
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