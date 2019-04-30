package driverScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


//@TestEnvironment(Environment.ITV2)
@RunWith(Cucumber.class)
@CucumberOptions(features = {"Feature"}, 
plugin = {"json:target/Reports/cucumber-report.json",
		  "com.cucumber.listener.ExtentCucumberFormatter:target/Reports/cucumber-report.html"}, 
monochrome = true,
tags={"@Regression_Epwf121"},
format = {
		"pretty", "html:target/cucumber-reports/cucumber-pretty/",
		"json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt" })
//tags = {"@MYAccount_CRIS_OneTime_ACH_New_Savings_SaveToWallet,@MYAccount_CRIS_OneTime_ACH_Existing_Savings,@MYAccount_CRIS_OneTime_ACH_New_Checking_SaveToWallet,@MYAccount_CRIS_OneTime_ACH_Existing_Checking,@MYAccount_CRIS_Scheduled_ACH_New_Savings_SaveToWallet,@MYAccount_CRIS_OneTime_ACH_New_Checking_DoNotSaveToWallet,@MYAccount_CRIS_OneTime_CARD_New_SaveToWallet,@MYAccount_CRIS_Scheduled_CARD_New_DoNotSaveToWallet,@MYAccount_Ensemble_Scheduled_ACH_New_SaveToWallet,@MYAccount_Ensemble_OneTime_ACH_Existing_Savings,@MYAccount_Ensemble_OneTime_ACH_New_Savings_DoNotSaveToWallet,@MYAccount_Ensemble_Scheduled_CARD_Existing,@MYAccount_Ensemble_OneTime_CARD_New_SaveToWallet,@MYAccount_Ensemble_Scheduled_CARD_New_DoNotSaveToWallet,@MYAccount_MYA_QBP_CRIS_OneTime_ACH_New_Savings_DoNotSaveToWallet,@MYAccount_MYA_QBP_Ensemble_OneTime_CARD_New_DoNotSaveToWallet,@MYAccount_MYA_QBP_CRIS_OneTime_CARD_New_DoNotSaveToWallet,@MYAccount_MYA_QBP_Ensemble_OneTime_ACH_New_Checking_DoNotSaveToWallet"})

public class RunCukesTest {
	
	   public static long featurefromtime,featuretotime;
	   public static String applicationName;
	  // public static Properties prop = new Properties();
	   //public static InputStream istream = null;
	   public static long scenariofromtime,scenariototime;
	   public static String TestType,Environment;	
	   public static int features;

	   private static TestNGCucumberRunner testNGCucumberRunner;

	/*@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}*/

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}
/*
	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		zipFolder(Paths.get("/target/Reports/Screenshot"), Paths.get("/target/Reports/Screenshot.zip"));
		testNGCucumberRunner.finish();	
	}*/
	
	public static void zipFolder(final Path sourceFolderPath, Path zipPath) throws Exception {
        final ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
        Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
                Files.copy(file, zos);
                zos.closeEntry();
                return FileVisitResult.CONTINUE;
            }
        });
        zos.close();
 } 
	
	
	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws FileNotFoundException, IOException {
		
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
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
    	   applicationName="MALNAME";
   }




@AfterClass(alwaysRun = true)
   public static void logReport() throws Exception{
           String jsonString="";
           
           if(Stepdefinition.scenarioCount==1) {
        	   jsonString=Stepdefinition.arrObj.get(0).toString();
           }else {
        	   jsonString=Stepdefinition.arrObj.toString();
           }
           if(!(System.getProperty("applicationname.key")==null)) {
        	   FileWriter fw = new FileWriter("result.json");
	           fw.write(jsonString);
	           fw.close();
           }
           
          //EPWF code below two lines
	       zipFolder(Paths.get("/target/Reports/Screenshot"), Paths.get("/target/Reports/Screenshot.zip"));
   		   testNGCucumberRunner.finish();	
           
	}

	
}
