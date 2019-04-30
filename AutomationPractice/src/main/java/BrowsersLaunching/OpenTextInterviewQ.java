package BrowsersLaunching;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class OpenTextInterviewQ {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rte1vfo.corp.intranet/login.jsp");
		
		
		WebElement ele=driver.findElement(By.xpath("//input[@name=''mahesh]"));
		
		
		Select select =new Select(ele);
	    List cities=select.getOptions();
	    
        for(int i=0;i<cities.size();i++)
	    {
	    
	    	select.selectByIndex((int)cities.get(i));
	    	
	    	WebElement ele1=driver.findElement(By.xpath("//input[@name=''mahesh1]"));

			Select select1 =new Select(ele1);
		    List pins=select1.getOptions();
	    	
	    	for(int j=0;j<pins.size();j++)
	    	{
	    		
	    		select1.selectByIndex((int) pins.get(j));
	    		
	    		driver.findElement(By.xpath("//button[@id='login']")).click();
	    	}
	    	
	    	
	    }
	}

}
