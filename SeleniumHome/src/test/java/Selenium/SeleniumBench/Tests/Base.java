package Selenium.SeleniumBench.Tests;

import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Selenium.SeleniumBench.Utils.Extent_Report;
import Selenium.SeleniumBench.Utils.ReadPropertiesFile;
import Selenium.SeleniumBench.Utils.TakeScreenshots;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base
{
	static WebDriver driver;
	static ExtentReports report;
	ExtentTest test;
	
	@BeforeTest
	public void initializeDriver()
	{
		String browserName = ReadPropertiesFile.prop.getProperty("browser");
		// condition to initialize chrome
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		// condition to initialize firefox
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/geckodriver-v0.31.0-win32/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		// condition to initialize ie
		else if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/IEDriverServer_x64_4.3.0/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		// condition to initialize headless mode
		else if(browserName.equals("option"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver_win32/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver = new ChromeDriver(options);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		report = Extent_Report.extentReport();
	}
	
	@BeforeMethod
	public void openURL()
	{
		driver.get(ReadPropertiesFile.prop.getProperty("url"));
	}
	
	@AfterMethod
	public void getReport(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Failed", ExtentColor.RED));
			test.fail(result.getThrowable());
			TakeScreenshots.takeScreenshot(driver, result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Passed", ExtentColor.GREEN));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Skipped", ExtentColor.ORANGE));
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		report.flush();
		driver.quit();
	}
}
