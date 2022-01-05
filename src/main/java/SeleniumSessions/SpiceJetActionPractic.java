package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetActionPractic {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.spicejet.com/");
		WebElement addOns = wd.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]"));
		Actions action = new Actions(wd);
		action.moveToElement(addOns).build().perform();
		Thread.sleep(3000);
		
		WebElement hotMeals = wd.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[2]/div[1]/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div[1]/div/a[2]/div/div"));
		action.moveToElement(hotMeals).click().build().perform();
		
		UtilsScreenShot.takePageScreenShot(wd, "spicejet.jpg");	
		}

}
