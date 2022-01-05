package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


//Assertion vs verify: verify is called soft assertion
//HardAssertion vs SoftAssertion


public class HardAssertionVsSoftAssertionCase1 {
	
	WebDriver driver;
	
	By uName = By.name("username");
	By pWord = By.name("password");
	By loginBtn = By.xpath("//input[@class='btn btn-small']");
	By signUpLink = By.linkText("Sign Up");
	By logoText = By.xpath("//td[@class='logo_text']");
	
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://classic.freecrm.com/index.html");
		
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
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
