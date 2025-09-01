
package com.orangehrm.listeners;

import com.aventstack.extentreports.Status;
import com.orangehrm.Base.BAseTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.io.PrintStream;

public class TestListener extends BAseTest implements ITestListener {

    private static final PrintStream extent = null;
	private static final String test = null;

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
            String screenshotPath = screenshotPath.capturescreen(driver, result.getMethod().getMethodName());
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




