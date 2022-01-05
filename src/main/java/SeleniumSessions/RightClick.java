package SeleniumSessions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClick {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement righClickElement = wd.findElement(By.className("context-menu-one"));
		
		Actions action = new Actions(wd);
		action.contextClick(righClickElement).build().perform(); // contextClick is a method used for right click
		String text = wd.findElement(By.xpath("//ul/li[contains(@class,'context-menu-icon-copy')]/span")).getText(); // ul tag in source is for right click items
		System.out.println(text);
		
		// WAP : calling a generic method to print all items in the right click
		ArrayList righClickitems = new ArrayList();
		righClickitems = RightClickElementsUtil.rightClickItems(wd, By.className("context-menu-item"));
		System.out.println(righClickitems);
	
		
	}

}
