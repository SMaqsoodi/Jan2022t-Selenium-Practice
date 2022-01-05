package SeleniumSessions;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.w3schools.com/html/html_tables.asp");
		
		int rowCount = wd.findElements(By.xpath("//table[@id='customers']//tr")).size()-1;
		System.out.println(rowCount);
		//  //*[@id="customers"]/tbody/tr[2]/td[1]
		//  //*[@id="customers"]/tbody/tr[3]/td[1]
		//  //*[@id="customers"]/tbody/tr[7]/td[1]
		String firstpartPath = "//*[@id=\"customers\"]/tbody/tr[";
		String secondPartPath = "]/td[1]";
		String finalPath;
		ArrayList cullumnContent = new ArrayList();
		
		for(int rowNum=2; rowNum<=rowCount+1; rowNum++) {
			finalPath = firstpartPath+rowNum+secondPartPath;
			System.out.println(finalPath);
			String culumnInfo = wd.findElement(By.xpath(finalPath)).getText();
			System.out.println(culumnInfo);
		}
		Thread.sleep(2000);
		wd.close();
	}																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																								

}
