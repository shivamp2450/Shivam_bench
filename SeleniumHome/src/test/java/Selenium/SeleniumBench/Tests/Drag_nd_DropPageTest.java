package Selenium.SeleniumBench.Tests;

import org.testng.annotations.Test;

import Selenium.SeleniumBench.Pages.Drag_nd_DropPage;

public class Drag_nd_DropPageTest extends Base
{
	@Test
	public void dragAndDrop()
	{
		test = report.createTest("Drag And Drop Page Test");
		Drag_nd_DropPage dragAndDrop = new Drag_nd_DropPage(driver);
		dragAndDrop.dragAndDrop();
	}
}
