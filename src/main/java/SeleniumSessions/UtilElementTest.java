package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UtilElementTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html?e=1");

		
		// page objects:
		By userName = By.name("username");
		By passWord = By.name("password");
		By login = By.className("btn-small");
		
		System.out.println(driver.getTitle());
		UtilElement util = new UtilElement(driver);
		String title = util.ExplicitWaitForTitle("Free", 5);
		System.out.println(title);
		
		util.ExplicitWaitForElement(userName, 10);
		
		util.getElement(userName).sendKeys("saeed@test");
		util.getElement(passWord).sendKeys("pass@test");
		util.ExplicitWaitForElement(login, 5);
		util.getElement(login).click();
		// Or
//		util.senkeytoElement(userName, "testusername");
//		util.senkeytoElement(passWord, "testpassword");
//		util.clickOnElement(login);
		
//		UtilActions utilActionTest = new UtilActions(driver);
//		utilActionTest.sendKeyByActions(userName, "saeed@gmail.com");
//		utilActionTest.sendKeyByActions(passWord, "test@123");
//		utilActionTest.moveToElementAndClick(login);
		
		Thread.sleep(3000);
		driver.close();
	}

}
