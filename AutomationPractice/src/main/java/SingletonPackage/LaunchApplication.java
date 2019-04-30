package SingletonPackage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchApplication {
	
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser()
	{
		DriverInit InstanceDriver =DriverInit.getInstance();
		driver=InstanceDriver.openBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void launchApp()
	{
     driver.get("https://www.google.com/");
     System.out.println("title of the website is:"+driver.getTitle());
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}

}
