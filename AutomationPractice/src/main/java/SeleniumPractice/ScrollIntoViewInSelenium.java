package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class ScrollIntoViewInSelenium {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com");
		
		Thread.sleep(4000);
		JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);
		
		//vertical
		myExecutor.executeScript("scroll(0,400)");
		
		Thread.sleep(4000);
		
		myExecutor.executeScript("window.scrollBy(0,150)");
		
		Thread.sleep(5000);
		
		//horizontal
		 myExecutor.executeScript("scroll(500,0)");
	}

}
