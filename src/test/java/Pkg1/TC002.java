package Pkg1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002 {
    public static void main(String[] args) {
        // setup driver inside main method
        WebDriverManager.chromedriver().setup();  
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        /*
        System.out.println("Title is: " + driver.getTitle());
        System.out.println("URL is: " + driver.getCurrentUrl());
        System.out.println("Page source is: " + driver.getPageSource());
        */
        driver.navigate().to("https://www.yahoo.com");
    	System.out.println("title is:"+driver.getTitle());
    	driver.navigate().back();
    	System.out.println("After back title is:"+driver.getTitle());
    	driver.navigate().forward();
    	System.out.println("After forward title is:"+driver.getTitle());
    	
    

	driver.quit();
}

}
	
