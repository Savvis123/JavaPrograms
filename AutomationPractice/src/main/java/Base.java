import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	
	public static void initialization()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ab64129\\Desktop\\driverfiles\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
	}
	
	public void failed()
	{
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileHelper.copyFile(srcFile, new File("errorfile_"+ "failshot_" + this.getClass().getName() + "_" + ".png"));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

}
