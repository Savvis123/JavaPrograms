package com.centurylink.statusmanager.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.slf4j.LoggerFactory;

import com.centurylink.statusmanager.pageFactoryActions.GetRequestDetailsByCorrelationIDPageActions;
import com.centurylink.statusmanager.pageFactoryActions.StatusSubmitServicePageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class GetRequestDetailsByCorrelationIDPage {

	WebDriver driver ;
	public String InputCorrelationID;
	
	private final static org.slf4j.Logger Log = LoggerFactory.getLogger(GetRequestDetailsByCorrelationIDPage.class);

	GetRequestDetailsByCorrelationIDPageActions getRequestDetailsByCorrelationID = new GetRequestDetailsByCorrelationIDPageActions(driver);

	
	@And("^I enter \"([^\"]*)\" in CorrelationID textbox and click on submit$")
	public void i_enter_correlationID(String CorrelationID) {
		
		InputCorrelationID = CorrelationID;
		Log.info("Input CorrelationID ==== " + InputCorrelationID);
		getRequestDetailsByCorrelationID.CorrelationIDTextbox.sendKeys(CorrelationID);
		
	}
	
/*	@And("I click on Submit button")
	public void click_on_submit_button() {
		
	//	getRequestDetailsByCorrelationID.SubmitButton.click();
	}*/
	
	/*@And("^I enter \"([^\"]*)\" CorrelationID and click on submit$")
	public void i_enter_correlationid_and_click_on_submit(String CorrelationID) throws Throwable {
		InputCorrelationID = CorrelationID;
		Log.info("Input CorrelationID ==== " + InputCorrelationID);
		getRequestDetailsByCorrelationID.CorrelationIDTextbox.sendKeys(CorrelationID);
		getRequestDetailsByCorrelationID.SubmitButton.click();

	}*/

	@Then("^I verify the response received for CorrID$")
	public void i_verify_the_response_received() throws Throwable {

		getRequestDetailsByCorrelationID.validateGetRequestByCorrelationIDResponse(InputCorrelationID);
		

	}
	
	@And("^I close the Get Request Details by CorrelationID tab$")
	public void i_close_the_Get_Request_Details_by_CorrelationID_tab() {
		
		getRequestDetailsByCorrelationID.closeReqByCorrIDTab();
	}
}
