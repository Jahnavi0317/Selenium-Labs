package Pkg1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class Lab06 {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://tutorialsninja.com/demo/index.php?");

        
        driver.findElement(By.linkText("My Account")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.id("input-email")).sendKeys("ushs@gmail.com"); 
        Thread.sleep(1000);
        
        driver.findElement(By.id("input-password")).sendKeys("usha@");     
        Thread.sleep(1000);
        
        driver.findElement(By.cssSelector("input[value='Login']")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"input-limit\"]")).click();
        Thread.sleep(1000);
        
        Select show = new Select(driver.findElement(By.id("input-limit")));
        show.selectByVisibleText("25");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.linkText("Specification")).click();
        Thread.sleep(1000);
        
        
        System.out.println("Specification Tab Text: " + driver.findElement(By.xpath("//*[@id=\"tab-specification\"]")).getText());
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
        Thread.sleep(1000);
        
        
        System.out.println("Success: " + driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText());
        
        driver.findElement(By.name("search")).sendKeys("Mobile");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"description\"]")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[1]/h4/a")).click();
        Thread.sleep(1000);
        
        
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");
        Thread.sleep(1000);
        

        driver.findElement(By.xpath("//*[@id=\"button-cart\"]")).click();
        Thread.sleep(1000);
        
        System.out.println("Success: " + driver.findElement(By.xpath("//*[@id=\"product-product\"]/div[1]")).getText());
        
        driver.findElement(By.xpath("//*[@id=\"product-product\"]/ul/li[3]/a")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[5]/a/i")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
        Thread.sleep(1000);
        
       
        System.out.println("Success: " + driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText());
    
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
        Thread.sleep(1000);
    
    }
    
    
}
        