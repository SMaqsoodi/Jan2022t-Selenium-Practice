package SeleniumSessions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
// use case for findElements()
public class TotalPageLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.amazon.ca");
		
		List<WebElement> totalLinklist = wd.findElements(By.tagName("a"));
		System.out.println(totalLinklist.size());
		for(int i=0; i<totalLinklist.size(); i++) {
			String text = totalLinklist.get(i).getText();
			if(text.isEmpty() == false) { // to avoid printing empty link texts 
			System.out.println(text);
			}
		}
	}

}
