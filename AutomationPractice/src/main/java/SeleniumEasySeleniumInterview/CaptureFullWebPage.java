package SeleniumEasySeleniumInterview;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureFullWebPage {
	
	public static String CaptureScreenShotWithTestStepName(WebDriver driver, String testStepsName)
	{
		try{
			// down casting WebDriver to use getScreenshotAs method.
			TakesScreenshot ts= (TakesScreenshot)driver;
			// capturing screen shot as output type file
			File screenshotSRC= ts.getScreenshotAs(OutputType.FILE);
			// Defining path and extension of image
			String path=System.getProperty("user.dir")+"/ScreenCapturesPNG/"+testStepsName+System.currentTimeMillis()+".png";
			// copying file from temp folder to desired location
			File screenshotDest= new File(path);
			FileUtils.copyFile(screenshotSRC, screenshotDest);
			return path;
		}catch(Exception e)
		{
			System.out.println("Some exception occured." + e.getMessage());
			return "";
		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\NaveenAutomationLabsRestAPI\\AutomationPractice\\src\\test\\resources\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("http://www.makeseleniumeasy.com/");

		// Down casting driver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// It returns height of view part. You can say it as page height. When you click on page down key
		// Page scroll by one page. 
		long pageHeight= (long)js.executeScript("return window.innerHeight");
		System.out.println("Page height: "+pageHeight);
		
		// It is how much you can scroll. It is height if you scroll, you will reach to bottom of page.
		long scrollableHeight= (long)js.executeScript("return document.body.scrollHeight");
		System.out.println("Total scrollable height: "+scrollableHeight);
		
		// Finding number of pages. Adding 1 extra to consider decimal part.
		int numberOfPages=(int) (scrollableHeight/pageHeight)+1;
		
		System.out.println("Total pages: "+numberOfPages);
		

		// Now scrolling page by page
		for(int i=0;i<numberOfPages;i++)
		{
			CaptureFullWebPage.CaptureScreenShotWithTestStepName(driver, "Page "+(i+1));
			js.executeScript("window.scrollBy(0,"+pageHeight+")");
			Thread.sleep(2000);
		}

	}
}