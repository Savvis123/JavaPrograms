package BrowsersLaunching;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEBrowserLaunching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://eshop-e2e.test.intranet/eshop/customerCare/dist/index.html");
		
		String text=driver.findElement(By.xpath("//*[contains(text(),'Use Your CenturyLink Common UserID')]")).getText();
		System.out.println(text);
		
		
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys("ab64129");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Mahesh");
		
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
	
	

	}

}
