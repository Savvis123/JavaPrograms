package SeleniumEasySeleniumInterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NullInSendKeys {

	public static void main(String[] args) {

		// Setting chrome driver path
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
	// Launching browser
		ChromeOptions options=new ChromeOptions();
		options.addArguments("disable-infobars");
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setAcceptInsecureCerts(true);
		options.merge(caps);
		
		WebDriver driver = new ChromeDriver(options);

		// Maximize window
		driver.manage().window().maximize();

		// Load the URL
		driver.get("https://www.google.com");
		
		// Search box locator
		WebElement searchBox= driver.findElement(By.name("q"));
		
		
		String s=null;
		// Passing null in sendKeys
		searchBox.sendKeys(s);
		
		//org.openqa.selenium.WebDriverException
		
		
	}
}