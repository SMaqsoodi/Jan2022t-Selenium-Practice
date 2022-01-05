package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilCaptureTotalTextFields {

	public static void totalTextFields (WebDriver wd, String locator) {
		
		List<WebElement> we = wd.findElements(By.xpath(locator));
		System.out.println("there are " + we.size() + " field text on this page");
		
		for(int i=0; i<we.size(); i++) {
			we.get(i).sendKeys("test");;
		}
		
	}
}
