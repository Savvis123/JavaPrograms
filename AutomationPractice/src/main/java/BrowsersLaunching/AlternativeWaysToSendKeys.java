package BrowsersLaunching;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AlternativeWaysToSendKeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//java script
		
		driver.get("https://www.facebook.com/");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('email').value = 'sunilrathore77@gmail.com';");
		
		System.out.println("worked java script successfully");
		
		WebElement username=driver.findElement(By.id("email"));
		
		Actions builder=new Actions(driver);
		Action entertext=builder.sendKeys(username, "mahesh").build();
		entertext.perform();
		
		/*Actions builder=new Actions(driver);
		Action seriesofactions=builder.moveToElement(username).
		 click()
		.keyDown(username,Keys.SHIFT)
		.sendKeys("mahesh")
		.keyUp(username,Keys.SHIFT)
		.doubleClick(username)
		.contextClick()
		.build();
		
		seriesofactions.perform();
		
		System.out.println("completed action successfully");
		driver.quit();*/


	}

}
