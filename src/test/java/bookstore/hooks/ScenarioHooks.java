package bookstore.hooks;

import bookstore.utils.WebDriverManager;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.WebDriver;

public class ScenarioHooks {

    @BeforeScenario
    public void setup() {
        // Ensure WebDriver is initialized before each scenario
        WebDriverManager.getDriver();
    }

    @AfterScenario
    public void teardown() {
        System.out.println("Teardown: Starting cleanup");
        try {
            WebDriver driver = WebDriverManager.getDriver();
            driver.manage().deleteAllCookies();
        } catch (Exception e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
    }

    @AfterStories
    public void cleanupAfterAllScenarios() {
        // Close the browser after all scenarios are complete
        WebDriverManager.quitDriver();
    }

}
