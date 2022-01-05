package TestNGSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertionVsSoftAssertionCase2 {
	WebDriver driver;
	SoftAssert softAssert;
	
	By signUpLink = By.cssSelector("a.link1");
	By uName = By.name("user_login");
	By pWord = By.name("user_pwd");
	By loginButton = By.name("btn_login");
	By logo = By.cssSelector("area.simpli-logo");
	By myCourse = By.xpath("//a[@title='My Courses']");
	By pgProgram = By.xpath("//a[@title='PG Programs']");
	
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://accounts.simplilearn.com/user/login");
		softAssert = new SoftAssert();
		
	}
	
	@Test(priority=1)
	public void SignUpLinkTest() {
		Assert.assertTrue(driver.findElement(signUpLink).isDisplayed());
	}
	
	@Test(priority=2)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals("Learning on Simplilearn", title);
	}
	

	// we can have multiple assertion in a single @test method. in HardAssertion, if any assert fails, the test will be terminated.	
	// in SoftAssertion, if an Assert fails, it will keep in a memory and carries on with other assertions. 
	// but at the end we must use SoftAssert reference varialbe.AssertAll()
	@Test(priority=3)
	public void loginTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(uName).sendKeys("saeedreza.maqsoodi@gmail.com");
		driver.findElement(pWord).sendKeys("SudnDevOps@Caltech2020");
		driver.findElement(loginButton).click();
		wait.until(ExpectedConditions.titleContains("Dashboard"));
		
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		softAssert.assertEquals(homePageTitle, "Dashboard", "home page title is not avaialble");
		
		boolean simpliLogo = driver.findElement(logo).isDisplayed();
		softAssert.assertTrue(simpliLogo, "logo is not availalbe");
		
		softAssert.assertTrue(driver.findElement(myCourse).isDisplayed());
		
		String program = driver.findElement(pgProgram).getText();
		System.out.println(program);
		softAssert.assertEquals(program, "PG Programs", "text mismatched ..."); // in assert we can pass an optional custom error message which will only be displayed if assertion fails
		
		softAssert.assertAll();
		// it is a good practice to use a combination of both Hard and Soft Asserts. if a test case is very important and following tests are relied on that case there is no point for executing other tests so we use Hard Assertion
		// for less important Assertion we can use SoftAssertion.
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
