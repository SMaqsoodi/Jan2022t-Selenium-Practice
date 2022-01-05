package SeleniumSessions;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowPupUpHandle {

	// when we click on a specific link a new browser or a new tab opens
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.toronto.ca/home/covid-19/covid-19-what-you-should-do/covid-19-assessment-centres/");
		wd.findElement(By.linkText("French")).click();
		wd.findElement(By.linkText("Take the Self-Assessment")).click();
		wd.manage().window().maximize();
		
		Set<String> handles = wd.getWindowHandles();
		Iterator<String> it = handles.iterator();
/* WAP: first approach - parent windown --> child1 window --> child2 window --> parent window		
		String parentWindoID = it.next();
			System.out.println("paretn window ID is: " + parentWindoID);
		String child1WindowID = it.next();
			System.out.println("child 1 window ID is: " + child1WindowID);
		
		wd.switchTo().window(child1WindowID);
		System.out.println("child 1 page url is: " + wd.getCurrentUrl());
		System.out.println("child 1 page title is: " + wd.getTitle());
		
		Thread.sleep(5000);
		wd.close(); // close the child1 window pop up
		
		String child2WindowID = it.next();
			System.out.println("child 2 window ID is: " + child2WindowID);
		wd.switchTo().window(child2WindowID);
		System.out.println("child 2 page url is: " + wd.getCurrentUrl());
		System.out.println("child 2 page title is: " + wd.getTitle());
		
		Thread.sleep(5000);
		wd.close(); // close the child2 window pop up
		
		wd.switchTo().window(parentWindoID); // switch back to parent window
			System.out.println("back to parent window");
			System.out.println("parent window title is: " + wd.getTitle());
*/			
// /* WAP: second approach - parent windown --> child1 window --> --> parent window --> child2 window --> parent window				
		String parentWindoID = it.next();
		System.out.println("paretn window ID is: " + parentWindoID);
		String child1WindowID = it.next();
		System.out.println("child 1 window ID is: " + child1WindowID);
	
		wd.switchTo().window(child1WindowID);
		System.out.println("child 1 page url is: " + wd.getCurrentUrl());
		System.out.println("child 1 page title is: " + wd.getTitle());
		
		Thread.sleep(5000);		
		wd.close(); // close the child1 window pop up
		
		wd.switchTo().window(parentWindoID); // back to parent window
		System.out.println("back to parent window from child 1 window!");
		Thread.sleep(5000);
		
		String child2WindowID = it.next();
		System.out.println("child 2 window ID is: " + child2WindowID);
		wd.switchTo().window(child2WindowID);
		System.out.println("child 2 page url is: " + wd.getCurrentUrl());
		System.out.println("child 2 page title is: " + wd.getTitle());
		
		Thread.sleep(5000);
		wd.close(); // close the child2 window pop up	
		wd.switchTo().window(parentWindoID); // switch back to parent window
		System.out.println("back to parent window");
		System.out.println("parent window title is: " + wd.getTitle());
		
		Thread.sleep(5000);
		wd.quit();
			
		// at the same time we can only handle two Window IDs
	}

}
