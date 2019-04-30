package PageObjectModelTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjectModel.Home_page;
import PageObjectModel.LogIn_Page;

public class PageObjectModel {
	 private static WebDriver driver = null;
	
	@Test
	public void launchApp()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.store.demoqa.com");
		Home_page.link_myAccount(driver).click();
		LogIn_Page.txt_UserName(driver).sendKeys("mahesh");
		LogIn_Page.txt_Password(driver).sendKeys("maheshreddy1");
		LogIn_Page.btn_login(driver).click();
		driver.quit();
		
	}

}
