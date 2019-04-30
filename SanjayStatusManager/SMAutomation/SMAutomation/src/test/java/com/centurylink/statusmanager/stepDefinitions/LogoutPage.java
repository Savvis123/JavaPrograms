package com.centurylink.statusmanager.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.LogoutPageActions;
import com.centurylink.statusmanager.utilities.ExecutionStatus;

import cucumber.api.java.en.Then;

public class LogoutPage {
	
	WebDriver driver ;
	
	LogoutPageActions logoutPageActions = new LogoutPageActions(driver);
	
	@Then("^I logout from Application$")
	public void i_logout_from_Application() throws Throwable {

		logoutPageActions.logoutfromApplication();
		ExecutionStatus.onFinish();
	}

}
