package Probe_test.Tests;

import Probe_test.stend.ActionURL;
import Probe_test.stend.ActionsUser;
import Probe_test.stend.InitBrowserDriver;
import Probe_test.stend.ListSelectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSauseDemo_NegativePassword {
    private WebDriver driver;
    private ActionsUser actionsUser;

    @BeforeMethod
    public void startBrowser() {
        InitBrowserDriver start = new InitBrowserDriver();
        this.driver = start.initBrowser();
        this.actionsUser = new ActionsUser(this.driver);
    }
    @Test
    private void stepTestCase() {

        driver.get(ActionURL.SAUSEDEMO.getValue());

        String titlePage = driver.getCurrentUrl();

        this.actionsUser.findElement(ListSelectors.ENTRYFIELDPASSWORD).sendKeys("secret_sauce");

        this.actionsUser.findElement(ListSelectors.BUTTONLOGIN).click();

        Assert.assertTrue(this.actionsUser.findElement(ListSelectors.MESSAGE_OF_ERROR_PASSWORD).isDisplayed(), "текста ошибки нет");

        Assert.assertEquals (titlePage, driver.getCurrentUrl(), "Страница магазина загрузилась - это ошибка");

        driver.quit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
