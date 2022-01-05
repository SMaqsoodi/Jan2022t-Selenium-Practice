package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class PeriorityPracticeTest {

	WebDriver driver;
	
	By uName = By.name("username");
	By pWord = By.name("password");
	By loginBtn = By.xpath("//input[@class='btn btn-small']");
	
	By signUpLink = By.linkText("Sign Up");
	By HomeLink = By.linkText("Home");
	By logoText = By.xpath("//td[@class='logo_text']");
	
	// if you have all annotations the sequence will be as below;
	
	/*
	 * BS --> only once
	 * BT --> only once
	 * BC --> only once
	 * 
	 * BM
	 * Test1
	 * AM
	 * 
	 * BM
	 * Test2
	 * AM
	 * 
	 * AC --> only once
	 * AT --> only once
	 * AS --> only once
	 */
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("before suite --> preparing test data");
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("before test --> DB connection");
	}
	@BeforeClass 
	public void beforeClass() {
		System.out.println("before class --> get the value from DB");
	}
	@BeforeMethod 

	public void beforeMethod() {
		System.out.println("before method --> setup");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void signUpLinkTest() {
		Assert.assertTrue(driver.findElement(signUpLink).isDisplayed());
	}
	@Test(priority=2, enabled=false)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}
	
	@Test(priority=3, enabled=false)
	public void loginTest() {
		driver.findElement(uName).sendKeys("SMaqsoodi");
		driver.findElement(pWord).sendKeys("sudn@1357");
		driver.findElement(loginBtn).click();
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("CRMPRO", homePageTitle);
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("after method --> quitting browser");
		driver.quit();
	}
	@AfterClass
	public void afterClass() {
		System.out.println("after class --> delete user");
	}
	@AfterTest
	public void afterTest() {
		System.out.println("after test --> disconnect the DB");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("after suite --> delete test data");
	}
	
}

