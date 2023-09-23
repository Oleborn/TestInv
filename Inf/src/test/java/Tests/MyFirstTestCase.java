import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class MyFirstTestCase {
    private String downloadFolder;
    private WebDriver driver;
    @Test
    public void openBrowser () {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", this.downloadFolder);
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("prefs", chromePrefs);
        opt.addArguments("start-maximized");
        driver = new ChromeDriver(opt);
        driver.get("https://vk.com");
        WebElement input = driver.findElement(By.xpath("//input[@id='index_email']"));
        input.sendKeys("89234731274");
        WebElement button = driver.findElement(By.cssSelector("#index_login > div > form > button"));
        //driver.quit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
