package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WAPHubSpotSignUpPage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/saeed/Downloads/chromedriver_linux64/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://app.hubspot.com/signup-hubspot/crm?loginRedirectUrl=undefined&step=landing_page");
		driver.findElement(By.id("UIFormControl-1")).sendKeys("Saeed");
		driver.findElement(By.name("LAST_NAME")).sendKeys("Maqsoodi");
		driver.findElement(By.xpath("//*[@id=\'UIFormControl-5\']")).sendKeys("test@gmail.com");
		driver.findElement(By.cssSelector("body > div.page > div.ViewContainer > div.ViewComponent > div.FlowStep > div > div > div > div > div:nth-child(4) > form > button")).click();
		driver.findElement(By.linkText("HubSpot Customer Terms of Service")).click();
		
		Thread.sleep(5000);
		driver.close();
	}

}
