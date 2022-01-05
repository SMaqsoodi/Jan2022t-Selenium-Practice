package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextFieldValue {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		// some times we need to read to capture the value of a text field which has a default value to test the functionality. we can
		// only do that if the elements has a "value" attribute
		wd.get("https://mail.rediff.com/cgi-bin/login.cgi");
		wd.findElement(By.id("login1")).sendKeys("test@mycompany.com");
		System.out.println(wd.findElement(By.id("login1")).getAttribute("value"));
		
		Thread.sleep(5000);
		wd.close();
	}

}
