package BrowsersLaunching;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class ScrollUpAndDownExamples extends Base {
	
	//@Test
	public void scrollUpExample() throws InterruptedException
	{
		driver.get("http://jqueryui.com");
		
		  // Wait for 5 second
		  Thread.sleep(5000);
		 
		 // This  will scroll page 400 pixel vertical
	    JavascriptExecutor js= (JavascriptExecutor)driver;
       js.executeScript("scroll(0,400)");	
        
        js.executeScript("scroll(0,-400)");		

	}
	
	
	@Test
	public void scrollDownExample() throws InterruptedException
	{
		driver.get("http://learn-automation.com/advance-selenium-webdriver-tutorials/");
		
		Thread.sleep(5000);
		
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		//Horizontal scroll
		jse.executeScript("scroll(4000,0)");
		
		//scroll down 
		 jse.executeScript("scroll(0,900)");	
		 
		 System.out.println("scroll down happened");
		 
		 Thread.sleep(7000);
		jse.executeScript("scroll(0,-900)");
		
		 System.out.println("scroll Up happened");
		
	}
	

}
