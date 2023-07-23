package Selenium.SeleniumBench.Utils;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshots
{
	public static void takeScreenshot(WebDriver driver, String methodName) throws IOException
	{
		// convert of WebDriver object to TakeScreenshot interface
		TakesScreenshot tc = (TakesScreenshot)driver;
		
		// call getScreenshotAs method to create image file
		File src = tc.getScreenshotAs(OutputType.FILE);
		
		// copy image file to destination
		FileHandler.copy(src, new File("screenshots/"+methodName+".png"));
	}
}
