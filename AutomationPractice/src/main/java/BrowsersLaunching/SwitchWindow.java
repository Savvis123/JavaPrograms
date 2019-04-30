package BrowsersLaunching;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
 
public class SwitchWindow {
 
public static void main(String[] args) throws InterruptedException {
 
	System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\geckodriver.exe");
	DesiredCapabilities capa = DesiredCapabilities.firefox();
	capa.setCapability("marionette", false);
	WebDriver driver = new FirefoxDriver(capa);
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
 
driver.get("http://Snapdeal.com");
if(driver.getTitle().contentEquals("Online Shopping - Largest Online Shopping Site for Electronics, Mobile, Fashion & Home - Snapdeal")){
System.out.println("Success");
}
else{
System.out.println("Failed");
//System.exit(0);
}
 
driver.findElement(By.className("accountInner")).click();
driver.findElement(By.xpath("//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]")).click();
 
driver.switchTo().frame("loginIframe");
driver.findElement(By.id("googleUserLogin")).click();
 
Set<String> windows = driver.getWindowHandles(); 
Iterator<String> it = windows.iterator();
String parentWindow = it.next();
String childWindow = it.next();
 
System.out.println(childWindow);
driver.switchTo().window(childWindow);
 
System.out.println(driver.getTitle());
driver.findElement(By.id("Email")).sendKeys("your_email@gmail.com");
driver.findElement(By.id("next")).click();
driver.findElement(By.id("Passwd")).sendKeys("your_password");
driver.findElement(By.id("signIn")).click();
driver.switchTo().window(parentWindow);
System.out.println(driver.getTitle());
 
driver.quit();
 
}
 
}