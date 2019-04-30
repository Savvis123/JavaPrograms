package com.centurylink.statusmanager.stepDefinitions;

import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.LogNotesServiceActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class LogNotesServicePage {

	WebDriver driver ;
	LogNotesServiceActions logNotesServiceActions = new LogNotesServiceActions(driver);

	@And("^I fill Log Notes Service form$")
	public void i_fill_log_notes_service_form() throws InterruptedException, IOException {

		logNotesServiceActions.fillLogNotesServiceForm();
	}

	@And("^I validate the response received from Notes Service$")
	public void i_validate_the_response_received_from_Notes_Service() throws JSONException, InterruptedException {

		logNotesServiceActions.validate_log_notes_response();
	}
	
	@And("^I enter the CorrelationID used for Log Notes Service$")
	public void i_enter_the_CorrelationID_used_for_Log_Notes_Service() {
		
		logNotesServiceActions.searchrequsingCorrID();
	}

	@Then("^I verify the comments displayed in the comments section of Request Details Page$")
	public void i_verify_the_comments_displayed_in_the_comments_section_of_Request_Details_Page()
			throws InterruptedException {

		logNotesServiceActions.validate_comments_displayed_in_request_page();
	}
	
	

	@And("^I go to Log Details tab$")
	public void i_go_to_log_details_tab() throws InterruptedException {

		logNotesServiceActions.clickonLogDetailsTab();

	}

	@Then("^I validate the updated comments are captured in the Log table$")
	public void i_validate_the_updated_comments_are_captured_in_the_log_table() throws InterruptedException {

		logNotesServiceActions.getcommentsvalidationfromLogstab();

	}
}
