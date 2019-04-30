package driverScript;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Stepdefinition {
	
	static long featurefromtime,featuretotime;
	public static JSONArray arrObj = new JSONArray();
	public static int scenarioCount=0;

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
		
	   }

    @SuppressWarnings("unchecked")
	private JSONObject getJsonObject(Scenario scenario) {
		   String status="";String errorDetails="NA";
		   JSONObject jObj = new JSONObject();
		   jObj.put("Duration", calculateDuration(featurefromtime,featuretotime));
		   jObj.put("Env", RunCukesTest.Environment);
		   jObj.put("MAL", RunCukesTest.applicationName);
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


}
