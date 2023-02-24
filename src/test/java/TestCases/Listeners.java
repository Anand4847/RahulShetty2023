package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseComponent.BaseClass;
import Resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test); // will assign 1 unique test id
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		extentTest.get().fail(result.getThrowable());

		// screenshot

		String filepath = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
