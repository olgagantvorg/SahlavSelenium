package lesson_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

import static java.lang.Thread.sleep;

public class ConVusForgotPass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebElement email = driver.findElement(By.xpath());
        WebElement resetButton = driver.findElement(By.cssSelector());
        WebElement message = driver.findElement(By.xpath());

        Thread.sleep(3000);
        driver.quit();
    }
}
