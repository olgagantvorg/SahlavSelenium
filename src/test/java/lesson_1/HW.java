package lesson_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //Откройте сайт: https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        //Выведите в консоль:
        //Адрес сайта
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //Заголовок сайта
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //Откройте сайт https://www.walmart.com/
        driver.navigate().to("https://www.walmart.com/");
        //Вернитесь на первый сайт.
        driver.navigate().back();
        //Вернитесь на второй сайт.
        driver.navigate().forward();
        //Перезагрузите второй сайт.
        driver.navigate().refresh();
        //На втором сайте выведите в консоль:
        //Адрес сайта
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //Заголовок сайта
        System.out.println("driver.getTitle() = " + driver.getTitle());
        driver.quit();

    }
}
