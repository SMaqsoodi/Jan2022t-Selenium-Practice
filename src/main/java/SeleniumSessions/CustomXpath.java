package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomXpath {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
		
		wd.get("https://www.amazon.com/");
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
/*
 * 		//htmltag[@prop='value']
 * 		//input[@id='twotabsearchtextbox']
 * 
 * 		//htmltag[@prop1='value' and @prop2='value']
 *  	//input[@id='twotabsearchtextbox' and @type='text']
 * 		
 * 		when using class in xpath, we should use all classes. in By.xpath we should use only a unique class.
 * 		//input[@class='nav-input nav-progressive-attribute']
 * 		//input[@class='nav-input nav-progressive-attribute' and @type='text']	
 * 
 * 		contains() method in xpath:
 * 		//htmltag[contains(@prop, 'value')]
 * 		//input[contains(@class, 'nav-input nav-progressive-attribut')]
 * 		//input[contains(@class, 'nav-input nav-progressive-attribut') and @type='text']
 * 		//input[contains(@id, 'glowValidationToken')]
 * 		//input[@id='glowValidationToken' and contains(@name, 'glow')]
 * 		//input[@id='glowValidationToken' and contains(@name, '')]   this is also valid mean name with any value
 * 		
 * 		<input id='test_123'>    very handy for dynamic properties. on dynamic pages some times properties get change frequently
 *  	<input id='test_587'>
 * 		<input id='test_445'>
 * 		//input[contains(@id, 'test_'] 
 * 
 * 		//input[contains(@class, 'nav-progressive-attribute')]   gives 1 of 5 --> gives an array very usefull for findelements()
 * 		(//input[contains(@class, 'nav-progressive-attribute')])[index] --> to access unique element
 * 		(//input[contains(@class, 'nav-progressive-attribute')])[position()=1]  similarly position() can be used instead of index
 * 		(//input[contains(@class, 'nav-progressive-attribute')])[last()] --> jumps to the last item
 * 
 * 		text() in xpath: //htmltag[text()='value']
 * 		//span[text()='Explore everyday essentials'][1] ---> applies on text and usefull when other props like id and name is not available.
 * 		//*[text()='Explore everyday essentials']
 * 		
 * 		**NOTE: text() can by applied for text but contains() can be applied for properties of an element and has 2 parameters
 * 		**NOTE: be careful with ' and "" in texts including terms like "don't", "Ali's book" which can cause confusion
 * 
 * 		a combination of cantains() and tex() can be used
 * 		//span[contains(text(), 'Explore everyday essentials')] // all text
 * 		//span[contains(text(), 'essentials')] // partial text
 * 
 * 		more valid xpath (different url):
 * 		//span[text()='Saeed']
 * 		//span[starts-with(@class, 'account')]
 * 		//span[starts-with(text(), 'Saeed')]	--> combination of starts-with() and text()		
 * 
 * 		//*[@id='username'] --> * means any tag, means any element, but it is not recommended because it is general and check for all tags which is time kiling
 * 		
 * 		//htmltag/htmltag ---> direct child
 * 		//htmltag//htmltag ---> indirect child
 * */
		WebElement todayDeals = wd.findElement(By.xpath("//a[text()='Customer Service' and contains(@class, 'nav')]"));
		Actions action = new Actions(wd);
		action.click(todayDeals).build().perform();
		String text = wd.findElement(By.xpath("(//h3[contains(@class, 'a-spacing-none a-text-normal')])[1]")).getText();
		boolean display = wd.findElement(By.xpath("(//h3[contains(@class, 'a-spacing-none a-text-normal')])[1]")).isDisplayed();
		System.out.println(display);
	}

}
