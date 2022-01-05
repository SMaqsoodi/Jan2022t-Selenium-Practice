package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

// this drag and drop applies only on web elements not files from your computer or another location
public class DragAndDrop {

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver wd = new ChromeDriver();
			
			wd.get("http://jqueryui.com/resources/demos/droppable/default.html");
			
			UtilActions util = new UtilActions(wd);
			By drag = By.id("draggable");
			By drop = By.id("droppable");
			util.dragAndDrop(drag, drop);
			
//			WebElement draggable = wd.findElement(By.id("draggable"));
//			WebElement droppable = wd.findElement(By.id("droppable"));
//			
//			Actions action = new Actions(wd);
//			action.moveToElement(draggable).clickAndHold(draggable).release(droppable).build().perform();
//			
//			UtilsScreenShot.takeElementScreenShot(droppable, "droppable.jpg");
//			UtilsScreenShot.takeElementScreenShot(draggable, "dragaable.jpg");
	}

}
