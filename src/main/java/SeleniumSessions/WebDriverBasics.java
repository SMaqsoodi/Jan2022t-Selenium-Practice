// selenium or selenium web dirver is an automation tool or framework for testing web-based application to make sure it perform expectedly. 

package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/home/saeed/Downloads/chromedriver_linux64/chromedriver"); // we can't interact with application 
		// directly but we have to use an intermediate server called driver executables. for chrome we have chromedriver.exe, for firefox we Geckodriver 
		
		//below steps 1-3 are called automation
		WebDriver driver = new ChromeDriver(); // 1. automated approach for launching Chrome browser. manually we click on Chrome icon.
		driver.get("https://www.google.com");// 2. enter url. this is not original browser but a replica of the original browser. it is called profile browser
		String title = driver.getTitle(); // 3. get the page title
		System.out.println(title); 
		
		// now we have to verify page title programmatically
		// 4. validation point: 
		// once we add step 4, it is called automation testing
		if(title.equals("Google")){
			System.out.println("Correct title!");
		}
		else {
			System.out.println("wrong title!");
		}
		System.out.println(driver.getCurrentUrl());
		// System.out.println(driver.getPageSource());
		driver.quit();
		//driver.close(); // to close the browser. if we run any command after calling close() method, we get this message:
		// Exception in thread "main" org.openqa.selenium.NoSuchSessionException: invalid session id
		
		// if we run a command after quit() method like this:
		System.out.println(driver.getTitle()); // Session ID is null. Using WebDriver after calling quit()? 
		/* the reason is that after the first line of code (here: WebDriver driver = new ChromeDriver();), one session ID will be created which maintains
		 * the session throughout the program. for every command, this session id + method is passed to intermediate server (here is located at /home/saeed/Downloads/chromedriver_linux64/chromedriver)
		 * after executing driver.quit() method this session ID becomes null and that why we get and exception from the intermediate server
		 
		 every time we open a web page in fact we are given a session ID, that is why in some pages or applications depends on the needs, after some time
		 session id is terminated and we get message like "your page or access is expired"  

		difference between quit() and close() methods: 
			after running quit, session id gets null, while after close session id is still there but it is expired.
		 */ 
			
		
		
	}

}
