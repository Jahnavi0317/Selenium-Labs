
package com.orangehrm.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orangehrm.Base.BAseTest;
import com.orangehrm.utilities.ExtentManager;
import com.orangehrm.utilities.ScreenshotUtilities;

public class TestListener extends BAseTest implements ITestListener {

	private static ExtentReports extent = ExtentManager.getInstance();
	private static ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());

		try {

			String screenshotPath = ScreenshotUtilities.capturescreen(driver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) {
		System.out.println("====== Test Suite Started: " + context.getName() + " ======");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		System.out.println("====== Test Suite Finished: " + context.getName() + " ======");
	}
}




