package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HeadLessBrowser {

	public static void main(String[] args) {
		// headless means: no UI
		// testing is happenning behind the scene
		// slightly faster than normal UI mode
		
		/*WebDriverManager.chromedriver().setup(); 
		
		ChromeOptions co = new ChromeOptions();
		//co.addArguments("--incognito"); // for privacy purposes. doesn't keep browser history
		co.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(co); // local not remote. also must give ChromeOptions var to the ChromeDriver constructor for headless browser to work
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());*/
	
		WebDriverManager.firefoxdriver().setup(); 
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--incognito"); // for privacy purposes. doesn't keep browser history
		fo.addArguments("--headless");
		
		WebDriver driver = new FirefoxDriver(fo); // local not remote. also must give ChromeOptions var to the ChromeDriver constructor for headless browser to work
		
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		
	}

}
