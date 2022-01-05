package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamConcept {
	// stream is applied only on the List
	// Lambda with stream only works with java 1.8 or higher. it is a powerful feature that gives us parallel streaming, filtering options and more

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		By country_options = By.xpath("//select[@id='Form_submitForm_Country']/option");
		
		List<WebElement> country_list = driver.findElements(country_options);
		
		long startTime = System.currentTimeMillis();
		//country_list.stream().forEach(ele -> System.out.println(ele.getText())); //sequential stream - slower than parallel stream
		country_list.parallelStream().forEach(ele -> System.out.println(ele.getText())); // random order - order not maintained / faster / consuming more memory
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
	}

}
