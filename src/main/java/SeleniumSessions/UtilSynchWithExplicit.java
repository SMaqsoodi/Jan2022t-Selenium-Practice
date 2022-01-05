package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// this is method can be found in UtilEelement() too
public class UtilSynchWithExplicit {
	public void genericExplicitWait(WebDriver driver, By locator, int timeOutInSecond) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSecond);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
}
