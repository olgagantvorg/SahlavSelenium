package lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class EbayTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseUrl = "https://www.ebay.com";
        driver.get(baseUrl+"/sch/ebayadvsearch");
        driver.findElement(By.cssSelector("[data-testid='_nkw']")).sendKeys("macbook",Keys.ENTER);
        //Optional actions for search
//        driver.findElement(By.cssSelector("[data-testid='_nkw']")).sendKeys("macbook");
//        driver.findElement(By.cssSelector("[class='btn btn--primary']")).click();
//        driver.findElements(By.cssSelector("[class='btn btn--primary']")).get(0).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[class=\"s-item__info clearfix\"] > a"));
        elements.forEach(element -> System.out.println(element.getText()));
        System.out.println("elements.size() = " + elements.size());
        elements.get(5).click();

        Thread.sleep(3000);
        driver.close();
        Thread.sleep(7000);
        driver.quit();
    }
}
