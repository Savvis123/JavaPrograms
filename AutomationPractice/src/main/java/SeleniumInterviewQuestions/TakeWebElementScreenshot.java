package SeleniumInterviewQuestions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import BrowsersLaunching.TakeScreenShotOnFailures;

import javax.imageio.ImageIO;

import java.io.File;
 
public class TakeWebElementScreenshot
{
   public static void main(String args[]) throws Exception
   {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
       driver.get("http://demo.automationtesting.in/Register.html");
       Thread.sleep(2000);
 
       WebElement webElement = driver.findElement(By.cssSelector("#imagetrgt"));
 /*
       Screenshot screenshot = new AShot().takeScreenshot(driver,webElement);
       ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"\\ErrorScreenshots\\ElementScreenshot.png"));
 */
       Thread.sleep(2000);
     
       File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       
       File dest=new File("C:\\Users\\ab64129\\Desktop\\seleniuminterviewrealtimequestions\\mahesh.png");
       FileUtils.copyFile(src,dest);
       

   }
}