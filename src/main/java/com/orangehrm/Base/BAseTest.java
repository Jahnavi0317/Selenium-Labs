package com.orangehrm.Base;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.orangehrm.utilities.ExtentManager;


public class BAseTest {
	
	protected static WebDriver driver;
	protected static ExtentReports extent;
	public static ExtentTest test;

	@BeforeSuite
	public void setupReport() {
		// Initialize Extent Report
		extent = ExtentManager.getInstance();
	}

	@BeforeMethod
	public void setup() {
		// You can extend this logic for multiple browsers (param from testng.xml)
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@AfterSuite
	public void flushReport() {
		if (extent != null) {
			extent.flush(); // Write all logs to the report at the end
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void pass(String string) {
		// TODO Auto-generated method stub
		
	}

	public static void fail(String string) {
		// TODO Auto-generated method stub
		
	}
}

