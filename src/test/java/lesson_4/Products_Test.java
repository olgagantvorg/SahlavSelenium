package lesson_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class Products_Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        //Login page
//        driver.findElement(By.cssSelector("[data-test=\"username\"]")).click();
//        driver.findElement(By.cssSelector("[data-test=\"username\"]")).clear();
//        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
//        driver.findElement(By.cssSelector("[data-test='password']")).click();
//        driver.findElement(By.cssSelector("[data-test='password']")).clear();
//        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
//        driver.findElement(By.cssSelector("[data-test='login-button']")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");



        //ProductPage
//        List<WebElement> itemDescriptionElements = driver.findElements(By.cssSelector("[class=\"inventory_item_description\"]"));
//        for (WebElement element:itemDescriptionElements){
//            WebElement title = element.findElement(By.cssSelector("[class=\"inventory_item_name\"]"));
//            WebElement addToCartButton = element.findElement(By.cssSelector("button"));
//            if (title.getText().equals("Sauce Labs Backpack")){
//                addToCartButton.click();
//            }
//        }
//        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-onesie\"]")).click();
//        if (Integer.parseInt(driver.findElement(By.cssSelector("[class=\"shopping_cart_badge\"]")).getText())==2){
//            System.out.println("Correct!");
//        }
//        else {
//            System.out.println("Incorrect!");
//        }
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.chooseProduct("Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt");
        productsPage.validateNumberOfAddedItems(3);
        Thread.sleep(3000);
        driver.quit();

    }
}
