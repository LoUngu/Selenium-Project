package bookstore.steps;

import org.assertj.core.api.SoftAssertions;
import bookstore.pages.RegisterPage;
import bookstore.utils.ConfigReader;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static bookstore.utils.RandomStringGenerator.generateRandomString;

public class RegisterSteps {

    private final ConfigReader configReader = new ConfigReader();
    private final RegisterPage registerPage = new RegisterPage();
    private final String firstName = "Test Fname " + generateRandomString(4);
    private final String lastName = "Test Lname " + generateRandomString(4);
    private final String username = "username" + generateRandomString(4);

    @Given("the user navigates to Registration page")
    public void navigateToRegister(){
        registerPage.navigateToRegisterPage();
        assertThat(registerPage.getActualRegisterPageUrl())
                .as("Assert that current URL is the same as expected URL.")
                .isEqualTo(registerPage.getExpectedRegisterPageUrl());
    }

    @When("the user tries to register without resolving the captcha")
    public void fillInRegistrationDetails(){

        registerPage.registerUser(firstName, lastName, username);
        SoftAssertions softly = new SoftAssertions();

        assertThat(registerPage.getFirstNameValue())
                .as("Assert that first name field was filled with the given value")
                .isEqualTo(firstName);
        assertThat(registerPage.getLastNameValue())
                .as("Assert that last name field was filled with the given value")
                .isEqualTo(lastName);
        assertThat(registerPage.getUserNameValue())
                .as("Assert that username field was filled with the given value")
                .isEqualTo(username);
        assertThat(registerPage.getPasswordValue())
                .as("Assert that first name field was filled with the given value")
                .isEqualTo(configReader.getPassword());

        softly.assertAll();
    }

    @Then("the user will see an error message")
    public void checkAlertForCaptchaForSolvedErrorMessage(){
        assertThat(registerPage.getCaptchaErrorMessage())
                .as("Assert that captcha error message 'Please verify reCaptcha to register!' is displayed.")
                .isEqualTo("Please verify reCaptcha to register!");
    }

    @When("the user clicks on Go to login button")
    public void navigateToLogin(){
        registerPage.clickOnBackToLoginButton();
    }

}
