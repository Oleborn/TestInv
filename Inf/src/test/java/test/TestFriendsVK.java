package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestFriendsVK {
    private WebDriver driver;
    private UserAction userAction;

    private Precondition precondition;

    @BeforeMethod
    public void init() {
        WebDriverConfiguration configuration = new WebDriverConfiguration();
        this.driver = configuration.initBrowser();
        this.userAction = new UserAction(this.driver);
        this.precondition = new Precondition(this.driver);
    }

    @Test
    public void openBrowser() {

        this.precondition.goTo(PageURL.MAIN);

        this.userAction.findElement(Selectors.INPUT_LOGIN)
                .sendKeys(this.precondition.getTestUser().getUserLogin());

        this.userAction.findElement(Selectors.BUTTON_LOGIN).click();

        this.userAction.findElement(Selectors.BUTTON_PASSWORD_VK).click();

        this.userAction.findElement(Selectors.INPUT_PASSWORD)
                .sendKeys(this.precondition.getTestUser().getUserPassword());

        this.userAction.findElement(Selectors.BUTTON_PASSWORD).click();

        this.userAction.findElement(Selectors.BUTTON_FRIENDS).click();

        this.userAction.findElement(Selectors.BUTTON_ANATOLY).click();

        System.out.println("Количество друзей Толяна - " + this.userAction.findElement(Selectors.ELEMENT_QUALITY_FRIENDS).getText());
        driver.quit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}