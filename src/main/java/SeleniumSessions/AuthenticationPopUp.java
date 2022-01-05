package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
			
// its only used for some application for example for server login or modem setup. you simply add: username:password@ after // in domain name.
// in case you have to deal with such a scenario and it can't be handled this way, you must ask developer to enable this PopUp
		//wd.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
// if you want a safer approach to not expose the password like above example:
		String username = "admin";
		String password = "admin";
		wd.get("http://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		
		
		Thread.sleep(5000);
		wd.close();
	}

}
