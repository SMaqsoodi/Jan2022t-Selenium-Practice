package SeleniumSessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilElement {
	WebDriver wd;
// Constructor method of the class		
	public UtilElement(WebDriver driver) {
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
 * this method is used to create a list of web elements on the basis of By locator	 	
 * @param locator
 * @return
 */
	public List getElements(By locator) {
		List listOfElements = null;
		
		try {
			listOfElements = wd.findElements(locator);
		}
		catch(Exception e) {
			System.out.println("some exception occurred while creatign the elements ... ");
			System.out.println(e.getMessage());
		}
		return listOfElements;
	}	
/**
 * this is method is used to send text to an element	
 * @param locator
 * @param text
 */
	public void senkeytoElement(By locator, String text) {
		try {
			getElement(locator).sendKeys(text);
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println();;			
		}
		
	}

/**
 * this method is used to click on an element
 * @param locator
 */
	public void clickOnElement(By locator) {
		try {
			getElement(locator).click();
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println();;			
		}
		
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
			System.out.println();;			
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
			System.out.println();;			
		}
		
	}
/**
 * 	this method is used to put driver on wait for the presence of an element 
 * @param locator
 * @param timeOutInSecond
 */
	public void ExplicitWaitForElement(By locator, int timeOutInSecond) {
		WebDriverWait wait = new WebDriverWait(wd, timeOutInSecond);
		try {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println();;			
		}
	}
	
/**
 * 	this method is used to put driver on hold till the presence of page title 
 * @param title
 * @param timeOutInSecond
 */
	public String ExplicitWaitForTitle(String title, int timeOutInSecond) {
		WebDriverWait wait = new WebDriverWait(wd, timeOutInSecond);
		try {
		wait.until(ExpectedConditions.titleContains(title));
		}
		catch(Exception e) {
			System.out.println("some exception is coming ...");
			System.out.println();;			
		}
		return wd.getTitle();
	}	

	// 	========  ExplicitWait Generic custom Methods =========
/**
 * this method applies explicit wait for an element and also returns the element
 * @param locator
 * @param timeOut
 * @return
 */
	public WebElement waitForElementToBePresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return getElement(locator);
	}
	
	public void waitForAllElemenstToBeVisible(List<WebElement> elementList, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
	}
/**
 * this method applies explicit wait for title to be present then return the title
 * @param title
 * @param timeOut
 * @return
 */
//	wait till presence of the element in DOM not necessarily visibility of the element
	public String waitFortitleToBePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return wd.getTitle();
	}
/**
 * this method applies explicit wait for clickable elements only like buttons and links
 * @param locator
 * @param timeOut
 * @return
 */
	public WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return getElement(locator);
	}
/**
 * this method applies explicit wait for elements to be visible 
 * @param locator
 * @param timeOut
 * @return
 */
//	keep in mind that presence of element in DOM doesn't guarantee visibility of the element. An expectation for checking that an element, 
//	known to be present on the DOM of a page, is visible. Visibility means that the element is not only displayed 
//	but also has a height and width that is greater than 0.
	public WebElement waitForElementToBeVisible(By locator, int timeOut) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
/**
 * 	this method applies explicit wait for elements based on locator to be visible 
 * @param locator
 * @param timeOut
 * @return
 */
// 	exactly the same as ExpectedConditions.visibilityOf(element)
	public WebElement waitForElementVisibilityLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return getElement(locator);
	}
/**
 * this method applies explicit wait for a url and returns the url	
 * @param url
 * @param timeOut
 * @return
 */
	public String waitForUrl(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.urlContains(url));
		return wd.getCurrentUrl();
	}
/**
 * this method checks the presence of a javascript alert only and returns true or false	
 * @param timeOut
 * @return
 */
	public boolean waitForAlertToBePresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.alertIsPresent());
		return true;
	}
	
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(wd, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		getElement(locator).click();
	}
	
}	
