package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SynchWithExplicit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html?e=1");
		
/*
 * it is in the form of WebDriver
 * applied on specific element not all elements
 * it is not a global wait which means this 20 second applies on s specific element
 * dynamic wait	in nature
 * if element not found throws TimeOut Exception with 500 millisecond intervals
 * it can be used for titles and urls
 */
		WebDriverWait waitForTitle = new WebDriverWait(driver, 10);
		waitForTitle.until(ExpectedConditions.titleContains("Free CRM"));
		//waitForTitle.until(ExpectedConditions.urlContains("freecrm"));
		System.out.println(driver.getTitle());
		
		// page objects:
		By userName = By.name("username");
		By passWord = By.name("password");
		By login = By.className("btn-small");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(userName));
//      it is useless and waste of time to put wait for other elements since they are visible almost at the same time
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(passWord));
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(login));

		WebElement emailId = driver.findElement(userName);
		WebElement password = driver.findElement(passWord);
		WebElement loginButton = driver.findElement(login);
		
		emailId.sendKeys("test@gmail.com");
		password.sendKeys("test@123");
		loginButton.click();
		
		
	}

}
