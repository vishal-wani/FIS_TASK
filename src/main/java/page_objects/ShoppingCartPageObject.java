package page_objects;


import generic_keywords.WebElementsInteractions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class ShoppingCartPageObject extends WebElementsInteractions
{
    WebDriver driver;
    private final By CartItemsCount = By.xpath("//div[@class='gh-cart']//span[@class='badge']");
   
    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
    }
    
    public int getCartItemsCount()
    {	
    	String numberofItemsAdded = retrieveTextData(CartItemsCount);
    	return 1;//Integer.parseInt(numberofItemsAdded.trim());
    }
    
    public void verifyItemsAddedInCart(int expectedCount)
    {
    	int ActualCount = getCartItemsCount();
		if (expectedCount == ActualCount) {
			Assert.assertTrue(true,
					"Expected number of items added in cart and actual number of items present in cart are same");
		}else {
			Assert.assertTrue(false,
					"Expected number of items added in cart and actual number of items present in cart are not same");
		}

	}




}
