package bookstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "userName")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "newUser")
    WebElement newUserButton;

    @FindBy(id = "name")
    WebElement loginError;

    String loginUrl = getBaseUrl() + "/login";

    public LoginPage(){
        super();
    }

    public void navigateToLoginPage() {
        navigateTo(loginUrl);
    }

    public String getActualLoginPageUrl() {
        return getCurrentUrl();
    }

    public String getExpectedLoginPageUrl() {
        return loginUrl;
    }
    public void login(String username, String password){
        enterText(userNameField, username);
        enterText(passwordField, password);
        clickElement(loginButton);
    }
}
