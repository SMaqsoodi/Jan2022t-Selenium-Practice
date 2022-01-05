package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
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
	@Parameters({"url", "browser"})
	public void setup(String url, String browserName) throws Exception {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("pleaes pass a correct browser name ... ");
			throw new Exception("NoSuchBrowserException"); // creating our own exception 
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
		softAssert = new SoftAssert();
		
	}
	
	@Test(priority=1) // we can use enabled=flase or exclude in xml file to avoid running a test
	public void SignUpLinkTest() {
		Assert.assertTrue(driver.findElement(signUpLink).isDisplayed());
	}
	
	@Test(priority=2)
	public void pageTitleTest() {
		String title = driver.getTitle();
		System.out.println("Login page title is: " + title);
		Assert.assertEquals("Learning on Simplilearn", title);
	}

	@Test(priority=3)
	@Parameters({"username", "password"})
	public void loginTest(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(uName).sendKeys(username);
		driver.findElement(pWord).sendKeys(password);
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
		softAssert.assertEquals(program, "PG Programs", "text mismatched ..."); 
		
		softAssert.assertAll();
	
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}
	
}
