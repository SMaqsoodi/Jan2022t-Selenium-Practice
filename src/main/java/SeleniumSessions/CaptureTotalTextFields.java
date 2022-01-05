package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureTotalTextFields {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		// List<WebElement> listInput = wd.findElements(By.tagName("input")); // using tagname, but both both text fiels and checkbox elements sharing input tage name
		// findElements(By.tagName is usually used for list of links and images...
		
		// 2nd approach, using xpath
//		List<WebElement> listInput = wd.findElements(By.xpath("//input[@type='text']")); // to filter text boxes from check boxes we can use xpath 
//		
//		System.out.println("total number of text fields are: " + listInput.size());
//		for(int i=0; i<listInput.size(); i++) {
//			listInput.get(i).sendKeys("test");
//		}
		// 3rd approach: using a generic method
		
		UtilCaptureTotalTextFields.totalTextFields(wd, "//input[@type='text']");
		Thread.sleep(5000);
		wd.close();
	}

}
