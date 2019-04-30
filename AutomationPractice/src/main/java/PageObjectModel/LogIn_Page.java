package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogIn_Page {
	
	private static WebElement element=null;
	
	public static WebElement txt_UserName(WebDriver driver)
	{
		driver.findElement(By.id("log"));
		return element;
	}

	public static WebElement txt_Password(WebDriver driver)
	{
		driver.findElement(By.id("pwd"));
		return element;
		
	}
	
	public static WebElement btn_login(WebDriver driver)
	{
		driver.findElement(By.id("login"));
		return element;
	}
}
