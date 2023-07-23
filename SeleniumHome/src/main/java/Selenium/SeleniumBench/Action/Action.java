package Selenium.SeleniumBench.Action;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.SeleniumBench.Utils.ReadPropertiesFile;

public class Action
{
	public static void waitForElement(WebDriver driver, By element)
	{
		// convert string to int
		int waitForElement = Integer.parseInt(ReadPropertiesFile.prop.getProperty("waitForElement"));
		
		// wait for element
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitForElement));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
}
