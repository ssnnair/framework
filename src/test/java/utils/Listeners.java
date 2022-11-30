package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import resources.Action_Reusable;
import tests.BaseTest;

public class Listeners implements ITestListener {
	AndroidDriver driver;

	ExtentReports extent = ExtentReporterNG.getReorterObject();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, " Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getThrowable());
		String screenshot = result.getMethod().getMethodName();
		try {

			driver = (AndroidDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		}

		catch (Exception e1) {

			e1.printStackTrace();

		}
		try {

			// test.addScreenCaptureFromPath(getScreenshot(result.getMethod().getMethodName(),
			// driver), result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(Action_Reusable.getScreenshot(screenshot, driver));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

}
