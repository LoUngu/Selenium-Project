package bookstore.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "firstname")
    WebElement firstNameField;

    @FindBy(id = "lastname")
    WebElement lastNameField;

    @FindBy(id = "userName")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "recaptcha-anchor")
    WebElement captchaCheckbox;

    @FindBy(id = "register")
    WebElement registerButton;

    @FindBy(id = "goTologin")
    WebElement backToLoginButton;

    @FindBy(id = "name")
    WebElement captchaError;

    String registerUrl = getBaseUrl() + "/register";

    //call the BasePage constructor to initialize WebDriver
    public RegisterPage() {
        super();
    }

    public String getFirstNameValue() {
        return getTheValueOfAWebElement(firstNameField);
    }

    public String getLastNameValue() {
        return getTheValueOfAWebElement(lastNameField);
    }

    public String getUserNameValue() {
        return getTheValueOfAWebElement(userNameField);
    }

    public String getPasswordValue() {
        return getTheValueOfAWebElement(passwordField);
    }

    public void navigateToRegisterPage() {
        navigateTo(registerUrl);
    }

    public String getActualRegisterPageUrl() {
        return getCurrentUrl();
    }

    public String getExpectedRegisterPageUrl() {
        return registerUrl;
    }

    public void registerUser(String firstName, String lastName, String username) {
        enterText(firstNameField, firstName);
        enterText(lastNameField, lastName);
        enterText(userNameField, username);
        enterText(passwordField, configReader.getPassword());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        clickElement(registerButton);
    }

    public String getCaptchaErrorMessage() {
        return captchaError.getText();
    }

    public void clickOnBackToLoginButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        clickElement(backToLoginButton);
    }

    public void verifyRegistrationSuccessfulMessage() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertMessage = alert.getText();

            String expectedMessage = "User Register Successfully.";
            if (!alertMessage.equals(expectedMessage)) {
                throw new AssertionError("Expected alert message: '" + expectedMessage + "' was not displayed!");
            }

            alert.accept();
        } catch (Exception e) {
            throw new AssertionError("No alert appeared after registration");
        }
    }
}
