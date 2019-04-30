package BrowsersLaunching;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utility.UtilityMethods;

public class HighlightElement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		  
		 // Create the  JavascriptExecutor object
		  JavascriptExecutor js=(JavascriptExecutor)driver; 
		  
		 // find element using id attribute
		  WebElement username= driver.findElement(By.id("email"));  
		  
		 // call the executeScript method
		  js.executeScript("arguments[0].setAttribute('style,'border: solid 2px red'');", username);
     

	}

}



/*public static void highLightElement(WebDriver driver, WebElement element)
{
JavascriptExecutor js=(JavascriptExecutor)driver; 
 
js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
 
try 
{
Thread.sleep(500);
} 
catch (InterruptedException e) {
 
System.out.println(e.getMessage());
} 
 
js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
 
}*/
