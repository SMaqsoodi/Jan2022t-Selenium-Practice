package SeleniumSessions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPopUpHandle {

	// alert only works for javascript PopUps
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		wd.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
//		wd.findElement(By.name("proceed")).click();
//		
//		Thread.sleep(5000);
//		
//		Alert al = wd.switchTo().alert();
//		String alText = al.getText();
//		System.out.println(alText);
//		
//		if(alText.equalsIgnoreCase("please enter a valid user name")) {
//			System.out.println("correct error message!");
//		}
//		else {
//			System.out.println("incorrect error message!");
//		}
//		al.accept(); // click on Ok button
//		// al.dismiss(); // to cancel the alert
		
		// generic method approach
		AlertPopUpUtils.alertPopUp(wd, By.name("proceed"), "please enter a valid user name");

	}

}
