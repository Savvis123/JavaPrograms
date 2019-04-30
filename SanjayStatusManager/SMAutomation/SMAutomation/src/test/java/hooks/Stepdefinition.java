package hooks;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.runner.RunCukes;
import com.centurylink.statusmanager.utilities.SeleniumDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Stepdefinition {
	static String status;
	static String pass_status ;
	static String failed_status ;
	
	static long featurefromtime,featuretotime;
	public static JSONArray arrObj = new JSONArray();
	public static int scenarioCount=0;
	
	public static final String FAILED_SCREENSHOT_PATH = System.getProperty("user.dir")
			+ "\\Screenshots\\Failed Scenario";

	@Before
	   public void beforeEveryScenario(Scenario scenario) throws Exception {
		   scenarioCount++;
		   featurefromtime=System.currentTimeMillis();
	   }

    @SuppressWarnings("unchecked")
	@After
	   public void afterEveryScenario(Scenario scenario) {
		featuretotime=System.currentTimeMillis();
		arrObj.add(getJsonObject(scenario));
		
		WebDriver driver = SeleniumDriver.getDriver();
		System.out.println(scenario.isFailed());
		if (scenario.isFailed()) {
		/*	byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// scenario.embed(screenshotBytes, "image/png");
			scenario.embed(screenshotBytes, FAILED_SCREENSHOT_PATH + SeleniumDriver.timestamp() + ".png");*/
			File scrFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile2, new File(FAILED_SCREENSHOT_PATH));

			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		SeleniumDriver.tearDown();
		
	   }
    
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

    @SuppressWarnings("unchecked")
	private JSONObject getJsonObject(Scenario scenario) {
		   String status="";String errorDetails="NA";
		   JSONObject jObj = new JSONObject();
		   jObj.put("Duration", calculateDuration(featurefromtime,featuretotime));
		   jObj.put("Env", RunCukes.Environment);
		   jObj.put("MAL", RunCukes.applicationName);
		   jObj.put("OutputType", "Scenario-Detail");
		   jObj.put("Scenario", scenario.getName());
		   if(scenario.getStatus().equalsIgnoreCase("passed")) {
			   status="Pass";
		   }else if(scenario.getStatus().equalsIgnoreCase("failed")) {
			   status="Fail";
			   errorDetails="Exception while executing the scenario";
		   }
		   jObj.put("Status", status);
		   
		   jObj.put("errordetails", errorDetails);
		   return jObj ;
	   }
	   public String calculateDuration(long Ftime,long Ttime){
		    long milliseconds =Ttime -  Ftime;
			long diffSeconds = milliseconds / 1000 % 60;
			long diffMinutes = milliseconds / (60 * 1000) % 60;
			long diffHours = milliseconds / (60 * 60 * 1000) % 24;
			return diffHours+"."+diffMinutes+"."+diffSeconds;
	   }
	   
		
		
		@Before
	    public static void setUp() {
			//ExtentCucumberFormatter.initiateExtentCucumberFormatter();
	    	System.out.println("Before");
	     //  SeleniumDriver.setupDriver();
	    }
		
		@Before
		public static String retrunscenariostatus(Scenario scenario) {

			String a = scenario.getId();
			String b = scenario.getName();
			String res = a+"_"+b ;
			System.out.println("scenario.getId() = "+ scenario.getId());
			System.out.println("scenario.getName() = "+ scenario.getName());
			return res;
		}


}

