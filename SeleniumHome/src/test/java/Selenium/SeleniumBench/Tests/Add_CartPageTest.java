package Selenium.SeleniumBench.Tests;

import org.testng.annotations.Test;

import Selenium.SeleniumBench.Pages.Add_CartPage;

public class Add_CartPageTest extends Base
{
	@Test
	public void addToCart()
	{
		test = report.createTest("Add To Cart Page Test");
		Add_CartPage addToCart = new Add_CartPage(driver);
		addToCart.cart();
	}
}
