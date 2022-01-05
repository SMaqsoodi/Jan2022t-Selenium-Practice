package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*there are 8 locators in selenium. periority:
	id                ---  I --- uniqe
	name              ---  II --- high chance of being uniqe
	xpath             ---  III --- in case id or name is not available or id is dynamic
	Css               ---  III --- same as xpath
	class name        ---  IV  --- least priority. hard to find uniqe class name since there could be many elements sharing the same html class or classes.
	link text         --- applicable only for links. still between id and link text for an element, periority goes to id.
	partial link text --- applicable only for links (with long link text)
*/	
	
public class LocatorConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/saeed/Downloads/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		Thread.sleep(5000); // there are 8 locators in Selenium WebDriver
		
		// 1. by id: is a property locator
//		/*
//		 * // WebElement email = driver.findElement(By.id("username")); //
//		 * email.sendKeys("saeed@gmail.com"); // WebElement pwd =
//		 * driver.findElement(By.id("password")); // pwd.sendKeys("saeed@1233"); // //
//		 * we can also write the code without variable and then sendkey() as builder
//		 * pattern, but first method is recommended, so we can use variable later just
//		 * in case // driver.findElement(By.id("username")).sendKeys("saeed@gmail.com");
//		 * // driver.findElement(By.id("password")).sendKeys("saeed@123"); // // // 2.
//		 * by name: is a property locator // WebElement un =
//		 * driver.findElement(By.name("username")); // un.sendKeys("saeed@gmail.com");
//		 * // WebElement pwd = driver.findElement(By.name("password")); //
//		 * pwd.sendKeys("saeed@1233");
			
		// 3. by xpath: is not a property locator
		//driver.findElement(By.xpath("//*[@id='loginForm']/div/div/input")).click();
		
		// 4. by Css: is not a property locator
//		driver.findElement(By.cssSelector("#loginForm > div > input:nth-child(1)")).sendKeys("saeed@gmail.com");
//		driver.findElement(By.cssSelector("#loginForm > div > input:nth-child(2)")).sendKeys("saeed@123");
		
		//5. by class name: is a property locator. this calss is html class not java class
		// should select the uniqe class name among the class names. in this case we can't use class locator, since there is only one class ""from-control"
		// and its common in both username and password web elements. and we can only use one class to locate the element.
		
		// 6. by link text: only used for links
		driver.findElement(By.linkText("Contact")).click();
		
		// 7. partial link text
		driver.findElement(By.partialLinkText("Sign")).click(); // it is usually used for long link texts. but have to be smart on choosing the partial
		// text from the link text in case there there are similar link texts like Sign in and Sign up for example.
		
		// 8. by tag name
		// driver.findElement(By.ByTagName)
		// driver.quit();
	}

}
