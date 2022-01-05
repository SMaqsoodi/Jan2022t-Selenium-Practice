package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilElementTestExplicit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  the best practice is not to use implicitly and explicitly waits together
		// try to avoid using implicitly wait, since its global and applies to all elements.
		// in case you have to use both, just before using explicitly wait, nullify implicitly wait like this:
		// driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.get("https://classic.freecrm.com/index.html?e=1");
		
		By userName = By.name("username");
		By passWord = By.name("password");
		By login = By.className("btn-small");
		By signUp = By.linkText("Sign Up");
		
		UtilElement util = new UtilElement(driver);
		util.clickWhenReady(signUp, 3);
//		System.out.println(util.waitFortitleToBePresent("Free", 3));
//		util.waitForElementToBePresent(userName, 5).sendKeys("SMaqsoodi");
//		util.senkeytoElement(passWord, ("Sudn@1357"));
//		//util.clickOnElement(login); or
//		util.waitForElementToBePresent(login, 3).click(); // if we need some wait for this element too

	}

}
