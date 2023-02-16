package lesson_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormTask {
    static WebDriver driver;
    public static void main(String[] args)  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automation.co.il/tutorials/selenium/demo1/indexID.html");

        //Page1
        String expectedErrorText = "This field is required.";
        By firstName = By.cssSelector("#firstname");
        By lastName = By.id("lastname");
        By email = By.name("email");
        By nextButton = By.cssSelector("#next");
        By firstNameError = By.cssSelector("[id=\"firstname-error\"]");
        By lastNameError = By.cssSelector("[id=\"lastname-error\"]");
        By emailError = By.cssSelector("[id=\"email-error\"]");
        clickElement(nextButton);
        validateText(firstNameError,expectedErrorText);
        validateText(lastNameError,expectedErrorText);
        validateText(emailError,expectedErrorText);
        typeText(firstName,"Olga");
        typeText(lastName,"Gant");
        typeText(email,"olga.gant@gmail.com");
        clickElement(nextButton);

        //Page2
       By advancedIcon = By.cssSelector("#Advanced");
       clickElement(advancedIcon);
       sleep(1000);
       clickElement(nextButton);
       sleep(3000);
       //Page3
        By streetName = By.cssSelector("[id=\"streetname\"]");
        By streetNumber = By.cssSelector("[id=\"streetnumber\"]");
        By city = By.cssSelector("[id=\"city\"]");
        By countrySelectLocator = By.cssSelector("[id=\"country\"]");
        By finishButton= By.cssSelector("[id=\"finish\"]");
        typeText(streetName,"Nisembaum");
        typeText(streetNumber,"5");
        typeText(city,"Bat Yam");
        Select countrySelectElement = new Select(driver.findElement(countrySelectLocator));
        countrySelectElement.selectByIndex(0);
        sleep(1000);
        countrySelectElement.selectByVisibleText("Italy");
        sleep(1000);
        countrySelectElement.selectByValue("Israel");
        sleep(1000);
        clickElement(finishButton);
        driver.quit();
    }

    public static void validateText(By selector,String expectedText){
        WebElement element = driver.findElement(selector);
        if (element.getText().equals(expectedText)){
            System.out.println("Text is correct");
        }
        else {
            System.out.println("Text is incorrect");
        }

    }
    public static void typeText(By selector,String text){
        WebElement element = driver.findElement(selector);
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public static void clickElement(By selector){
        WebElement element = driver.findElement(selector);
        element.click();
    }
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
