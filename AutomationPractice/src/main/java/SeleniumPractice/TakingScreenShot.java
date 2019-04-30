package SeleniumPractice;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakingScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "");
		WebDriver driver=new ChromeDriver();
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHelper.copyFile(in, out);
		FileUtils.copyFile(src, new File("c:\\s.creenshots\\sample.png"));

	}

}
