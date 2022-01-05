package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPupUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		wd.findElement(By.name("upfile")).sendKeys("/home/saeed/Downloads/desktop.ini"); // it is a button but a file upload button so can't use
		// click(). so we use sendKeys() along with the location of the file
		// also when we inspect the web element on the page, type="file" attribute should be there. if not it can't upload an file. we might need to talk to 
		// UI developer to fix the code.
		
		
		

	}

}
