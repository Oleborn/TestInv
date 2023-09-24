package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UserAction {
    private WebDriver webDriver;
    public UserAction(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement findElement  (Selectors selectorsElement) {
        return new WebDriverWait(this.webDriver, 10, TimeUnit.SECONDS.ordinal())
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(selectorsElement.getValue())));
    }
    public void goTo(PageURL pageURL) {
        this.webDriver.get(pageURL.getValue());
    }
}
