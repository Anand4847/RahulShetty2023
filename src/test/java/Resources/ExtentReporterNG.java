package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseComponent.BaseClass;

public class ExtentReporterNG extends BaseClass{

	public static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter ep = new ExtentSparkReporter(path);
		ep.config().setReportName("Web Automation Results");
		ep.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(ep);
		extent.setSystemInfo("Tester", "Anand Soni");
		return extent;
	}
}
