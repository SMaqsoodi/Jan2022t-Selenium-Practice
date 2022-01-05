package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandleWithGenericMethod {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		
		//WebElement we = driver.findElement(country);
		/*Select select = new Select(driver.findElement(country));
		select.selectByVisibleText("Canada");*/
		
		//doSelectByVisisbleText(country, "Canada");
		
		//genericSelectDropDown(country, "index",  "10");
		//genericSelectDropDown(country, "visibletext",  "Afghanistan");
		genericSelectDropDown(country, "value",  "India");
		genericSelectDropDown(state, "visibletext",  "Gujarat");
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	public static void doSelectByVisisbleText(By locator, String desiredText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(desiredText);
		
	}
	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		
	}public static void doSelectByValue(By locator, String vlaue) {
		Select select = new Select(getElement(locator));
		select.selectByValue(vlaue);
		
	}
	public static void genericSelectDropDown(By locator, String selectType, String value) {
		Select select = new Select(getElement(locator));
		
		switch (selectType) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "visibletext":
			select.selectByVisibleText(value);
			break;
		default:
			System.out.println("please pass the correct selection");
			break;
		
		}
	}
}
