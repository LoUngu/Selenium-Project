package bookstore.steps;

import bookstore.pages.LoginPage;
import bookstore.pages.ProfilePage;
import bookstore.utils.ConfigReader;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final ProfilePage profilePage = new ProfilePage();
    private final ConfigReader configReader = new ConfigReader();

    @Given("the user navigates to login page")
    public void navigateToLogin(){
        loginPage.navigateToLoginPage();
        assertThat(loginPage.getActualLoginPageUrl())
                .as("Assert that current URL is the same as expected URL")
                .isEqualTo(loginPage.getExpectedLoginPageUrl());
    }

    @When("the user logs in with valid credentials")
    public void login(){
        loginPage.login(configReader.getUsername(), configReader.getPassword());
    }

    @Then("the user lands on profile page")
    public void checkIfUserIsOnProfilePage(){
        assertThat(profilePage.hasLoaded())
                .as("Assert that current profile page has loaded")
                .isTrue();
        }
}
