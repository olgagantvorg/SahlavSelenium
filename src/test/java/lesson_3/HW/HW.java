package lesson_3.HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW {
    static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        By searchString = By.cssSelector("[id=\"twotabsearchtextbox\"]");
        By submitButton = By.cssSelector("[id=\"nav-search-submit-button\"]");
        typeText(searchString, "tent");
        clickElement(submitButton);
        sleep(3000);
//        By nextButton = By.cssSelector("[class=\"s-pagination-item s-pagination-next s-pagination-button s-pagination-separator\"]");
//        clickElement(nextButton);
     List<WebElement> element = driver.findElements(By.cssSelector("[class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"] > span"));
////        elements.forEach(element -> System.out.println(element.getText()));

        for (WebElement element1:element) {
            By nextButton = By.cssSelector("[class=\"s-pagination-item s-pagination-next s-pagination-button s-pagination-separator\"]");
            clickElement(nextButton);
            System.out.println(element1.getText());
        }
//        element.forEach(element -> System.out.println(element.getText()));

    }

    public static void typeText(By selector, String text) {
        WebElement element = driver.findElement(selector);
        element.sendKeys(text);
    }

    public static void clickElement(By selector) {
        WebElement element = driver.findElement(selector);
        element.click();
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
