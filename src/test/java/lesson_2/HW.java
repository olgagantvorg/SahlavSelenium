package lesson_2;

import com.google.common.math.Quantiles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Scanner;

public class HW {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add name for testing site");
        String name = scanner.next();
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://devexpress.github.io/testcafe/example/");
        webDriver.findElement(By.cssSelector("#developer-name")).sendKeys(name);
        webDriver.findElement(By.cssSelector("#remote-testing")).click();
        webDriver.findElement(By.cssSelector("#reusing-js-code")).click();
        webDriver.findElement(By.cssSelector("#background-parallel-testing")).click();
        webDriver.findElement(By.cssSelector("#continuous-integration-embedding")).click();
        webDriver.findElement(By.cssSelector("#traffic-markup-analysis")).click();
        webDriver.findElement(By.cssSelector("#tried-test-cafe")).click();
        WebElement slider = webDriver.findElement(By.cssSelector("#slider"));
        WebElement toElement=webDriver.findElement(By.xpath("//*[@id=\"main-form\"]/div/div[2]/fieldset[2]/div/div[2]/div[9]"));
        Actions action = new Actions (webDriver);
        Actions actions = action.dragAndDrop(slider,
                toElement
        );
        actions.perform();
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("#comments")).sendKeys("Здравствуйте, привет!");
        Thread.sleep(3000);
        webDriver.findElement(By.cssSelector("#submit-button")).click();
        String currentUrl = webDriver.getCurrentUrl();

        if (currentUrl.equals("https://devexpress.github.io/testcafe/example/thank-you.html")){
            String hello = webDriver.findElement(By.cssSelector("#article-header")).getText();
            if (hello.equals("Thank you, "+ name + "!")){
                String title = webDriver.getTitle();
                if (title.equals("Thank you!")){
                    System.out.println("All correct, goodbye!");
                }
                else {
                    System.out.println("Title is incorrect");
                }
            }
            else {
                System.out.println("Greeting is incorrect");
            }
            }
        else {
            System.out.println("Invalid url!");

        }
        scanner.close();
        Thread.sleep(3000);
        webDriver.quit();


        }



    }

