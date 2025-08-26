package Pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class Lab08_TestNG_Validlogin {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.get("https://tutorialsninja.com/demo/");
	  
	  driver.findElement(By.linkText("Desktops")).click();
      driver.findElement(By.linkText("Mac (1)")).click();
      Thread.sleep(2000);
      
      //sort
      WebElement sortDropdown = driver.findElement(By.id("input-sort"));
      sortDropdown.sendKeys("Name (A - Z)");
      Thread.sleep(2000);
      
      //add to cart
      driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/i")).click();
      Thread.sleep(2000);
	  
	  //verify message
      WebElement successMsg = driver.findElement(By.xpath(".//*[@id=\"product-category\"]/div[1]"));
      Assert.assertTrue(successMsg.getText().contains("Success"), "Product added to cart!");
      Thread.sleep(2000);
	 
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

  }
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
