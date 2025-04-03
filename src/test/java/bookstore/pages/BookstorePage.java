package bookstore.pages;

public class BookstorePage extends BasePage{


    String bookstoreUrl = getBaseUrl() + "/books";

    public BookstorePage(){
        super();
    }

    public boolean hasLoaded() {
        return waitUntilUrlContains("books");
    }

    public String getActualBookstorePageUrl() {
        return getCurrentUrl();
    }

    public String getExpectedBookstorePageUrl() {
        return bookstoreUrl;
    }
}
