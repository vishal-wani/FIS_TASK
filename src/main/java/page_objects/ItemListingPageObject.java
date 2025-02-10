package page_objects;


import generic_keywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemListingPageObject extends WebElementsInteractions
{
    WebDriver driver;
    private final By addToCartBTn = By.id("atcBtn_btn_1");
   
    public ItemListingPageObject(WebDriver driver) {
        super(driver);
    }
    
    public ShoppingCartPageObject addToCart()
    {
       clickElement(addToCartBTn);
	return new ShoppingCartPageObject(driver);
    }




}
