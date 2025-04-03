package bookstore.steps;

import bookstore.pages.BookstorePage;
import bookstore.pages.LoginPage;
import bookstore.pages.ProfilePage;
import bookstore.utils.ConfigReader;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfileSteps {

    private final ProfilePage profilePage = new ProfilePage();
    private final BookstorePage bookstorePage = new BookstorePage();

    @Given("the user is on profile page")
    public void checkProfileUrl(){
        assertThat(profilePage.getActualProfilePageUrl())
                .as("Assert that current URL is Profile url")
                .isEqualTo(profilePage.getExpectedProfilePageUrl());
    }

    @When("the user clicks on Go To Book Store button")
    public void clickOnBookstoreButton(){
        profilePage.clickOnGoToBookstoreButton();
    }

    @Then("the user lands on Book Store page")
    public void checkIfTheUserIsOnBookStorePage() {
        assertThat(bookstorePage.hasLoaded())
                .as("Assert that bookstore page has loaded.")
                .isTrue();
    }
}
