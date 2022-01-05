package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
// it is identified by frame tag on source page. frame is not a window, not alert but it can have multiple web elements.	
		wd.get("http://www.londonfreelance.org/courses/frames/index.html");
		
		
		// 1. by creating a web element and switching web driver to the frame element
//		WebElement fElement = wd.findElement(By.name("main"));
//		wd.switchTo().frame(fElement);
		
		// 2. by switching directly to the frame without creating web element only if id or name of the frame is available.
//		wd.switchTo().frame("main");
		
		// 3. by switching directly to the frame using frame index.
		wd.switchTo().frame(2);
		
		String frameText = wd.findElement(By.cssSelector("body > h2")).getText();
		System.out.println(frameText);
		
		// do not use driver.close() when done with frame, because it is not a window and it close the main page. instead use below command.
		wd.switchTo().defaultContent();
		
		// if we have nested frames (which will be a very poor design) still we can switch from one to another frame and come back using 
		// wd.switch().parentFrame() method.
		// generally using frame in web application is not common and not considered as a good practice!
		Thread.sleep(5000);
		//wd.close();
	}

}
