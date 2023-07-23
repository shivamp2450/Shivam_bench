package Selenium.SeleniumBench.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Selenium.SeleniumBench.Action.Action;

public class Slider_Page
{
	WebDriver driver;
	
	public Slider_Page(WebDriver wd)
	{
		driver = wd;
	}
	
	By selectDemoSite = By.xpath("//a[text()='Demo Site']");
	By selectWidget = By.xpath("//a[text()='Widgets']");
	By selectSlider = By.xpath("//a[text()=' Slider ']");
	By selectPointer = By.xpath("//a[@class='ui-slider-handle ui-state-default ui-corner-all']");
	
	
	public void sliderPage()
	{
		driver.findElement(selectDemoSite).click();
		
		// Craete an object of pre-define Actions class
		Actions act = new Actions(driver);
		
		// wait for element until element not found
		Action.waitForElement(driver, selectWidget);
		
		// Mouse hover action on an element using action class
		WebElement widgetElement = driver.findElement(selectWidget);
		act.moveToElement(widgetElement).build().perform();
		
		// Mouse hover action on an element using action class
		WebElement sliderElement = driver.findElement(selectSlider);
		act.moveToElement(sliderElement);
		act.click().build().perform();
		
		// wait for element until element not found
		Action.waitForElement(driver, selectPointer);
		
		// Slider perform
		WebElement element = driver.findElement(selectPointer);
		act.dragAndDropBy(element, 320, 0).build().perform();
	}
}
