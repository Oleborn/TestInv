package Probe_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestSauseDemo {
    private WebDriver driver;
    private ActionsUser actionsUser;

    @BeforeMethod
    public void startBrowser() {
        InitBrowserDriver start = new InitBrowserDriver();
        this.driver = start.initBrowser();
        this.actionsUser = new ActionsUser(this.driver);
    }

    @Test
    public void stepTestCase() {

        driver.get(ActionURL.SAUSEDEMO.getValue());

        this.actionsUser.findElement(ListSelectors.ENTRYFIELDLOGIN).sendKeys("standard_user");

        this.actionsUser.findElement(ListSelectors.ENTRYFIELDPASSWORD).sendKeys("secret_sauce");

        this.actionsUser.findElement(ListSelectors.BUTTONLOGIN).click();

        driver.quit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
