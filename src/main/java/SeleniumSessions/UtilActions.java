package SeleniumSessions;

// action class is used to perform mouse/keyboard functions in Selenium for automation purposes.

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UtilActions {
	WebDriver wd;
//	Actions action = new Actions(wd);
	// Constructor method of the class		
	public UtilActions(WebDriver driver) {
		this.wd = driver;
	}

/**
 * this method is used to create a web element on the basis of By locator	
 * @param locator
 * @return
 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
		element = wd.findElement(locator);
		}
		catch(Exception e) {
			System.out.println("some exception occurred while creatign the element ... ");
			System.out.println(e.getMessage());
		}
		return element;
	}

/**
 * this method is used to move on an element 
 * @param locator
 */
	public void moveToElement(By locator) {
		
		WebElement we = getElement(locator);
		try {
		Actions action = new Actions(wd);
		action.moveToElement(we).build().perform();
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println(e.getMessage());			
		}
		
	}

/**
 * this method is used to move on an element and click
 * @param locator
 */
	public void moveToElementAndClick(By locator) {
		WebElement we = getElement(locator);
		try {
		Actions action = new Actions(wd);
		action.moveToElement(we).click().build().perform();
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println(e.getMessage());		
		}
		
	}
/**
 * this method is used to move to, click and hold and release an element on another element 	
 * @param draggable
 * @param droppable
 */
	public void dragAndDrop (By draggable, By droppable) {

		Actions action = new Actions(wd);
		try {
		action.moveToElement(getElement(draggable)).clickAndHold(getElement(draggable)).release(getElement(droppable)).build().perform();
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println(e.getMessage());			
		}
	}
	
	public void sendKeyByActions(By locator, String value) {
		Actions action = new Actions(wd);
		try {
			action.sendKeys(getElement(locator), value).build().perform();

//  		practicing keyboard action Ctr+A with action class:
//			action.keyDown(Keys.CONTROL);
//			action.sendKeys("a");
//			action.keyUp(Keys.CONTROL);
//			action.build().perform();
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println(e.getMessage());
		}
	}
	
}	


