package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetDropDownValues {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		WebElement day = wd.findElement(By.id("day"));
		WebElement month = wd.findElement(By.id("month"));
		WebElement year = wd.findElement(By.id("year"));
		
//		Select select = new Select(month);
//		List<WebElement> monthList = select.getOptions();
//		System.out.println("total number elements in " + month + "web element is: " + monthList.size());
//		for(WebElement str : monthList) {
//			String text = str.getText();
//			System.out.println(text);
//		}
		// using a generic method from MySeleniumUtils class:
		ArrayList<String> yearList = UtilDropDown.getDropDownOptions(year);
		System.out.println(yearList);
		ArrayList<String> monthList = UtilDropDown.getDropDownOptions(month);
		System.out.println(monthList);
		ArrayList<String> dayList = UtilDropDown.getDropDownOptions(day);
		System.out.println(dayList);
		
		Thread.sleep(5000);
		wd.close();
	}

}
