package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AirCanadaCalandarHandling {

	//static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aircanada.com/us/en/aco/home.html#/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
			
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='departureDateLabel']/div/span")).click();
		departureDate(driver, "December", "10");
		
		//driver.findElement(By.xpath("(//*[@id='returnDateLabel']/div/span)[1]")).click();
		returnDate(driver, "March", "15");
	}
	public static void departureDate(WebDriver driver, String depMonth, String depDay) {
		String month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		while (!month.equalsIgnoreCase(depMonth)) {
			driver.findElement(By.xpath("//a[@data-event='click']")).click();
			month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		}
		List<WebElement> daysOfTheMonth = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		for(WebElement we: daysOfTheMonth) {
			if(we.getText().equals(depDay)) {
				we.click();
				break;
			}
		}
	}
	
	public static void returnDate(WebDriver driver, String retMonth, String retDay) {
		String month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		while (!month.equalsIgnoreCase(retMonth)) {
			driver.findElement(By.xpath("//a[@data-event='click']")).click();
			month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		}
		List<WebElement> daysOfTheMonth = driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		for(WebElement we: daysOfTheMonth) {
			if(we.getText().equals(retDay)) {
				we.click();
				break;
			}
		}
	}


}
