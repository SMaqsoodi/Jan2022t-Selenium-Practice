package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/saeed/Downloads/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.navigate().to("https://amazon.in/");
		System.out.println(driver.getTitle());
		/*
		 * get() and navigate().to() are both launching URLs. but in get methods it let the page fully loaded then execute next command. but navigate does not 
		 * wait for the page to be fully loaded.
		 */
		
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		
		driver.close();
	}

}
/* Selenium WebDriver interface has many abstract methods like get(String url), quit(), close(), getWindowHandle(), getWindowHandles(), getTitle() etc.

WebDriver has nested interfaces like Window, Navigation, Timeouts etc. These nested interfaces are used to perform operations like back(), forward() etc.
*/
