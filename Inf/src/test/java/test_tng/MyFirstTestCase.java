package test_tng;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
