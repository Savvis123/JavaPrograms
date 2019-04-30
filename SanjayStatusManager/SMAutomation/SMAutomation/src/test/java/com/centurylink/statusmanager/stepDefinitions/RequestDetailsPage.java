package com.centurylink.statusmanager.stepDefinitions;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.HomePageActions;
import com.centurylink.statusmanager.pageFactoryActions.RequestDetailsPageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class RequestDetailsPage {
	
	WebDriver driver ;
	
	public static String addflagName ;
	public static String MSname ;
	public static String actiononMS ;
	public static String datatoupdate ;
	
	RequestDetailsPageActions requestDetailsPageActions = new RequestDetailsPageActions(driver);
	HomePageActions homePageActions = new HomePageActions(driver);

	@And("^I should see the \"([^\"]*)\" been displayed$")
	public void i_should_see_the_Request_Details_screen_attributes_been_displayed(String noargs) {
		
		requestDetailsPageActions.waitForRequestPageToLoad();
	}
	
	@Then("^I remove \"([^\"]*)\" Flag from the Request Flagged section$")
	public void i__remove_Flag_from_the_Request_Flagged_section(String Flag_code) throws InterruptedException {
	
		requestDetailsPageActions.verifAndRemoveFlag(Flag_code);
		
	}
	
	@And("^I verify success message is displayed$")
	public void i_verify_success_message_is_displayed() throws InterruptedException {
		System.out.println(HomePage.flagSearchparam);
		requestDetailsPageActions.verifySuccessMessageToaster(HomePage.flagSearchparam);
		
	}
	
	@Then("^I verify \"([^\"]*)\" log Action is captured in Logs Table$")
	public void i_verify_log_Action_is_captured_in_Logs_Table(String logActionType) throws InterruptedException, FileNotFoundException {
		
		requestDetailsPageActions.validateLogsinLogDetailstab(logActionType);

	}
	
	@Then("^I verify \"([^\"]*)\" microservice is displayed under the Microservice table in the request details page$")
	public void i_verify_the_microservice_is_displayed_under_the_Microservice_table_in_request_details_page(String servicename) throws InterruptedException {
		
		// requestDetailsPageActions.verifyMSisDsiplayedinMSTable(HomePage.msName_search);
		 MSname = servicename ; 
		 requestDetailsPageActions.verifyMSisDsiplayedinMSTable(servicename);	
		 
	}
	
	@And("^I verify \"([^\"]*)\" flag already exists$")
	public void i_verify_flag_already_exists(String flagName) throws InterruptedException {
		
		requestDetailsPageActions.checkFlagstatusinRequestPage(flagName);
		
	}
	
	@And("^I remove the flag if already exists$")
	public void i_remove_the_flag_if_already_exists() {
		
		
	}
	
	@Then("^I add \"([^\"]*)\" Flag to the request$")
	public void i_add_flag_to_request(String flagname) throws InterruptedException {
		
		addflagName = flagname ;
		requestDetailsPageActions.addFlagtoRequest(addflagName);
	}
	
	@And("^I click on Assign button$")
	public void i_click_on_assign_workgroup_button() {
		
		requestDetailsPageActions.clickonAssignButton();
		
	}
	
	@And("^I select \"([^\"]*)\" radio button$")
	public void i_select_radio_button(String option) throws InterruptedException {
		
		requestDetailsPageActions.selectAssignToOptions(option);
	}
	
	@Then("^I assign \"([^\"]*)\" workgroup to the request$")
	public void i_assign_workgroup_to_request(String wrkgrpName) throws InterruptedException {
		
		requestDetailsPageActions.assignWorkgrouptoRequest(wrkgrpName);
	}
	
	@Then("^I remove \"([^\"]*)\" workgroup from the request$")
	public void i_remove_workgroup_from_request(String wrkgrpName) throws InterruptedException {
		
		requestDetailsPageActions.removeWorkgroupfromRequest(wrkgrpName);
		
	}
	
	@Then("^I assign \"([^\"]*)\" ID to the request$")
	public void i_assign_cuid_to_the_request(String cuid) throws InterruptedException {
		
		requestDetailsPageActions.assignCUIDtoRequest(cuid);
	}
	
	@Then("^I verify warning message is displayed when clicked on assign workgroup button$")
	public void i_verify_warning_message_is_displayed_when_clicked_on_assign_workgroup_button() throws InterruptedException {
		
		requestDetailsPageActions.assignWorkGroupWarningMessage();
	}
	
	@Then("^I verify warning message is displayed when clicked on assign user button$")
	public void i_verify_warning_message_is_displayed_when_clicked_on_assign_user_button() throws InterruptedException {
		
		requestDetailsPageActions.assignUserWarningMessage();
	}
		
	@Then("^I validate \"([^\"]*)\" action performed on the \"([^\"]*)\" microservice$")
	public void i_validate_action_performed_on_microservice(String MSAction, String microservice) throws InterruptedException {
		
		actiononMS = MSAction ;
		requestDetailsPageActions.performActiononMicroService(MSAction,microservice);
	}
	
	@Then("^I update the \"([^\"]*)\" field and validate \"([^\"]*)\" action performed on the \"([^\"]*)\" microservice$")
	public void i_update_desiredduedate_then_action_performed_on_microservice(String value, String MSAction, String microservice) throws InterruptedException {
		
		 datatoupdate = value ;
		
		requestDetailsPageActions.performActiononMicroService(MSAction, microservice);
		
	}
	
	@Then("^I verify the service summary section displayed in the request page$")
	public void i_verify_the_service_summary_section_displayed_in_the_request_page() {
		
		requestDetailsPageActions.verifyServiceSummarysection();
	}
	
}
