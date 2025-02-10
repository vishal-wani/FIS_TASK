package page_objects;

import generic_keywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends WebElementsInteractions
{

    private final By searchbox = By.xpath("//input[@title='Search']");
    private final By searchBtn = By.id("gh-search-btn");
    private final By bookList = By.xpath("//ul[@class='srp-results srp-list clearfix']/li[@data-view='mi:1686|iid:1']//a[@class='s-item__link']");

    public HomePageObject(WebDriver driver)
    {
        super(driver);
    }

    public ItemListingPageObject searchBook(String itemName) {
        goToApplication("https://www.ebay.com/");
        sendText(searchbox, itemName);
        //sendText(passwordTextField, password);
        clickElement(searchBtn);
        clickElement(bookList);
        switchToChildWindow();
        return new ItemListingPageObject(driver);

    }
}
