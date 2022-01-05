package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WAPCaptureErrorText {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://mail.rediff.com/cgi-bin/login.cgi");
		wd.findElement(By.id("login1")).sendKeys("test");
		wd.findElement(By.id("password")).sendKeys("test");
		wd.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000);
		String errorText = wd.findElement(By.id("div_login_error")).getText();
		System.out.println(errorText);
		

	}

}
