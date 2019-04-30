package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.WebWindow;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class IframesExample {
	
	static WebDriver driver;
	
	public int getFrameNumber(int framenumber)
	{
		List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
		for(int i=0;i<iframes.size();i++)
		{
			driver.findElement(By.id("12345")).click();
			driver.switchTo().defaultContent();
			
		}
		
		
		return framenumber;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://toolsqa.wpengine.com/iframe-practice-page/");
		//First find the element using any of locator stratedgy
		//WebElement iframeElement = driver.findElement(By.id("IF1"));
		
		List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
		System.out.println("number of iframes:"+iframes.size());
 
		
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);
 
		
		driver.quit();
		

	}

}
