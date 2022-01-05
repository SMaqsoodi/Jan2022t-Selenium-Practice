package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutUsingSelect { // interveiw question

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
		
//		List<WebElement> monthList = wd.findElements(By.xpath("//select[@id='month']/option"));
//		System.out.println("there are " + monthList.size() + " elements on the list");
//
//		for(int i=0; i<monthList.size(); i++) {
//			String text = monthList.get(i).getText();
//			System.out.println(text);
//			if(text.equals("Jan")) {
//				monthList.get(i).click();
//				System.out.println("Happy new Year!");
//				break;
//			}
//			
//		}
		// using generic method:
		String day = "//select[@id='day']/option";
		UtilDropDown.dropDownWithoutUsingSelect(wd, day, "19");
		
		String month = "//select[@id='month']/option";
		UtilDropDown.dropDownWithoutUsingSelect(wd, month, "Mar");
		
		String year = "//select[@id='year']/option";
		UtilDropDown.dropDownWithoutUsingSelect(wd, year, "2000");
		
		Thread.sleep(5000);
		wd.close();
	}

}
