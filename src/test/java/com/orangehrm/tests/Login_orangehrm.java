package com.orangehrm.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.Base.BAseTest;
import com.orangehrm.pages.Loginpage;
import com.orangehrm.utilities.ExcelUtilities;
import com.orangehrm.utilities.screenshotUtilities;

public class Login_orangehrm {

	private static final String extent = null;
	private static final WebDriver driver = null;
	static String projectpath=System.getProperty("user.dir")  ;
	@Test(dataProvider="logindata")
	public void verifylogin(String username, String password) throws IOException

	{    ChromeDriver chromeDriver = new ChromeDriver();
	chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Loginpage obj=new Loginpage(driver);
	obj.enterusername(username);
	obj.enterpassword(password);
	obj.clickonbutton();

	if(obj.dashisdisplayed())

	{
		BAseTest.pass("Login is sucess for user:"+username);

	}
	else
		 BAseTest.fail(" login unsuccess for the user:"+username)).addScreenCaptureFromPath(screenshotUtilities.capturescreen(driver, "Verify login"));


	if((driver.getTitle()).equals("orange"))
	{
		BAseTest.pass("title is matched");
	}
	else
		BAseTest.fail("title is not matched").addScreenCaptureFromPath(screenshotUtilities.capturescreen(driver, "Verify login"));

	}
	@DataProvider
	public Object[][] logindata() throws IOException
	{
		return ExcelUtilities.getdata(projectpath+"\\src\\test\\resources\\Orangehrm_Testdata\\data.xlsx", "Sheet1");
	}

}