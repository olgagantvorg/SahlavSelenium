package lesson_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class CanVusForgotPass {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prd.canvusapps.com/password_resets/new");
        WebElement emailImput = driver.findElement(By.xpath("//*[@id='email']"));
        emailImput.clear();
        emailImput.sendKeys("qwerty@gmail.com");
        WebElement resetButton = driver.findElement(By.cssSelector("input[value=\"Reset Password\"]"));
        resetButton.click();
        Thread.sleep(2000);
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://prd.canvusapps.com/login")){
            WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-notice.alert-block.notice"));
            errorMessage.getText();
            if (errorMessage.getText().equals("Email sent with password reset instructions.")){
                System.out.println("All tests are passed! :) ");
            }
            else {
                System.out.println("Invalid message!");
            }
        }
        else {
            System.out.println("Invalid url!");
        }
        Thread.sleep(3000);
        driver.quit();
    }
}
