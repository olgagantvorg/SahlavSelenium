package lesson_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CanVusAppLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prd.canvusapps.com/login");
        driver.findElement(By.id("email")).sendKeys("akoman@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("petya@gmail.com");
        driver.findElement(By.name("password")).sendKeys("123456io");
        driver.findElement(By.cssSelector("input[id='remember_me']")).click();
        String classAtribute = driver.findElement(By.cssSelector("[name='button']")).getAttribute("class");
        System.out.println("classAtribute = " + classAtribute);
        driver.findElement(By.cssSelector("[name='button']")).click();
        Thread.sleep(3000);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://prd.canvusapps.com/sessions")){
            String errorMes = driver.findElement(By.cssSelector(".alert.alert-notice.alert-block.notice")).getText();
            if (errorMes.equals("Invalid email or password")){
                System.out.println("All tests are passed! :) ");
            }
            else {
                System.out.println("Invalid message!");
            }
        }
        else {
            System.out.println("Invalid url!");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
