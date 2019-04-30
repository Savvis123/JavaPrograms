package com.centurylink.statusmanager.stepDefinitions;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.GetRequestDetailsByCorrelationIDPageActions;
import com.centurylink.statusmanager.pageFactoryActions.GetRequestDetailsByPublicUserIDPageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;


public class GetRequestDetailsByPublicUserIDPage {

	WebDriver driver ;
	public String InputTNID;
	
/*	RequestSpecification httpRequest ;
	Response response ;*/

	GetRequestDetailsByPublicUserIDPageActions getRequestDetailsByTNActions = new GetRequestDetailsByPublicUserIDPageActions(driver);
	GetRequestDetailsByCorrelationIDPageActions getRequestDetailsByCorrelationID = new GetRequestDetailsByCorrelationIDPageActions(driver);

	
	
	@And("^I enter \"([^\"]*)\" in PublicUserID textbox and click on submit$")
	public void i_enter_TN(String PublicUserID) {
		
		InputTNID = PublicUserID;
		System.out.println("InputTNID ====" + InputTNID);
		getRequestDetailsByTNActions.PublicUserIDTextbox.sendKeys(PublicUserID);
	}
	
/*	
	@And("^I enter \"([^\"]*)\" PublicUserID and click on submit$")
	public void i_enter_TNid_and_click_on_submit(String PublicUserID) throws Throwable {

		InputTNID = PublicUserID;
		System.out.println("InputTNID ====" + InputTNID);
		getRequestDetailsByTNActions.PublicUserIDTextbox.sendKeys(PublicUserID);
		getRequestDetailsByCorrelationID.SubmitButton.click();

	}*/
	
	@Then("^I verify the response received for the TN used$")
	public void i_verify_response_received_for_the_TN_used() throws JSONException, InterruptedException {
		
		getRequestDetailsByTNActions.validateGetRequestByTNResponse(InputTNID);
		
	}
	
	@And("^I close the Get Request Details by PublicUserID tab$")
	public void i_close_the_Get_Request_Details_by_PublicUserID_tab() {
		
		getRequestDetailsByTNActions.closeReqByPublicuserIDTab();
	}
	
	/*// Below are for Testing the Rest Assured API call
	// ********************************************
	
	@Given("^I specify the Base URL for GetRequestByPublicUserID$")
	public void i_specify_the_Base_URL_for_GetRequestByPublicUserID() throws Throwable {
		
		RestAssured.baseURI = "https://omnivue-test3.test.intranet/OMNIVue/RESTService/StatusManager/PublicUserID/TN" ;
	}

	@Given("^I get the RequestSpecification for the request$")
	public void i_get_the_RequestSpecification_for_the_request() throws Throwable {

		 httpRequest = RestAssured.given();

		
	}

	@When("^I pass \"([^\"]*)\" PublicUserID$")
	public void i_pass_PublicUserID(String arg1) throws Throwable {

		 response = httpRequest.get("/2144669195");
		// 2144669195
		
	}

	@Then("^I validate the response received for GetRequestByPublicUserID$")
	public void i_validate_the_response_received_for_GetRequestByPublicUserID() throws Throwable {
	
		System.out.println("Response Body is =>  " + response.asString());
		
	}
	// ********************************************
*/
}
