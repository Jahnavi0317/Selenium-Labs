package com.orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.Base.BAseTest;
import com.orangehrm.utilities.ExcelUtilities;
import com.orangehrm.utilities.ScreenshotUtilities;

import Pkg1.LoginPage;




public class Login_orangehrm {

	private static final WebDriver driver = null;
	static String projectpath = System.getProperty("user.dir");

	@Test(dataProvider = "logindata")
	public void verifylogin(String username, String password) throws IOException {

		WebDriver driver = new ChromeDriver();  
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		LoginPage obj = new LoginPage(driver);   
        obj.enterusername(username);
		obj.enterpassword(password);
		obj.clickonbutton();

		if (obj.dashisdisplayed()) {
			BAseTest.pass("Login is success for user: " + username);
		} else {
			WebDriver driver1;
			String screenshotPath = ScreenshotUtilities.capturescreen(driver, "Verify_login_" + username);

			BAseTest.fail("Login unsuccessful for the user: " + username);
			BAseTest.test.addScreenCaptureFromPath(screenshotPath);
		}

		if(driver.getTitle().equals("orange")) 
		{
			BAseTest.pass("Title is matched");
		} else {
			String screenshotPath = ScreenshotUtilities.capturescreen(driver, "TitleMismatch_" + username);
			BAseTest.fail("Title is not matched");
			BAseTest.test.addScreenCaptureFromPath(screenshotPath);
		}

		driver.quit();
	}

	@DataProvider
	public Object[][] logindata() throws IOException {
		return ExcelUtilities.getdata(
				projectpath + "\\src\\test\\resources\\Orangehrm_Testdata\\data.xlsx",
				"Sheet1"
				);
	}
}