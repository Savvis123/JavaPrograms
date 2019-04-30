package SeleniumPractice;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		 
		Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("123"))));
		
		driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		
		@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
		FluentWait<WebDriver> wait1 = new FluentWait(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
		wait1.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("234"))));
		

	}

}
