package lesson_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstRun {
    public static void main(String[] args) throws InterruptedException {
        //Setup chromedriver

        WebDriverManager.chromedriver().setup();

        // Initialization of chromedriver

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        //Current url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //Page source
//        System.out.println("driver.getPageSource() = " + driver.getPageSource());

        //Title
        System.out.println("driver.getTitle() = " + driver.getTitle());

        //Maximase url
        driver.manage().window().maximize();

        //Navigation to different url

        driver.navigate().to("https://www.yandex.ru");

        Thread.sleep(3000);
        driver.quit();
    }
}
