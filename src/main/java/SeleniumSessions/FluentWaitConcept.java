package SeleniumSessions;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	public static void main(String[] args) {
		// there are 2 types of explicit wait
		// 1. WebDriverWait
		// 2. FluentWait. a) TimeOut   b) pollingPeriod  c) ignoringException  d) until
/*		// when to use: for handling the Ajax component. AJAX stands for Asynchronous JavaScript and XML. AJAX is a new technique for creating better, 
 * 		faster, and more interactive web applications with the help of XML, HTML, CSS, and Java Script. 
 * 		Ajax uses XHTML for content, CSS for presentation, along with Document Object Model and JavaScript for dynamic content display.
 * 		Ajax is a set of web development techniques that uses various web technologies on the client-side to create asynchronous web applications. 
 * 		With Ajax, web applications can send and retrieve data from a server asynchronously without interfering with the display and behavior of the existing page.
 * 
 * 		FluentWait is actually supercalss of WebDriverWait in Selenium
 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html?e=1");
		
		final By userName = By.name("username");
		By passWord = By.name("password");
		By login = By.className("btn-small");
		By signUp = By.linkText("Sign Up");
		
		waitForElementWithFluentWait(driver, userName, 20, 2).sendKeys("SMaqsoodi");
		driver.findElement(passWord).sendKeys("sudn@1357");
		driver.findElement(login).click();
		// Wait is A generic interface for waiting until a condition is true or not null. The condition may take a single argument of type .
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(15))
//				.pollingEvery(Duration.ofSeconds(3))
//				.ignoring(NoSuchElementException.class);
//		// Function is an interface
//		wait.until(new Function<WebDriver, WebElement>(){
//
//			@Override
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(userName);
//			}
//			
//		});
		
//		Function here is not an object but an Interface. this entire block of code represents an anonymous inner class from parent Function interface,
//		which overrides apply methods of Function Interface

		/* 		Function<WebDriver, WebElement>(){

			@Override
			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(userName);
			}
			
		}); */
		
		
	}
// generic method for fluent wait
	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator, int duration, int interval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(duration))
				.pollingEvery(Duration.ofSeconds(interval))
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>(){

			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
			
		});
		return element;	
				
	}
// or similiarly we can combine Fluent wait with WebDriverWait way:
	public static WebElement waitForElement_FluentWait(WebDriver driver, final By locator, int duration, int interval) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(duration))
				.pollingEvery(Duration.ofSeconds(interval))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator)); // we can use it for any ExpectedConditions now.
	}

}
