package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Varzesh3WebTablePractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();

		wd.get("https://www.varzesh3.com/");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		List<WebElement> teamStat = wd.findElements(By.xpath("//div[@class='competition-widget-template']//table//tbody//tr//td[2]//span"));
		System.out.println(teamStat.size());
		for(int i=0; i<teamStat.size(); i++) {
			System.out.print(teamStat.get(i).getText());
		}
		System.out.println("===========================");
		
		//rankTable(wd);

	}
/**
* this method prints the ranking table of the La Liga teams 
* @param driver
* @param teamName
*/

	public static void rankTable(WebDriver driver) {

		List<WebElement> teamStat = driver.findElements(By.xpath("//div[@class='competition-widget-template']//table//tbody//tr//td[1]"));
		System.out.println(teamStat.size());
		for(int i=0; i<teamStat.size(); i++) {
			System.out.print(teamStat.get(i).getText());
		}
		System.out.println("===========================");
	}


}
