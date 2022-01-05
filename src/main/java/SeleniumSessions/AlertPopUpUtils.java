package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPopUpUtils {

	public static void alertPopUp(WebDriver wd, By locator, String correctErrmsg) throws InterruptedException {
		
		wd.findElement(locator).click();
		
		Alert al = wd.switchTo().alert();
		String alText = al.getText();
		System.out.println(alText);
		
		if(alText.equalsIgnoreCase(correctErrmsg)) {
			System.out.println("correct error message!");
		}
		else {
			System.out.println("wrong error message!");
		}
		al.accept();
	}
}
