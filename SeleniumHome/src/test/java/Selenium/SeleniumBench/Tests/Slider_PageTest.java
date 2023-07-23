package Selenium.SeleniumBench.Tests;

import org.testng.annotations.Test;

import Selenium.SeleniumBench.Pages.Slider_Page;

public class Slider_PageTest extends Base
{
	@Test
	public void slider()
	{
		test = report.createTest("Slider Page Test");
		Slider_Page slider = new Slider_Page(driver);
		slider.sliderPage();
	}
}
