package Probe_test.Tests;

import Probe_test.stend.ActionURL;
import Probe_test.stend.ActionsUser;
import Probe_test.stend.InitBrowserDriver;
import Probe_test.stend.ListSelectors;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSauseDemo_PozRegistration {
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

        this.actionsUser.findElement(ListSelectors.ENTRYFIELDLOGIN).sendKeys(
                "standard_user");

        //Assert.assertEquals(this.actionsUser.findElement(ListSelectors.ENTRYFIELDLOGIN).getAttribute("value"), "standard_user", "не верно введено имя пользователя");

        this.actionsUser.findElement(ListSelectors.ENTRYFIELDPASSWORD).sendKeys("secret_sauce");

        this.actionsUser.findElement(ListSelectors.BUTTONLOGIN).click();

        Assert.assertEquals (driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Страница магазина не загрузилась");

        //driver.quit();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
