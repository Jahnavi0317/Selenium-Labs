package Pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	 
	public class LoginPage {
	WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			// TODO Auto-generated constructor stub
		}
		By uname=By.name("username");
		By pword=By.name("password");
		By submit=By.xpath("//button[@type='submit']");
		By Dashboard=By.xpath("//h6[text()='Dashboard']");
		
		public void enterusername(String username)
		{
			driver.findElement(uname).sendKeys(username);
		}
		public boolean usernameisdisplayed()
		{
			return driver.findElement(uname).isDisplayed();
		}
		public String unamegetattributevalue()
		{
			return driver.findElement(uname).getAttribute("placeholder");
		}
		public boolean dashisdisplayed()
		{
			return driver.findElement(Dashboard).isDisplayed();
		}
		public void enterpassword(String password)
		{
			driver.findElement(pword).sendKeys(password);
		}
		public void clickonbutton()
		{
			driver.findElement(submit).click();
		}
	}