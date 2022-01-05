package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup(); // first we need to add WebDriverManager Maven dependency to pom file from:
		//https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager
		// then with above command, we no longer need to download the intermediate server every time. or if it gets updated.
		WebDriver driver = new ChromeDriver(); 
		driver.get("http://www.amazon.com");
		
		Thread.sleep(5000);
		driver.close();
	}

}
