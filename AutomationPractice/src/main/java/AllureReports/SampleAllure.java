package AllureReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SampleAllure {
	
	@Test
	public void simpleAllureReport()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\driverfiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://rte1vfo.corp.intranet/login.jsp");
	
		
		driver.findElement(By.xpath("//input[@name='loginName']")).sendKeys("spadasa");
        
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Ease1901!PPPP");
		
		Select select =new Select(driver.findElement(By.xpath("//select[@name='serviceRequestType']")));
		select.selectByVisibleText("Access");
		
		driver.findElement(By.xpath("//*[@name='loginform']//table//tbody//tr[5]//th[3]")).click();
		
		driver.switchTo().frame("mainFrame");
		
        Actions action = new Actions(driver);
        
        action.moveToElement(driver.findElement(By.xpath("//th[@id='orderTab']"))).moveToElement(driver.findElement(By.xpath("(//div[contains(@id,'menuItemHilite')][contains(text(),'Search')])[1]"))).click().build().perform();

        driver.close();
	}

}
