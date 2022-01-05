package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html?e=1");
		
		final By userName = By.name("username");
		By passWord = By.name("password");
		By login = By.className("btn-small");
		By signUp = By.linkText("Sign Up");
		
		customWaitForWebElement(driver, userName, 20).sendKeys("SMaqsoodi");
		driver.findElement(passWord).sendKeys("Sudn@1357");
		driver.findElement(login).click();
	}
/**
 * this method provide custom wait without using Wait Interface
 * @param driver
 * @param locator
 * @param timeout
 * @return
 * @throws InterruptedException
 */
	public static WebElement customWaitForWebElement(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		for(int i=0; i<timeout; i++) {
			try {
				element = driver.findElement(locator);
				break;
			}
			catch(Exception e) {
				System.out.println("waiting for the element to be present on the page --> " + i + "secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	
			}
		}
		return element;
	} 
/**
 * this method finds out if element is displayed or not using custom wait method	
 * @param driver
 * @param locator
 * @param timeout
 * @return
 */
	public static boolean customIsElementDisplayed(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		boolean flag = false;
		for(int i=0; i<timeout; i++) {
			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			}
			catch(Exception e) {
				System.out.println("waiting for the element to be present on the page --> " + i + "secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	
			}
		}
		return flag;
	} 

}
