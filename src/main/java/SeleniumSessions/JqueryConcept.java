package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryConcept {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.jqueryscript.net/demo/multi-select-tree/");
		// 3 valid xpath for the same list: 
		//   /html/body/div[2]/span[1] 
		//   (//span[contains(@class, 'treeSelector')])[1]
		//   //ul//li//input[@name='mySelect2[]']
		wd.findElement(By.xpath("(//span[contains(@class, 'treeSelector')])[2]")).click();
		
		// ((//input[contains(@name, 'mySelect2')]))[1]
		// ((//input[contains(@name, 'mySelect2')]))[5]
		//((//input[contains(@name, 'mySelect2')]))[14]

		By locator = By.xpath("//ul//li//input[@name='mySelect2[]']");
		//checkBoxSelect(wd, locator, "Google Search", "iPhone 13", "Consumer Electronics");
		checkBoxSelect(wd, locator, "AlL");
	}
/**
 * this method is used to select multiple check boxes 
 * @param wd
 * @param locator
 * @param value
 */
	public static void checkBoxSelect(WebDriver wd, By locator, String... value) {
		
		List<WebElement> weList = wd.findElements(locator);
		if(!value[0].equalsIgnoreCase("All")) {
			
			for(int i=0; i<weList.size(); i++) {
				String text = weList.get(i).getAttribute("value");
				for(int j=0; j<value.length; j++) {
					if(text.equals(value[j])) {
						weList.get(i).click();
						System.out.println(text);
						break;
					}
				
				}
			}
		}
		else {
			try {
				for(int i=0; i<weList.size(); i++) {
					System.out.println(weList.get(i).getAttribute("value"));
					weList.get(i).click();
				}
			}
			catch(Exception e) {
				System.out.println("some exception is coming ... max 3 choices are allowed.");
				e.getMessage();
			}
		
		}
	}
}
