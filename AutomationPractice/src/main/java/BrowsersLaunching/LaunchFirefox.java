package BrowsersLaunching;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchFirefox {
	
	public static WebDriver driver;
	
	protected static boolean switchWindow(String title) throws IOException {

	    String currentWindow = driver.getWindowHandle();
	    Set<String> availableWindows = driver.getWindowHandles();
	    if (!availableWindows.isEmpty()) {
	    for (String windowId : availableWindows) {
	    if (driver.switchTo().window(windowId).getTitle().equals(title)) {
	    return true;
	    } else {
	        driver.switchTo().window(currentWindow);
	    }
	    }
	    }

	    return false;   
	    }

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\geckodriver.exe");
		
		
		DesiredCapabilities capa = DesiredCapabilities.firefox();
		capa.setCapability("marionette", false);
		driver = new FirefoxDriver(capa);
		

		
		driver.manage().window().maximize();
		
		driver.get("https://www.goibibo.com/");
		
		//driver.findElement(By.id("get_sign_up")).click();
		
		 driver.findElement(By.id("get_sign_up")).click();
	        driver.findElement(By.xpath("//div[@class='popContent']/a")).click();
	        driver.findElement(By.id("gosuggest_inputSrc")).click();
	        driver.findElement(By.id("gosuggest_inputSrc")).clear();
	        driver.findElement(By.id("gosuggest_inputSrc")).sendKeys("mahesh");
	        driver.findElement(By.id("gosuggest_inputDest")).click();
	        driver.findElement(By.id("gosuggest_inputDest")).clear();
	        driver.findElement(By.id("gosuggest_inputDest")).sendKeys("Bangalore (BLR)");
	        driver.quit();
		


}
}
