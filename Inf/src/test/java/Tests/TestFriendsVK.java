package Tests;
import com.sun.source.util.SourcePositions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TestFriendsVK {
    private String downloadFolder;
    private WebDriver driver;
    @Test
    public void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", this.downloadFolder);
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("prefs", chromePrefs);
        opt.addArguments("start-maximized");
        driver = new ChromeDriver(opt);
        driver.get("https://vk.com");
        WebElement inputLogin = driver.findElement(By.id("index_email"));
        inputLogin.sendKeys("89234731274");
        WebElement buttonLogin= driver.findElement(By.cssSelector("#index_login > div > form > button > span > span"));
        buttonLogin.click();
        WebElement buttonPasswordVK = new WebDriverWait(driver, 10, TimeUnit.SECONDS.ordinal())
                    .until(ExpectedConditions.presenceOfElementLocated(By.className("vkc__Bottom__switchToPassword")));
        buttonPasswordVK.click();
        WebElement inputPassword = driver.findElement
                (By.cssSelector("#root > div > div > div > div > div.vkc__AuthRoot__root.vkuiSplitLayout__inner > div.vkc__AuthRoot__col.vkc__AuthRoot__contentCol.vkuiSplitCol > div > div > div > form > div:nth-child(1) > div.vkc__Password__Wrapper > div > div > input"));
        inputPassword.sendKeys("000000");
        WebElement buttonPassword = driver.findElement(By.className("vkuiButton__in"));
        buttonPassword.click();
        WebElement buttonFriends = new WebDriverWait(driver, 10, TimeUnit.SECONDS.ordinal())
                .until(ExpectedConditions.presenceOfElementLocated(By.id("l_fr")));
        buttonFriends.click();
        WebElement buttonAnatoly = new WebDriverWait(driver, 10, TimeUnit.SECONDS.ordinal())
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                        ("#friends_user_row43511416 > div.friends_user_info.friends_user_info--fullRow > div.friends_field.friends_field_title > a")));
        buttonAnatoly.click();
        WebElement elementQualityFriends = new WebDriverWait(driver, 10, TimeUnit.SECONDS.ordinal())
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector
                        ("#profile_redesigned > div > div > div > div.vkuiPopoutRoot.vkuiSplitLayout > div > div.ScrollStickyWrapper > div > section.vkuiInternalGroup.vkuiGroup.vkuiGroup--mode-card.vkuiInternalGroup--mode-card.vkuiGroup--padding-m.Group-module__group--lRMIn.Group-module__groupPaddingM--qj3wo.Group-module__groupModeCard--bGIrq.vkuiInternalGroupCard.ProfileGroup.ProfileFriends > a > header > div > span > span.vkuiHeader__indicator.vkuiFootnote.vkuiTypography--normalize.vkuiTypography--weight-2")
                        ));
        System.out.println("Количество друзей Толяна - " + elementQualityFriends.getText());
        driver.quit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}