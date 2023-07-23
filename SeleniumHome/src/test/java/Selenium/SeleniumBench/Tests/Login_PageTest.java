package Selenium.SeleniumBench.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium.SeleniumBench.Pages.Login_Page;
import Selenium.SeleniumBench.Utils.ReadPropertiesFile;

public class Login_PageTest extends Base
{
	@Test
	public void login()
	{
		test = report.createTest("Login Page Test");
		String [] expectedText = ReadPropertiesFile.prop.getProperty("username").split("@");
		Login_Page login_page = new Login_Page(driver);
		String actualText = login_page.login();
		Assert.assertEquals(actualText, expectedText[0]);
	}
}
