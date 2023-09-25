package Probe_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionsUser {
    private WebDriver webDriver;

    public ActionsUser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement findElement(ListSelectors selectorsElement) {
        return new WebDriverWait(this.webDriver, 10, TimeUnit.SECONDS.ordinal())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorsElement.getValue())));
    }
}

