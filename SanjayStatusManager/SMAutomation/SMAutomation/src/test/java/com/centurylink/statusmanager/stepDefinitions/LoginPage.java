package com.centurylink.statusmanager.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.LoginPageActions;
import com.centurylink.statusmanager.utilities.ExecutionStatus;
import com.centurylink.statusmanager.utilities.SeleniumDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LoginPage {

	WebDriver driver;
	LoginPageActions loginPageActions = new LoginPageActions(driver);


	@Given("^I launch Status Manager application$")
	public void i_am_on_the_SM_login_Page() throws Throwable {

		ExecutionStatus.onStart();
		SeleniumDriver.launchApplication();
	}

	@And("^I login as a \"([^\"]*)\" user$")
	public void i_login_as_admin_user(String arg1) throws IOException, InterruptedException {

		loginPageActions.fillLoginForm();
		loginPageActions.performSignIn();

	}

}
