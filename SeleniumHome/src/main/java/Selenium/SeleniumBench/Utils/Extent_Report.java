package Selenium.SeleniumBench.Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extent_Report
{
	static ExtentSparkReporter spark;
	static ExtentReports report;
	
	public static ExtentReports extentReport()
	{
		report = new ExtentReports();
		spark = new ExtentSparkReporter("report/Extendreport.html");
		report.attachReporter(spark);
		spark.config().setDocumentTitle("Extend Report");
		spark.config().setReportName("Test Result");
		spark.config().setTheme(Theme.DARK);
		return report;
	}
}
