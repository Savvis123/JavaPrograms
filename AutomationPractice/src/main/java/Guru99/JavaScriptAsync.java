package Guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;	

public class JavaScriptAsync {
	@Test		
    public void Login() 					
    {		
        		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	  //Creating the JavascriptExecutor interface object by Type casting		
        JavascriptExecutor js = (JavascriptExecutor)driver;		
        		
        //Launching the Site.		
        driver.get("http://demo.guru99.com/V4/");			
     
          //Maximize window		
          driver.manage().window().maximize();		
        		
          //Set the Script Timeout to 20 seconds		
          driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);			
             
          //Declare and set the start time		
          long start_time = System.currentTimeMillis();			
                   
          //Call executeAsyncScript() method to wait for 5 seconds		
          js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");			
          		
         //Get the difference (currentTime - startTime)  of times.		
         System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));	
         
         driver.findElement(By.name("uid")).sendKeys("mngr34926");					
         driver.findElement(By.name("password")).sendKeys("amUpenu");					
         WebElement button =driver.findElement(By.name("btnLogin"));	
         //Perform Click on LOGIN button using JavascriptExecutor		
         js.executeScript("arguments[0].click();", button);
         
}
}
