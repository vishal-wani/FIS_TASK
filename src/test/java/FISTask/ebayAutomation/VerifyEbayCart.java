package FISTask.ebayAutomation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import page_objects.HomePageObject;
import page_objects.ItemListingPageObject;
import page_objects.ShoppingCartPageObject;
//import FISTask.ebayAutomation.BaseTest;

public class VerifyEbayCart extends BaseTest {
	HomePageObject homepageobject;
	ItemListingPageObject itemlistingpageobject;
	ShoppingCartPageObject shoppingcartpageobject;
	
	private static final Logger logger = LogManager.getLogger(VerifyEbayCart.class);
	@Test
    public void ebayCartTest()
    {
        String itemToSearch = "books";
        int count = 1;
        homepageobject = new HomePageObject(driver);
        itemlistingpageobject = homepageobject.searchBook(itemToSearch);
        logger.info("Searched for "+ itemToSearch);
        shoppingcartpageobject = itemlistingpageobject.addToCart();
        logger.info("Item added to cart");
        shoppingcartpageobject.verifyItemsAddedInCart(count);
        
        
        //System.out.println(productsPageObject.getTitleOfPage());
    }

}
