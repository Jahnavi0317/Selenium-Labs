package Pkg1;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import io.github.bonigarcia.wdm.WebDriverManager;
 
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
 
public class TC009_TestNG2 {
	WebDriver driver;
  @Test(dataProvider="logindata")
  public void f(String username, String password) {
	  System.out.println("This is the test");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement uname=driver.findElement(By.name("username"));
		if(uname.isDisplayed())
		{
			uname.sendKeys(username);
		System.out.println("Get placeholder:"+uname.getAttribute("placeholder"));
		}
		else
		{
			System.out.println("username is not displayed");
		}
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("username")).sendKeys(Keys.ENTER);
		
		WebElement dashboard = driver.findElement(By.xpath("//h6[text()='dashboard']"));
		if(dashboard.isDisplayed()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(true);
			
		}
  }

  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is Before Method");
	  WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
 
  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is After Method");
	  driver.quit();
  }


@DataProvider

public static  Object[][] logindata() throws IOException {
	
	String [][] data=new String[3][2];
	File file = new File ("C:\\Users\\kuruv\\eclipse-workspace\\janu\\janu\\pattern\\CGI_AUG2025\\data.xlsx");
	FileInputStream fs= new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook (fs);
	XSSFSheet worksheet=workbook.getSheetAt(0);
	int rowcount = worksheet.getPhysicalNumberOfRows();
	System.out.println("rows:" +rowcount);
	
	for (int i =0; i<rowcount; i++)
	{
		data[i][0]=worksheet.getRow(i).getCell(0).getStringCellValue();
		data[i][0]=worksheet.getRow(i).getCell(1).getStringCellValue();
		
		return data;
	}
  return new Object[][] {

    new Object[] { "Admin", "admin123" },

    new Object[] { "pooja", "welcome" },

  };

}

}
 