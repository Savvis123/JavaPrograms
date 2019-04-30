package KrishnaSakinalaSeleniumTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class FileUploadUsingSikuli {
	
	@Test
	public void takeScreenShotWithSikuli() throws FindFailed
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.id("imagesrc")).click();
		
	
		Pattern FilImage=new Pattern("C:\\Users\\ab64129\\Desktop\\Interview\\krishnaSakinala\\FileName.PNG");
		Pattern openImage=new Pattern("C:\\Users\\ab64129\\Desktop\\Interview\\krishnaSakinala\\Open.PNG");
		
		Screen screen=new Screen();
		screen.type(FilImage,"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\AppiumHowToLaunchMobileApp.docx");
		screen.click(openImage);
		
		
	
	}

}
