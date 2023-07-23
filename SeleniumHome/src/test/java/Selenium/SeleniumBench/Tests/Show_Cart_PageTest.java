package Selenium.SeleniumBench.Tests;

import org.testng.annotations.Test;

import Selenium.SeleniumBench.Pages.Show_Cart_Page;

public class Show_Cart_PageTest extends Base
{
	@Test
	public void showCart()
	{
		test = report.createTest("Show Cart Page Test");
		Show_Cart_Page showCart = new Show_Cart_Page(driver);
		showCart.cart();
	}
}
