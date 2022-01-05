package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class SignUpTest {
	
	WebDriver driver;
		
	By signUpLink = By.cssSelector(".link1");
	By signUpWithGoogle = By.xpath("//span[text()='Sign Up with Google']");
	By loginLink = By.cssSelector("a.link1");
	By register = By.cssSelector(".content-heading ");
	
	
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
		driver.get(url);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void signUpWithGoogleTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.findElement(signUpLink).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(register));
		Assert.assertTrue(driver.findElement(signUpWithGoogle).isDisplayed());
		
	}
	
	@Test(priority=2)
	public void logiLinkTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(register));
		Assert.assertTrue(driver.findElement(loginLink).isDisplayed());
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}
