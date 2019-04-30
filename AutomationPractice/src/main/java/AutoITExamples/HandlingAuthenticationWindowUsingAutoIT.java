package AutoITExamples;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import BrowsersLaunching.Base;

public class HandlingAuthenticationWindowUsingAutoIT {
	
	WebDriver driver;
	
	@Test
	public void AuthenticationWindow() throws InterruptedException, IOException
	{
		// first solution 
		
		//pass the crdentials in URL itself 
		
		//http://mukeshotwani:password1234@www.xyz.com
		
		/*
		 * Below is the second solution 
		 */
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\geckodriver.exe");
		DesiredCapabilities capa = DesiredCapabilities.firefox();
		capa.setCapability("marionette", false);
		driver = new FirefoxDriver(capa);
	    driver.manage().window().maximize();
	  
	    Runtime.getRuntime().exec("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\HandlingAuthentication.exe");
		
		driver.get("https://www.engprod-charter.net/");
		
		Thread.sleep(5000);
		}
	

}
