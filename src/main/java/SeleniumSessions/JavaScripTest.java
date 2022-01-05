package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScripTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();

		wd.get("https://classic.freecrm.com/index.html");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println(JavaScriptUtil.getTitleByJS(wd));
		//JavaScriptUtil.generateAlert(wd, "hello");
		System.out.println(JavaScriptUtil.getBrowserInfo(wd));
//		
//		WebElement loginBtn = wd.findElement(By.xpath("//input[@class='btn btn-small']"));
//		JavaScriptUtil.clickElementByJs(loginBtn, wd);
		
		WebElement loginBtn = wd.findElement(By.xpath("//input[@class='btn btn-small']"));
		JavaScriptUtil.drawBorder(loginBtn, wd);
		
	}

}
