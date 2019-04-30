package SingletonPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInit {
	
	public static DriverInit InstanceDriver=null;
	public WebDriver driver;
	
	private DriverInit()
	{
		
	}
	
	public WebDriver openBrowser()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		
		return driver;
	
	}
	


	public static DriverInit getInstance() {
		if(InstanceDriver==null)
			InstanceDriver=new DriverInit();
		return InstanceDriver;
	}

}
