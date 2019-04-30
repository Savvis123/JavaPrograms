package KrishnaSakinalaSeleniumTestNG;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileUsingRobotFeatureFromJava {
	
	public static void main(String args[]) throws AWTException
	{
		Robot robot=new Robot();
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.id("imagesrc")).click();
		robot.setAutoDelay(2000);
		
		StringSelection stringselection =new StringSelection("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\AppiumHowToLaunchMobileApp.docx");
		
	   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
	   
	   robot.setAutoDelay(2000);
	   
	   robot.keyPress(KeyEvent.VK_CONTROL);
	   robot.keyPress(KeyEvent.VK_V);
	   
	    robot.setAutoDelay(2000);
	   
	   robot.keyRelease(KeyEvent.VK_CONTROL);
	   robot.keyRelease(KeyEvent.VK_V);
	   
	   robot.setAutoDelay(2000);
	   
	   robot.keyPress(KeyEvent.VK_ENTER);
	   robot.keyRelease(KeyEvent.VK_ENTER);
	   
	   robot.setAutoDelay(3000);
	   
	   
	}

}
