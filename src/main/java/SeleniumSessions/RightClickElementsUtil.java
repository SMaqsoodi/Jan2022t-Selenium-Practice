package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RightClickElementsUtil {

/**
 * this method receive Web Driver and By locator of a right click element, 
 * and returns all item of the right click element in an ArrayList
 * @param wd
 * @param locator
 * @return
 */
	public static ArrayList rightClickItems(WebDriver wd, By locator) {
		List<WebElement> rightClickElements = wd.findElements(locator);
		String text;
		ArrayList arr = new ArrayList();
		for(int i=0; i<rightClickElements.size(); i++) {
			arr.add((rightClickElements.get(i).getText()));
		}
		return arr;
	}

}
