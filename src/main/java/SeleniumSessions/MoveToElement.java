package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElement {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
// important: in select calss we always pass WebElement but in Action class we always pass WebDriver		
		wd.get("http://mrbool.com/");
		Actions action = new Actions(wd); // actions class can handle all user actions like: Double-Click, right click, 
		// mouse over, move to a specific element, drag and drop, 
		WebElement contentLink = wd.findElement(By.className("menulink"));
		action.moveToElement(contentLink).build().perform(); // always use build() and perform() at the end of other action
		
		Thread.sleep(3000);
		
		wd.findElement(By.linkText("COURSES")).click(); // used the capital link text from the page since there was no other properties on the source
		wd.close();

	}

}
