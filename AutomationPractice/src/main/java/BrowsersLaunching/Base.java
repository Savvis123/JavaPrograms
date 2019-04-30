package BrowsersLaunching;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
	public WebDriver driver;
	@BeforeClass
	public void launchBrowser(){
	
				
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\geckodriver.exe");
		DesiredCapabilities capa = DesiredCapabilities.firefox();
		capa.setCapability("marionette", false);
		driver = new FirefoxDriver(capa);
	    driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				

	}
	
	//@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
