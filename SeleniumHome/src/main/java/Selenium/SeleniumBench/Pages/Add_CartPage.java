package Selenium.SeleniumBench.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Selenium.SeleniumBench.Action.Action;

public class Add_CartPage
{
	WebDriver driver;
	
	public Add_CartPage(WebDriver wd)
	{
		driver = wd;
	}
	
	By selectShop = By.xpath("//a[text()='Shop']");
	By selectProduct = By.xpath("//h3[text()='HTML5 WebApp Develpment']");
	By addProductToBucket = By.xpath("//button[text()='Add to basket']");
	By viewBucket = By.xpath("//a[text()='View Basket']");
	
	public void cart()
	{
		driver.findElement(selectShop).click();
		
		// wait for element until element not found
		Action.waitForElement(driver, selectProduct);
		driver.findElement(selectProduct).click();
		
		// wait for element until element not found
		Action.waitForElement(driver, addProductToBucket);
		driver.findElement(addProductToBucket).click();
		
		// wait for element until element not found
		Action.waitForElement(driver, viewBucket);
		driver.findElement(viewBucket).click();
	}
}
