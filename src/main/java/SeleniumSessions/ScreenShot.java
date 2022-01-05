package SeleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
// there is getScreenShot() and one TakeScreenShot Interface
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		Thread.sleep(3000);
		// first we have to type cast our driver to TakeScreenShot interface, then use getScreenshotAs() and FileUtils class 
		File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File("./target/screenshots/test.png")); // don't forget to add new File before target file or it won't work
		// 
		
	}

}
