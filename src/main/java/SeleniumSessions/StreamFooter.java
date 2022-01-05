package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamFooter {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		By footerLinks = By.cssSelector("div.footer__bottom div.container li a");
		
		driver.findElements(footerLinks).stream()
			.filter(ele -> !ele.getText().isEmpty())
				.forEach(ele -> System.out.println(ele.getText().trim()));

	}

}
