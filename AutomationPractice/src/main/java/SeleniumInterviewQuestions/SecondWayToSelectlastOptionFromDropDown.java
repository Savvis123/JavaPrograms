package SeleniumInterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SecondWayToSelectlastOptionFromDropDown {
	
public static void main(String args[])
{
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	 
	// Put an Implicit wait, 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	// Launch the URL
	driver.get("http://toolsqa.wpengine.com/automation-practice-form");

	WebElement selectDropDown =driver.findElement(By.id("continents"));
	   List<WebElement> option=selectDropDown.findElements(By.tagName("option"));
	   ArrayList<String> list=new ArrayList<>();
	   
	/*   Select s=new Select(selectDropDown);
	 boolean boo=  s.isMultiple();
	 System.out.println(boo);*/
	   

	   for(int i=0;i<option.size();i++)
	   {
	       list.add(option.get(i).getText().trim());
	   }

	 
	   Collections.reverse(list);

	   String lastOption=list.get(0);
	   
	   System.out.println(lastOption);

	   new Select(selectDropDown).selectByVisibleText(lastOption);  

}

}
