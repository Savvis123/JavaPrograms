package ListenersExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersExamples.TestNGListener.class)
public class MyFirstTest {

	static WebDriver driver;
	
	@Test
	public void testListeners()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rte1vfo.corp.intranet/login.jsp");
		
	}
	
	@Test
	public void failedtest()
	{
		System.out.println("title of the application:"+driver.getTitle());
		Assert.assertEquals(" Virtual Front Office1", driver.getTitle());
	}
}
