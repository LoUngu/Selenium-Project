package bookstore.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

    @FindBy(id = "gotoStore")
    WebElement goToBookStoreButton;

    String profileUrl = getBaseUrl() + "/profile";

    public ProfilePage(){
        super();
    }

    public boolean hasLoaded() {
        return waitUntilUrlContains("profile");
    }

    public String getActualProfilePageUrl() {
        return getCurrentUrl();
    }

    public String getExpectedProfilePageUrl() {
        return profileUrl;
    }

    public void clickOnGoToBookstoreButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        clickElement(goToBookStoreButton);
    }
}
