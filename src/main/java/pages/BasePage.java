package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void typeText(WebElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
    }
    public void clickElement (WebElement element){
        element.click();
    }
    public String getElementText(WebElement element){
        return element.getText();
    }
}
