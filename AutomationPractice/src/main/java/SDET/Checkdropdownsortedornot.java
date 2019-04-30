package SDET;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import edu.emory.mathcs.backport.java.util.Collections;

public class Checkdropdownsortedornot {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/driverfiles/chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get("http://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			WebElement element= driver.findElement(By.name("animals"));
			List originallist = new ArrayList();
			List templist=new ArrayList();
			Select select = new Select(element);
			
			List<WebElement> options=select.getOptions();
			for(WebElement e : options)
			{
				originallist.add(e.getText());
				templist.add(e.getText());
			}
			
			System.out.println("original list elements :"+originallist);
			
			System.out.println("temp list elment values :"+templist);
			
			Collections.sort(templist);
			
	       System.out.println("after sort the original list elements are :"+originallist);
			
			System.out.println("after sort the temp list elment values are :"+templist);
			
			if(originallist==templist)
			{
				System.out.println("drowdown values are sorted");
			}
			else
			{
				System.out.println("dropdown values are not sorted");
			}
	
	
            
	}

}
