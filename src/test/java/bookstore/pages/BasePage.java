package bookstore.pages;

import bookstore.utils.ConfigReader;
import bookstore.utils.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;
    protected ConfigReader configReader;

    public BasePage (){
        this.driver = WebDriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.configReader = new ConfigReader();
        PageFactory.initElements(driver, this);
    }

    protected String getBaseUrl(){
        return configReader.getBaseUrl();
    }

    protected String getCurrentUrl(){return driver.getCurrentUrl();}

    protected void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    protected String getTheValueOfAWebElement(WebElement webElement) {
        return webElement.getAttribute("value");
    }
    protected void navigateTo(String url){
        driver.get(url);
    }

    protected boolean waitUntilUrlContains(String url) {
        return wait.until(ExpectedConditions.urlContains(url));
    }
}
