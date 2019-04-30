package com.centurylink.statusmanager.stepDefinitions;

import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.NotifyServicesPageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class NotifyServicesPage {
	
	WebDriver driver ;
	NotifyServicesPageActions notifyServicesPageActions = new NotifyServicesPageActions(driver);
	
	@And("^I fill Notify Service form$")
	public void i_fill_sotify_service_form() throws InterruptedException, IOException {
		
		notifyServicesPageActions.fill_notify_service_form();
	}
	
	@And("^I validate the response received from Notify Service$")
	public void i_validate_the_response_received_from_notify_service() throws JSONException, InterruptedException {
		
		notifyServicesPageActions.validate_response_notify_service();
	}
	
	@Then("^I validate the newly added flag on request details page$")
	public void i_validate_the_newly_added_flag_on_request_details_page() throws InterruptedException, IOException {
		
		notifyServicesPageActions.validate_newly_added_FLAG_on_UI();
		
	}
	
	@Then("^I validate the flag details are captured in the Log table$")
	public void i_validatethe_flag_details_are_captured_in_the_Log_table() throws InterruptedException {
	
		notifyServicesPageActions.getFlagDetailsfromLogDetailsTab();
		
	}

}
