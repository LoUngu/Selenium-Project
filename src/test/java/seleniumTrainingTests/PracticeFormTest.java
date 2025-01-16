package seleniumTrainingTests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class PracticeFormTest {

    public WebDriver driver;


    @Test
    public void fillInTheForm(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        WebElement formField = driver.findElement(By.xpath("//h5[text()='Forms']"));
        formField.click();

        WebElement practiceFormField = driver.findElement(By.xpath("//span[text()='Practice Form']"));
        practiceFormField.click();


        WebElement firstNameField = driver.findElement((By.id("firstName")));
        String firstNameValue = "Ion";
        firstNameField.sendKeys(firstNameValue);

        WebElement lastNameField = driver.findElement((By.id("lastName")));
        String lastNameValue = "Popescu";
        lastNameField.sendKeys(lastNameValue);

        js.executeScript("window.scrollBy(0,1000)");

        WebElement userEmailField = driver.findElement((By.id("userEmail")));
        String userEmailValue = "ion.popescu@email.com";
        userEmailField.sendKeys(userEmailValue);

        WebElement maleRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        WebElement femaleRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
        WebElement otherRadioButton = driver.findElement(By.xpath("//label[@for='gender-radio-3']"));

        String gender = "male";

        if(gender.equals("male")){
            maleRadioButton.click();
        }else if (gender.equals("female")){
            femaleRadioButton.click();
        }else{
            otherRadioButton.click();
        }

        WebElement phoneField = driver.findElement((By.cssSelector("input[placeholder='Mobile Number']")));
        String phoneValue = "0734111222";
        phoneField.sendKeys(phoneValue);

        WebElement subjectField = driver.findElement(By.id("subjectsInput"));
        String subjectValue = "Social Studies";
        subjectField.sendKeys(subjectValue);
        subjectField.sendKeys(Keys.ENTER);

        WebElement chooseFileButton = driver.findElement(By.id("uploadPicture"));
        File file = new File("src/test/resources/fileToUpload.png");
        chooseFileButton.sendKeys(file.getAbsolutePath());

        WebElement stateDropdown = driver.findElement(By.id("react-select-3-input"));
        js.executeScript("arguments[0].click();", stateDropdown);
        stateDropdown.sendKeys("NCR");
        stateDropdown.sendKeys(Keys.ENTER);

        WebElement cityDropdown = driver.findElement(By.id("react-select-4-input"));
        js.executeScript("arguments[0].click();", cityDropdown);
        cityDropdown.sendKeys("Delhi");
    }
}
