package bookstore.pages;

public class ProfilePage extends BasePage {

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
}
