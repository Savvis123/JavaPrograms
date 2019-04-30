package BrowsersLaunching;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GetBANFromSimon {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://simon-test3.test.intranet/Simon/simonInit.htm");
		
		//driver.switchTo().window("SiMON");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("ab64129");
		
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Welcome@123");
		
		WebElement element=driver.findElement(By.xpath("//*[@id='environment']"));
		
		Select selcet=new Select(element);
		selcet.selectByVisibleText("DEPLOYI3");
		
	
	
		driver.findElement(By.xpath("//*[@id='LoginBtn']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//input[@id='ban_search']")).sendKeys("5154783631");
		
		driver.findElement(By.xpath("//button[@id='search-select']")).click();
		
	
	
		//driver.switchTo().frame("simon-frame");
		List<WebElement> allFrames = driver.findElements(By.xpath("//iframe"));
		
		for (WebElement ele : allFrames) {
			driver.switchTo().frame(ele);
			try{
				WebElement element2= driver.findElement(By.xpath("//table[@id='accountTable']/tbody/tr/td[2]"));
				System.out.println(element2.getText());
			}catch(Exception e){
				System.err.println("Not found");
			}
		}
	
		
	}

}
