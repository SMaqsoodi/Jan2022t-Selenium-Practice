package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SynchWithImplicit {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html?e=1");
		//driver.get("https://app.hubspot.com/login");
/*
 * applied on all elements through driver
 * global wait which means this 20 second applies on all elements
 * dynamic wait	
 * if element not found throws NoSuchElement Exception
 * its only and only for elements not titles or urls 	
 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		WebElement emailId = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement loginButton = driver.findElement(By.className("btn-small"));
		
		emailId.sendKeys("test@gmail.com");
		password.sendKeys("test@123");
		loginButton.click();
	}

}
