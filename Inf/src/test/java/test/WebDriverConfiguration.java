package test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class WebDriverConfiguration {
    private String downloadFolder;
    public WebDriver initBrowser() {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", this.downloadFolder);
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("prefs", chromePrefs);
        opt.addArguments("start-maximized");
        return new ChromeDriver(opt);

    }
}
