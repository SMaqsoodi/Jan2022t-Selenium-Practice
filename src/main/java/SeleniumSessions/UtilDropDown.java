package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

// use Ctr + o to see the list of the methods in the class
public class UtilDropDown {
	WebDriver wd;

/**
 * this method is used to select the value from a drop down on the basis of given text.
 * @param we
 * @param value
 */
	public static void selectValueFromDropDownByText(WebElement we, String value) {
		Select select = new Select(we);
		select.selectByVisibleText(value);
	}	
/**
 * 	this method is used to select the value from a drop down on the basis of given index.
 * @param we
 * @param index
 */
	public static void selectValueFromDropDownByIndex(WebElement we, int index) {
		Select select = new Select(we);
		select.selectByIndex(index);
	}	
/**
 * this method is used to returns all the values from drop down in an ArrayList using for each loop. you can use a simple for loop also.	
 * @param we
 */
	public static ArrayList getDropDownOptions(WebElement we) {
	System.out.println("==================================");
	Select select = new Select(we);
	List<WebElement> options = select.getOptions();
	System.out.println("total number elements in this web element is: " + options.size());
	ArrayList<String> arrList = new ArrayList<String>();
	for(WebElement str : options) {
		String text = str.getText();
		arrList.add(text);
	}
	return arrList;
	}
/**
 * this method select a web element without using Select class and Select tag	
 * @param wd
 * @param locator
 * @param value
 */
	
	public static void dropDownWithoutUsingSelect(WebDriver wd, String locator, String value) {  
			
		List<WebElement> elementList = wd.findElements(By.xpath(locator));
		System.out.println("there are " + elementList.size() + " elements on the list");

		for(int i=0; i<elementList.size(); i++) {
			String text = elementList.get(i).getText();
			System.out.println(text);
			if(text.equals(value)) {
				elementList.get(i).click();
				break;
			}
			
		}
	
	}
	
/**
 * this method get the web driver and print total count and src attribute of all images of a page and returns a confirmation message
 * @param driver
 * @return
 */
	public String totalImgCount (WebDriver driver) {
		this.wd = driver;
	
	List<WebElement> imgInput = wd.findElements(By.tagName("img")); // to filter text boxes from check boxes we can use xpath 
	
	System.out.println("total number of images are: " + imgInput.size());
	for(int i=0; i<imgInput.size(); i++) {
		String imgUrl = imgInput.get(i).getAttribute("src");
		System.out.println(imgUrl);
	}	
	String str = "done!";
	return str;
	}
	

}
