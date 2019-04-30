package AutoITExamples;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import BrowsersLaunching.Base;

public class UploadFileUsingAutoIT extends Base{
	
	@Test
	public void UploadFileExample() throws InterruptedException, IOException
	{
		driver.get("file:///C:/Users/ab64129/Desktop/NaveenAutomationLabsRestAPI/HandlingAuth/Upload.html");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[contains(@class,'spmhidip')]")).sendKeys("abcddedd");
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Mahesh");
		
		driver.findElement(By.id("email")).sendKeys("mah.maddala@gmail.com");
		
		driver.findElement(By.id("message")).sendKeys("test");
		
		driver.findElement(By.id("photo")).click();
		
		Thread.sleep(8000);
		
		Runtime.getRuntime().exec("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\HandlingAuth\\UploadFileusingAutoIT.exe");
		
		Thread.sleep(10000);
		
		String str=driver.findElement(By.id("photo")).getText();
		
		System.out.println("Uploaded file name is:"+str);
		
		System.out.println("file uploaded successfully");
		
		
		
		
	}
	

}
