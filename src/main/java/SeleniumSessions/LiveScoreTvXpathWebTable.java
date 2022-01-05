package SeleniumSessions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LiveScoreTvXpathWebTable {

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			WebDriver wd = new ChromeDriver();
//		
			//wd.get("https://www.livesoccertv.com/");
			wd.get("https://www.livesoccertv.com/competitions/spain/primera-division/");
			
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			teamTable(wd, "Real Sociedad");
		//	leagueTable(wd, /*action,*/ "La Liga");
	}
/**
 * this method prints the ranking table of the La Liga teams 
 * @param driver
 * @param teamName
 */
	
	public static void teamTable(WebDriver driver, String teamName) {
		driver.navigate().to("https://www.livesoccertv.com/competitions/spain/primera-division/");
		List<WebElement> teamStat = driver.findElements(By.xpath("//a[@title='"+teamName+"']//parent::td//parent::tr//child::td"));
		for(int i=0; i<teamStat.size()-1; i++) {
			System.out.print("\t" + teamStat.get(i).getText());
		}
		System.out.println("===========================");
	}
		
/**
 * this method prints the ranking table of a given league	
 * @param driver
 * @param leagueTitle
 */
// not working... couldn't find a uniqe xpath for elements. also web server doesn't let browser to be controlled without human.
/*	public static void leagueTable(WebDriver driver, String leagueTitle) {
		List<WebElement> leagueClass = driver.findElements(By.xpath("//div[@id='competitions_bar']//ul//li/a"));
		System.out.println(leagueClass.size());
		
		for(int j=0; j<leagueClass.size(); j++) {
			String leagueName = leagueClass.get(j).getText();
			if(leagueName.equals(leagueTitle)) {
				driver.navigate().to(leagueClass.get(j).getAttribute("href"));
				List<WebElement> leagueList = driver.findElements(By.xpath("(//td//a[@title='Real Sociedad']//ancestor::table[@id='fixtures'])[2]//tr//td/a"));
				System.out.println(leagueList.size());
				for (int k=0; k<leagueList.size(); k++) {
					String team = leagueList.get(k).getText();
					leagueTable(driver, team);
				}
					
			}
				
			}
		
	}
*/
}
