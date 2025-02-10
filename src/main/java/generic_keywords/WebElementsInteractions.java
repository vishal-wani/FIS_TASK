package generic_keywords;


import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsInteractions
{
    protected WebDriver driver;

    //Custom Keywords that helps to implement KeyWord Driven Framework Strategy
    protected WebElementsInteractions(WebDriver driver)
    {
        this.driver = driver;
    }
    
    
    protected void clickElement(By locator)
    {	
    	waitForElementVisible(locator);
        driver.findElement(locator).click();
    }

    protected void sendText(By locator, String text)
    {	
    	waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    protected void goToApplication(String url)
    {
        driver.navigate().to(url);
    }

    protected String retrieveTextData(By locator)
    {	
    	waitForElementVisible(locator);
        return driver.findElement(locator).getText();
    }
    
    protected void waitForElementVisible(By locator)
    {	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    protected void waitForElementsVisible(By locator)
    {	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    protected void switchToChildWindow()
    {	
    	
    	String parentWindow = driver.getWindowHandle();
    	Set<String> childwindow = driver.getWindowHandles();
    	
    	for(String window: childwindow) {
    		if(!parentWindow.equals(window)) {
    			driver.switchTo().window(window); 
    		}
    	}
    	
    }

}
