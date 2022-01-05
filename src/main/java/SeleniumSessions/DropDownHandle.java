package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandle {

	

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		WebElement day = wd.findElement(By.id("day"));
		WebElement month = wd.findElement(By.id("month"));
		WebElement year = wd.findElement(By.id("year"));
//		
//		first approach
		
//		Select selectDay = new Select(day);
//		selectDay.selectByVisibleText("5");
//				
//		Select selectMonth = new Select(month);
//		selectMonth.selectByVisibleText("Feb");
//			
//		Select selectYear = new Select(year);
//		selectYear.selectByVisibleText("1990");
//		

		
// 		second approach using generic wraps/methods
		
		selectValueFromDropDownByText(day, "25");
//		selectValueFromDropDownByText(month, "Apr");
		UtilDropDown.selectValueFromDropDownByIndex(month, 9); // selectByIndex() is used when the web element is constant and never change.
		selectValueFromDropDownByText(year, "1987");

		Thread.sleep(5000);
		wd.close();
		
	}
	public static void selectValueFromDropDownByText(WebElement we, String value) {
			Select select = new Select(we);
			select.selectByVisibleText(value); // selectByVisibleText() has the priority over selectByIndex()
	}

}
