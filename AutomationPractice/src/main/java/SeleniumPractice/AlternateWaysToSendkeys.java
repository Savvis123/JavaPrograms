package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlternateWaysToSendkeys {
	
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in/");
		
		WebElement searchbox=driver.findElement(By.name("q"));
		
		//first way
		
		/*JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("arguments[0].value='Kirtesh';", searchbox);
		
		Thread.sleep(2000);
		*/
		
		//second way
		/*
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		myExecutor.executeScript("document.getElementsByName('q')[0].value='Kirtesh'");
		
		Thread.sleep(2000);*/
		
		
		//3 way using Actions
		
		Actions action=new Actions(driver);
		action.sendKeys(searchbox,"mahesh").build().perform();
		Thread.sleep(3000);
		
		driver.quit();

	}

}
