package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page {
	
	private static WebElement element =null;
	
	public static WebElement link_myAccount(WebDriver driver)
	{
		driver.findElement(By.id("account"));
		
		return element;
	}

	public static WebElement link_logout(WebDriver driver)
	{
		driver.findElement(By.id("account_logout"));
		return element;
		
	}
}
