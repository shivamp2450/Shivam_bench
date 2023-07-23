package Selenium.SeleniumBench.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Selenium.SeleniumBench.Action.Action;
import Selenium.SeleniumBench.Utils.ReadPropertiesFile;

public class Login_Page
{
	WebDriver driver;
	
	public Login_Page(WebDriver wd)
	{
		driver = wd;
	}
	
	By selectMyAccount = By.xpath("//a[text()='My Account']");
	By selectUsername = By.id("username");
	By selectPassword = By.id("password");
	By selectButton = By.xpath("//*[@name='login']");
	By selectActualText = By.tagName("strong");
	
	public String login()
	{
		driver.findElement(selectMyAccount).click();
		
		// wait for element until element not found
		Action.waitForElement(driver,selectUsername);
		
		driver.findElement(selectUsername).sendKeys(ReadPropertiesFile.prop.getProperty("username"));
		driver.findElement(selectPassword).sendKeys(ReadPropertiesFile.prop.getProperty("password"));;
		driver.findElement(selectButton).click();
		return driver.findElement(selectActualText).getText();
		
	}
}
