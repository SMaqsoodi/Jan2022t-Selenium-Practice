package SeleniumSessions;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamAndFiltering {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		By links = By.tagName("a");
		
		List<WebElement> linkList = driver.findElements(links);
		System.out.println(linkList.size());
		long startTime = System.currentTimeMillis();
		
		List<String> collectedList = linkList
											.stream()
												.filter(ele -> !ele.getText().equals(""))
													.map(ele -> ele.getText().trim())
														.collect(Collectors.toList());
		//collectedList.stream().forEach(ele -> System.out.println(ele)); // 7768
		collectedList.parallelStream().forEach(ele -> System.out.println(ele));  // 7293
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);

	}

}
