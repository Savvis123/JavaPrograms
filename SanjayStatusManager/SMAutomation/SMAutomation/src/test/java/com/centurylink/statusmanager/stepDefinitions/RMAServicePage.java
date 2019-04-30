package com.centurylink.statusmanager.stepDefinitions;

import java.io.FileNotFoundException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.RMAServicePageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RMAServicePage {

	WebDriver driver;
	public static String RMAActionType = null;
	RMAServicePageActions rmaServicePageActions = new RMAServicePageActions(driver);

	@And("^I fill \"([^\"]*)\" RMA Service form$")
	public void i_fill_rma_service_form(String ActionType)
			throws FileNotFoundException, JSONException, InterruptedException {

		rmaServicePageActions.AddRMAtoMicroServiceUisngRMAService(ActionType);

	}

	@And("^I validate the reponse received for \"([^\"]*)\" ActionType$")
	public void i_validate_the_reponse_received_for_ActionType(String ActionType)
			throws JSONException, InterruptedException {
		RMAActionType = ActionType;
		rmaServicePageActions.validatingResponseforRMAscenario(ActionType);
	}

	@Then("^I validate the RMA details on request details page for \"([^\"]*)\" ActionType$")
	public void i_validate_the_RMA_details_on_request_details_page_for_ActionType(String ActionType)
			throws InterruptedException {

		rmaServicePageActions.validatingRequestPageforRMAScenario(ActionType);
	}

	/*@Then("^I validate the RMA details for \"([^\"]*)\" ActionType in the Log table$")
	public void i_validate_the_RMA_details_for_ActionType_in_the_Log_table(String ActionType) {
	}*/

	@And("^I verify ActionType of request$")
	public void i_verify_ActionType_of_request() {
		
		rmaServicePageActions.verifyRequestStatus();
	}
	
	@Then("^I verify the visibility of RMAComplete button$")
	public void i_verify_visibility_of_RMAComplete_button() throws Exception {
		
		rmaServicePageActions.checkRMACompleteButtonVisibility();
	}
	
	@And("^I verify for any active RMA's present on MS$")
	public void i_verify_for_any_active_RMAs_on_MS() throws Exception{
	
		rmaServicePageActions.rMAComplete_checkForActiveRMA();
	}
	
	@Then("^I verify the error message recieved when clicked on RMAComplete button$")
	public void i_verify_the_error_message_recieved_when_clicked_on_RMAComplete_button() throws InterruptedException {
		
		rmaServicePageActions.verifyErrorMessageonRMAComplete();
	}
	
	@Then("^I verify the success message recieved when clicked on RMAComplete button$")
	public void i_verify_success_message_received_after_RMA_Complete() throws InterruptedException {
		
		rmaServicePageActions.verifySuccessMessageonRMAComplete();
	}
}
