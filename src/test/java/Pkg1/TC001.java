package Pkg1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001 {
	
	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
				
//Part01
driver.get("https://tutorialsninja.com/demo/index.php?");
Thread.sleep(1000);

System.out.println("Home Page Title: " + driver.getTitle());
Thread.sleep(1000);

driver.findElement(By.linkText("My Account")).click();
Thread.sleep(1000);

driver.findElement(By.linkText("Register")).click();
Thread.sleep(1000);

System.out.println("Register Page Title: " + driver.getTitle());
Thread.sleep(1000);

driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
Thread.sleep(1000);

System.out.println("Title after Warning: " + driver.getTitle());
Thread.sleep(1000);

WebElement warningMsg = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
System.out.println("Warning Message: " + warningMsg);
Thread.sleep(1000);

//part02
WebElement firstName = driver.findElement(By.xpath("//*[@id=\"input-firstname\"]"));
firstName.sendKeys(" janu ");
Thread.sleep(1000);

driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
Thread.sleep(1000);

String firstNameWarning = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
Thread.sleep(2000);

WebElement lastName = driver.findElement(By.xpath("//*[@id=\"input-lastname\"]"));
lastName.sendKeys("k");
Thread.sleep(1000);

WebElement email = driver.findElement(By.xpath("//*[@id=\"input-email\"]"));
email.sendKeys("ushs@test.com");
Thread.sleep(1000);

WebElement telephone = driver.findElement(By.xpath("//*[@id=\"input-telephone\"]"));
telephone.sendKeys("7026187458");
Thread.sleep(1000);

//part03
WebElement password = driver.findElement(By.xpath("//*[@id=\"input-password\"]"));
password.sendKeys("usha@");
Thread.sleep(1000);

WebElement passwordconfirm = driver.findElement(By.xpath("//*[@id=\"input-confirm\"]"));
passwordconfirm.sendKeys("usha@");
Thread.sleep(1000);

//part04
//radio
driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]")).click();
Thread.sleep(1000);

//privacy policy
driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
Thread.sleep(1000);

//continue
driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
Thread.sleep(1000);

//verify
System.out.println("Your Account Has Been Created!");
Thread.sleep(1000);

//continue
driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
Thread.sleep(1000);

//view
driver.findElement(By.xpath("//*[@id=\"content\"]/ul[2]/li[1]/a")).click();
Thread.sleep(1000);

driver.quit();
	}
}
