package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalImgCount {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.amazon.ca");
		
		// findElements(By.tagName is usually used for list of links and images...
		List<WebElement> imgInput = wd.findElements(By.tagName("img")); // to filter text boxes from check boxes we can use xpath 
		
		System.out.println("total number of images are: " + imgInput.size());
		for(int i=0; i<imgInput.size(); i++) {
			String imgUrl = imgInput.get(i).getAttribute("src");
			System.out.println(imgUrl);
		}
		
		Thread.sleep(5000);
		wd.close();
	}
}
