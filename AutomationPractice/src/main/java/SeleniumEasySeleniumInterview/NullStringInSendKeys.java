package SeleniumEasySeleniumInterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NullStringInSendKeys {

	public static void main(String[] args) {

		// Setting chrome driver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");

		// Launching browser
		WebDriver driver = new ChromeDriver();

		// Maximize window
		driver.manage().window().maximize();

		// Load the URL
		driver.get("https://www.google.com");
		
		// Search box locator
		WebElement searchBox= driver.findElement(By.name("q"));
		
		String s=null;
		
		// Passing null in sendKeys
		searchBox.sendKeys(s);
		
		//org.openqa.selenium.WebDriverException: unknown error: call function result missing 'value'
		
		
	}
}
