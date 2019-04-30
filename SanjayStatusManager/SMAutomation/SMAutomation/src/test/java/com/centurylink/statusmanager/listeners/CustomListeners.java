package com.centurylink.statusmanager.listeners;

import java.io.IOException;

import org.testng.IConfigurationListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.centurylink.statusmanager.mailUtilities.SendMailwithAttachment;
import com.centurylink.statusmanager.utilities.CommonMethods;
import com.centurylink.statusmanager.utilities.ExecutionStatus;
import com.centurylink.statusmanager.utilities.SeleniumDriver;
import com.centurylink.statusmanager.utilities.URLConfigs;

import cucumber.api.Scenario;
import hooks.BeforeActions;

public class CustomListeners implements ITestListener, ISuiteListener, IConfigurationListener {

	SendMailwithAttachment mail = new SendMailwithAttachment();

	public static String status;
	public static long time;
	public static String Totaltime;
	

	public String getStatus() {

		return status;
	}

	
	public void onFinish(ITestContext arg0) {

		time = arg0.getEndDate().getTime() - arg0.getStartDate().getTime();

		int minutes = (int) (time / 1000) / 60;
		int seconds = (int) (time / 1000) % 60;

		Totaltime = minutes + " mins " + seconds + " sec";
		;

		System.out.println(Totaltime);
	}

	public void onStart(ITestContext arg0) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {

		try {
			CommonMethods.captureScreenshotOnFailure(URLConfigs.FAILED_SCREENSHOT_PATH +"\\Failed - "+ arg0.getMethod().getId()+"_"+arg0.getMethod().getMethodName()+ "_" + SeleniumDriver.timestamp()+ ""  + ".png");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		Reporter.log("FAIL");
		ExecutionStatus.onTestFailure();
		int result = arg0.getStatus();
		boolean getstatus = arg0.isSuccess();
		if (getstatus == false) {
			arg0.setStatus(result);
			String fail = "FAIL";
			status = fail;

		}
	}

	public void onTestSkipped(ITestResult arg0) {

	}

	public void onTestStart(ITestResult arg0) {

	}

	public void onTestSuccess(ITestResult arg0) {

		Reporter.log("PASSED", true);

		int result = arg0.getStatus();

		boolean getstatus = arg0.isSuccess();
		if (getstatus == true) {
			arg0.setStatus(result);

			String pass = "PASS";
			status = pass;

		}

	}

	public void onFinish(ISuite arg0) {

		ExecutionStatus.onSuiteFinish();

		try {
			mail.mailsender();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onStart(ISuite arg0) {

		ExecutionStatus.onSuiteStart();
	}

	public void onConfigurationSuccess(ITestResult itr) {
		

	}

	public void onConfigurationFailure(ITestResult itr) {

	}

	public void onConfigurationSkip(ITestResult itr) {
		

	}

}
