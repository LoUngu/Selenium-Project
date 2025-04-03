package seleniumTrainingTests;

import bookstore.utils.WebDriverManager;
import org.example.seleniumTraining.pages.FormPage;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormPageTests {
    static  WebDriver driver;
    FormPage formPage;

    @BeforeAll
    public static void setUpBeforeClass(){
        System.out.println("Inainte de toate testele");
//        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver.manage().maximise();
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    }

    @BeforeEach
    public void setUp(){
        formPage = new FormPage(driver);
        System.out.println("Inainte de fiecare test");

    }

    @AfterEach
    public void tearDown(){
        System.out.println("Dupa fiecare test");
    }

    @AfterAll
    public static void tearDownAfterClass(){
        System.out.println("Dupa ce suita de teste a fost executata.");
    }

    @Test
    public void test(){
        System.out.println("Acesta este un test");
    }
}
