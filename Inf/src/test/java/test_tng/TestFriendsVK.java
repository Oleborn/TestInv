package test_tng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestFriendsVK {
    private WebDriver driver; //создается приватная (используемая только в этом классе) переменная driver интерфейса WebDriver
    // на переменной driver завязан запуск браузера
    // передача параметров запуска в UserAction
    // передача параметров запуска в Precondition
    private UserAction userAction;//создается приватная (используемая только в этом классе) переменная userAction класса (с параметрами) UserAction
    private Precondition precondition;//создается приватная (используемая только в этом классе) переменная precondition класса (с параметрами) Precondition

    @BeforeMethod //аннотация позволяющая запускать данный метод перед запуском остального
    public void init()
    {
        WebDriverConfiguration configuration = new WebDriverConfiguration();
        //инициализация !!объекта класса!! configuration класса WebDriverConfiguration из другого места
        this.driver = configuration.initBrowser();
        //инициализация (запуск) переменной driver именно из этого класса (this) с параметрами configuration и initBrowser
        this.userAction = new UserAction(this.driver);
        this.precondition = new Precondition(this.driver);
    }
    @Test
    public void openBrowser() {

        this.userAction.goTo(PageURL.MAIN);

        this.userAction.findElement(Selectors.INPUT_LOGIN)
                .sendKeys(this.precondition.getTestUser().getUserLogin());

        this.userAction.findElement(Selectors.BUTTON_LOGIN).click();

        this.userAction.findElement(Selectors.BUTTON_PASSWORD_VK).click();

        this.userAction.findElement(Selectors.INPUT_PASSWORD)
                .sendKeys(this.precondition.getTestUser().getUserPassword());

        this.userAction.findElement(Selectors.BUTTON_PASSWORD).click();

        this.userAction.findElement(Selectors.BUTTON_FRIENDS).click();

        //this.userAction.findElement(Selectors.BUTTON_ANATOLY).click();

        //this.userAction.findElements(Selectors.ALLFRIENDS).getText();

        List<WebElement> findAllFriends = driver.findElements(By.xpath("//a [@href='/there.isno.fear.only.pain']"));
        System.out.println(findAllFriends);
        //System.out.println(this.userAction.findElements(Selectors.ALLFRIENDS).getText());

        //System.out.println("Количество друзей Толяна - " + this.userAction.findElement(Selectors.ELEMENT_QUALITY_FRIENDS).getText());
        //driver.quit();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}