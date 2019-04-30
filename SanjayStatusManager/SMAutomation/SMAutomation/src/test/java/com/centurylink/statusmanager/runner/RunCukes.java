package com.centurylink.statusmanager.runner;

import hooks.Stepdefinition;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.centurylink.statusmanager.extentReports.ExtentReportConfigurations;
import com.centurylink.statusmanager.mailUtilities.SendMailwithAttachment;
import com.centurylink.statusmanager.utilities.SeleniumDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features", plugin = { "json:cucumber.json", "pretty",
		"html:target/RunCukes/cucumber.html",
		"com.cucumber.listener.ExtentCucumberFormatter" }, glue = "com/centurylink/statusmanager/stepDefinitions", 
		tags = {"@AutoDemo" }, monochrome = true

)

public class RunCukes extends AbstractTestNGCucumberTests {
	
	 public static long featurefromtime,featuretotime;
	   public static String applicationName;
	  // public static Properties prop = new Properties();
	   //public static InputStream istream = null;
	   public static long scenariofromtime,scenariototime;
	   public static String TestType,Environment;	
	   public static int features;

	//static SeleniumDriver sd = new SeleniumDriver();
	//static SendMailwithAttachment mail = new SendMailwithAttachment();

	@BeforeSuite
	public static void setup() {

		ExtentReportConfigurations.initializereportConfig();

		SeleniumDriver.setupDriver();

	}

	@AfterSuite
	public static void teardown() {

		SeleniumDriver.tearDown();

		System.out.println("File name = " + ExtentReportConfigurations.Filename);
		System.out.println("Report name = " + ExtentReportConfigurations.reportName);
	}
	
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws FileNotFoundException, IOException {
		
		
	   features++;
       TestType=System.getProperty("testtype.key");
       Environment=System.getProperty("envtype.key");
       applicationName=System.getProperty("applicationname.key");
       featurefromtime=System.currentTimeMillis();
       if(TestType==null)	
           TestType="Sanity";
       if(Environment==null)
           Environment="ITV1";
       if(applicationName==null)
	       applicationName="STATUSMANAGER";

   }
	
	@AfterClass(alwaysRun = true)
	   public static void logReport() throws Exception{
	           String jsonString="";
	           
	           if(Stepdefinition.scenarioCount==1) {
	        	   jsonString=Stepdefinition.arrObj.get(0).toString();
	           }else {
	        	   jsonString=Stepdefinition.arrObj.toString();
	           }
	         
	        	   FileWriter fw = new FileWriter("result.json");
		           fw.write(jsonString);
		           fw.close();
	          
	           
	        
	           
		}

}
