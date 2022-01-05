package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_xpath_Axes {
	//xpath Axes are: following, preceding, parent, child, ancestor following by ::
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver wd = new ChromeDriver();
//	xpat Axes are very useful when we need generic xpaths for a number of elements specially in web tables		
		wd.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3Ftag%3Dhydcaabkg-20%26hvadid%3D317597111516%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D444875436263245321%26hvpone%3D%26hvptwo%3D%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D9001558%26hvtargid%3Dkwd-360364907677%26ref%3Dnav_custrec_signin%26hydadcr%3D11827_10790060%26gclid%3DCjwKCAiA1aiMBhAUEiwACw25MWWAOspXaqOCLOEuai30NPRBL-2Cj_4oizYIQXUak4J_byMS4jpOfhoCE54QAvD_BwE&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		//Thread.sleep(5000);
		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
/*
 * 	Absolute xpath: //htmltag//div//div[2]//div[1]//div[3]//div//span -- id    disadvantage: if one html tag changes specially in dynamic pages, the whole xpath is ruined 
 * 	Relative (custom) xpath: //span[@id='test']
 * 
 * 
 *	//div[@class='input-group']//following::input[@name='username'] --> following goes to the next html tags eaither child or sibling tags
 *  (//div[@class='input-group']//following::input)[1]
 *  
 *  (//input[@name='username']//preceding::div)[5]  --> preceding goes to the previous html tags eaither parent or siblings
 *  
 * 	//input[@name='username']//parent::div
 *  //div[@class='input-group']//child::input[@name='username']
 * 
 * 	//span[tex()='naveen k']//ancestor::td//preceding-sibling::td//input   or 
 * 	//span[tex()='naveen k']//ancestor::td//preceding-sibling::td//child::input
 * 	//span[tex()='saeed m']//ancestor::td//preceding-sibling::td//child::input
 * 	
 * 	Reversing Xpath: traversing from child to parent --> grant parent --> super parent --> top parent in DOM
 * 	input[@id='username']/../../../../../../../../..
 * 	dirver.findElement(By.xpath("input[@id='username']/../../../../..")).getAttribute("id");     it is an Absolute xpath not Relative or custom xpath
 */
		Actions action = new Actions(wd);
		
		WebElement eMail = wd.findElement(By.id("ap_email"));
		WebElement continuebutton = wd.findElement(By.id("continue"));
		action.sendKeys(eMail, "saeedreza.maqsoodi@gmail.com").build().perform();
		action.click(continuebutton).build().perform();
			
		WebElement pWord = wd.findElement(By.id("ap_password"));
		WebElement loginbutton = wd.findElement(By.id("signInSubmit"));
		action.sendKeys(pWord, "Sudn@1357").build().perform();
		action.click(loginbutton).build().perform();
		
		Thread.sleep(3000);		
		
		wd.navigate().to("https://www.amazon.com/events/earlyblackfriday?ref_=nav_cs_gb_5d8ef71f209b44c2acab6343d6a5a05e&deals-widget=%257B%2522version%2522%253A1%252C%2522viewIndex%2522%253A0%252C%2522presetId%2522%253A%2522deals-collection-AD%2522%252C%2522sorting%2522%253A%2522BY_CUSTOM_CRITERION%2522%257D");
		
//		WebElement beauty = wd.findElement(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F' and text()='Baby']//preceding-sibling::input[@type='checkbox']"));
//		WebElement baby = wd.findElement(By.xpath("//span[@class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F' and text()='Beauty']//preceding-sibling::input[@type='checkbox']"));
//		action.click(baby).click().perform();
//		action.click(beauty).click().perform();
		selectProduct(wd, action, "Amazon Devices");
		selectProduct(wd, action, "Beauty");
		selectProduct(wd, action, "Electronics");
		
		
	}
	public static void selectProduct(WebDriver driver, Actions action, String pName) {
		//WebElement pElement = driver.findElement(By.xpath("//span[class='CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F' and text()='"+pName+"']//preceding-sibling::input[@type='checkbox']"));
		WebElement pElement = driver.findElement(By.xpath("//div[@class='CheckboxFilter-module__gridFilterOption_hdG5xZdR2ZvDkQKkl_d49']//child::span[text()='"+pName+"']//preceding-sibling::input"));
		action.click(pElement).click().perform();
	
	}

}
