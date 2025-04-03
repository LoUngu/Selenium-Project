package seleniumTrainingTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeLists {

    public WebDriver driver;

    @Test
    public void iterateThroughTheList() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/sortable");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        List<WebElement> listItems = driver.findElements(By.xpath(
                "//div[@id='demo-tabpane-list']/div[@class='vertical-list-container mt-4']/div"));

        Actions actions = new Actions(driver);

        for(int i = 0; i < listItems.size(); i++){
            WebElement currentListElement = listItems.get(i);
            WebElement nextListElement = listItems.get(i++);
            if(i == 2){
                Thread.sleep(1000);
                listItems.get(i).click();
            }
//            actions.clickAndHold(currentListElement)
//                    .moveToElement(nextListElement)
//                    .release()
//                    .build()
//                    .perform();
        }

        driver.close();

    }
}
