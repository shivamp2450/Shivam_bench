package Selenium.SeleniumBench.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Show_Cart_Page 
{
	WebDriver driver;
	
	public Show_Cart_Page(WebDriver wd)
	{
		driver = wd;
	}
	
	By selectCart = By.xpath("//span[@class='cartcontents']");
	
	public void cart()
	{
		driver.findElement(selectCart).click();
	}
}
