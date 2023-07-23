package Selenium.SeleniumBench.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Selenium.SeleniumBench.Action.Action;

public class Drag_nd_DropPage
{
	WebDriver driver;
	
	public Drag_nd_DropPage(WebDriver wd)
	{
		driver = wd;
	}
	
	By selectDemoSite = By.xpath("//a[text()='Demo Site']");
	By selectInteractions  = By.xpath("//a[text()='Interactions ']");
	By selectDragAndDrop = By.xpath("//a[text()='Drag and Drop ']");
	By selectStatic = By.xpath("//a[text()='Static ']");
	By selectCloseButton = By.linkText("Close");
	By selectDragableItemAngular = By.id("angular");
	By selectDropAbleArea = By.xpath("//div[@id='droparea']");
	
	public void dragAndDrop()
	{
		driver.findElement(selectDemoSite).click();
		
		// Craete an object of pre-define Actions class
		Actions act = new Actions(driver);
		
		// wait for element until element not found
		Action.waitForElement(driver,selectInteractions);
		
		// Mouse hover action on an element using action class
		WebElement interactionElement = driver.findElement(selectInteractions);
		act.moveToElement(interactionElement).build().perform();
		
		// Mouse hover action on a sub-element using action class
		WebElement dragAndDropElement = driver.findElement(selectDragAndDrop);
		act.moveToElement(dragAndDropElement).build().perform();
		
		// Mouse hover action on a sub-element using action class
		WebElement staticElement = driver.findElement(selectStatic);
		act.moveToElement(staticElement);
		act.click().build().perform();
		
		// wait for element until element not found
		Action.waitForElement(driver,selectDragableItemAngular);
		
		WebElement DragableItemAngular = driver.findElement(selectDragableItemAngular);
		WebElement DropAbleArea = driver.findElement(selectDropAbleArea);
		
		// drag and drop perform
		act.dragAndDrop(DragableItemAngular, DropAbleArea).build().perform();
	}

}
