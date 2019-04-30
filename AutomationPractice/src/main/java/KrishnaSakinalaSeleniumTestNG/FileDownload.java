package KrishnaSakinalaSeleniumTestNG;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownload {
	WebDriver driver;
	File folder;
	
	@BeforeTest
	public void setUP()
	{
		folder=new File(UUID.randomUUID().toString());
		folder.mkdirs();
		System.out.println("file path :"+folder.mkdirs());
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
	
		ChromeOptions options=new ChromeOptions();
		
		Map<String,Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_settings.popus", 0);
		prefs.put("download.default_directory", folder.getAbsolutePath());
		options.setExperimentalOption("prefs", prefs);
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver =new ChromeDriver(cap);
		
		
}

	@Test
	public void verifyDownloadedFile() throws InterruptedException
	{
		driver.get("http://the-internet.herokuapp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		Thread.sleep(3000);
		
		File[] listoffiles=folder.listFiles();
		
		Assert.assertTrue(listoffiles.length>0);
		
		for(File file:listoffiles)
		{
			Assert.assertTrue(file.length()>0);
			//Assert.assertTrue(listoffiles.length>0);
			
		}
		
	}
	
	@AfterTest
	public void teatDown()
	{
		driver.quit();
		
		for(File file : folder.listFiles())
		{
			file.delete();
		}
		
		folder.delete();
	}
}
