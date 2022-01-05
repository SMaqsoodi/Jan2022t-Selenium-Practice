package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class LoginTest {
	//Before: BS, BT, BC, BM
	//Test: @Test
	//After: AM, AC, AT, AS
	// Assert is a calss name from TestNG not selenium which has many static methods like assertEquals()
	WebDriver driver;
	
	By uName = By.name("username");
	By pWord = By.name("password");
	By loginBtn = By.xpath("//input[@class='btn btn-small']");
	
	By signUpLink = By.linkText("Sign Up");
	//By HomeLink = By.linkText("Home");
	By logoText = By.xpath("//td[@class='logo_text']");
	
	//@BeforeTest // will be executed only once for all tests
	@BeforeMethod // will be executed once for each Test. creates a pair with each test and runs as BM --> T --> AM
	// for small number of test cases BeforeTest approach is better but for large number of test cases BeforeMethod is recommended since the 
	// the chance of getting higher success percentage is higher and browser crash or other problems stays with the failed test only
	// BM consumes more time than BT
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void SignUpLinkTest() {
		Assert.assertTrue(driver.findElement(signUpLink).isDisplayed());
	}
	@Test(priority=2)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("page title is: " + title);
		Assert.assertEquals("Free CRM - CRM software for customer relationship management, sales, and support.", title);
	}
	
	@Test(priority=3)
	public void loginTest() {
		driver.findElement(uName).sendKeys("SMaqsoodi");
		driver.findElement(pWord).sendKeys("sudn@1357");
		driver.findElement(loginBtn).click();
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("CRMPRO", homePageTitle);
	}
	
	//@AfterTest
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
}
