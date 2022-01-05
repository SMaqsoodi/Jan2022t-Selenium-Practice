package SeleniumSessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilsScreenShot {

/**
 * this method take a screen shot of a page and save it in the target/screenshot folder of the current project 
 * @param wd
 * @param filename
 */
	public static void takePageScreenShot(WebDriver wd, String filename) {
		File sourceFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("./target/screenshots/"+filename));
		} catch (IOException e) {
			System.out.println("some exception is coming. your file type might not be supported");
			e.printStackTrace();
		}
	}
	
/**
 * this method takes a screen shot of a a given element and saves it in the target/screenshot folder of the current project
 * @param we
 * @param filename
 */
	public static void takeElementScreenShot(WebElement we, String filename) {
		File sourceFile = ((TakesScreenshot)we).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sourceFile, new File("./target/screenshots/"+filename));
		} catch (IOException e) {
			System.out.println("some exception is coming. you might have to correct your locator ...");
			e.printStackTrace();
		}
	}
}
