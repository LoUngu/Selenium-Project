package seleniumTrainingTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void automationMethod() {
        //open a new instance of Chrome;
        driver = new ChromeDriver();

        //access a webpage
        driver.get("https://demoqa.com/");

        //maximize window
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        //declare element
        WebElement elementField = driver.findElement(By.xpath("//h5[text()='Elements']"));
        elementField.click();

        WebElement webTablesField = driver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesField.click();

        List<WebElement> tableRows = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/div/div[@class=\"rt-tr -odd\" or @class=\"rt-tr -even\"]"));
        Integer actualTableSize = tableRows.size();

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement firstNameField = driver.findElement((By.id("firstName")));
        String firstNameValue = "Ion";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement((By.id("lastName")));
        String lastNameValue = "Popescu";
        lastNameField.sendKeys(lastNameValue);

        WebElement userEmailField = driver.findElement((By.id("userEmail")));
        String userEmailValue = "ion.popescu@email.com";
        userEmailField.sendKeys(userEmailValue);

        WebElement ageField = driver.findElement((By.id("age")));
        String ageValue = "18";
        ageField.sendKeys(ageValue);

        WebElement salaryField = driver.findElement((By.id("salary")));
        String salaryValue = "10000";
        salaryField.sendKeys(salaryValue);

        WebElement departmentField = driver.findElement((By.id("department")));
        String departmentValue = "IT";
        departmentField.sendKeys(departmentValue);

        WebElement submitButton= driver.findElement((By.id("submit")));
        submitButton.click();

        List<WebElement> uiExpectedTableRows = driver.findElements(By.xpath("//div[@class=\"rt-tbody\"]/div/div[@class=\"rt-tr -odd\" or @class=\"rt-tr -even\"]"));

        Integer expectedTableSize = actualTableSize + 1;
        Assert.assertEquals(uiExpectedTableRows.size(), expectedTableSize);
    }
}
