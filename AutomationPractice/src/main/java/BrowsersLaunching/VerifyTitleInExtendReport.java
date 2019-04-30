package BrowsersLaunching;
import java.util.concurrent.TimeUnit;

import Utility.UtilityMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyTitleInExtendReport {
	
	public class VerifyTitle 
	{
	 
	ExtentReports report;
	ExtentTest logger; 
	WebDriver driver;
	 
	 
	@Test
	public void verifyBlogTitle()
	{
		
	report=new ExtentReports("C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\Reports\\LearnAutomationTestAutomation.html");
		 
	logger=report.startTest("VerifyBlogTitle");
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
	
    driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	
   logger.log(LogStatus.INFO, "Browser started ");
	
	driver.get("https://www.google.com/");
	
	logger.log(LogStatus.INFO, "Application is up and running");
	
	driver.findElement(By.name("q")).sendKeys("selenium");
	
    String title=driver.getTitle();
	 
	Assert.assertTrue(title.contains("Mahesh")); 
	 
	logger.log(LogStatus.PASS, "Title verified");
	
}
	 
	 
	@AfterMethod
	public void tearDown(ITestResult result)
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
	 
	String screenshot_path=UtilityMethods.captureScreenshotForExtentReport(driver, result.getName());
	String image= logger.addScreenCapture(screenshot_path);
	logger.log(LogStatus.FAIL, "Title verification", image);
	 
	 
	}
	 
	report.endTest(logger);
	report.flush();
	 
	driver.get("C:\\Report\\LearnAutomation.html");
	}
	 
	 
	}

}
