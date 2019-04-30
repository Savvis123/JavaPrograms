package hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.utilities.SeleniumDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class AfterActions {
	static long featurefromtime,featuretotime;
	public static JSONArray arrObj = new JSONArray();
	public static int scenarioCount=0;
	


	public static final String FAILED_SCREENSHOT_PATH = System.getProperty("user.dir")
			+ "\\Screenshots\\Failed Scenario";
	
	
	@After
	public static void tearDown(Scenario scenario) {
		
		WebDriver driver = SeleniumDriver.getDriver();
		System.out.println(scenario.isFailed());
		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// scenario.embed(screenshotBytes, "image/png");
			scenario.embed(screenshotBytes, FAILED_SCREENSHOT_PATH + SeleniumDriver.timestamp() + ".png");
			File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile2, new File(FAILED_SCREENSHOT_PATH));

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		SeleniumDriver.tearDown();
	}

	static String status;
	static String pass_status ;
	static String failed_status ;
	
	Scenario scenario ;

	@After(order=0)
	public static String statuscheck(Scenario scenario) {

		String status = scenario.getStatus();

		if (scenario.isFailed()) {
			
			scenario.getName();
			scenario.write("Failed");
			scenario.getStatus();

		} else if (scenario.isFailed()) {
			
			
			
			scenario.write("PASSED");
			System.out.println("Passed");
			scenario.getStatus();

		}
		return status;
	}
	

}
