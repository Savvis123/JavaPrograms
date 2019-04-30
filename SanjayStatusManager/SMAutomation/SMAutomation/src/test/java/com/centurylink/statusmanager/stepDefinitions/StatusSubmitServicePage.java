package com.centurylink.statusmanager.stepDefinitions;

import java.io.IOException;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.HomePageActions;
import com.centurylink.statusmanager.pageFactoryActions.StatusSubmitServicePageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class StatusSubmitServicePage {
	
	WebDriver driver ;
	
	StatusSubmitServicePageActions statusSubmitServicePageActions = new StatusSubmitServicePageActions(driver);
	HomePageActions homePageActions = new HomePageActions(driver);
	
	@And("^I read \"([^\"]*)\" JSON Data$")
	public void i_read_json_data(String testdata) throws JSONException, IOException, InterruptedException {
		
		statusSubmitServicePageActions.readJsonData(testdata);
	}
	
	
	@Then("^I fill the Status Submit Service form with \"([^\"]*)\" test data$")
	public void i_fill_status_submit_service_form(String testdata) throws JSONException, InterruptedException, IOException {
		
		statusSubmitServicePageActions.fillStatusSubmitServiceForm(testdata);
	}
	
	@And("^I click on Submit button to submit the request$")
	public void click_on_submit_button_to_submit_the_request() {
		
		statusSubmitServicePageActions.clickOnSubmitButton();
	}
	
	@Then("^I validate the response received for \"([^\"]*)\"$")
	public void i_validate_response_received(String testdata) throws InterruptedException, JSONException, IOException {
		
		statusSubmitServicePageActions.statussubmitserviceResponseValidation(testdata);
		statusSubmitServicePageActions.closeStatusSubmitServiceTab_img.click();
	}
	
	@Then("^I validate the Request Details Page with \"([^\"]*)\"$")
	public void i_validate_request_details_page_with_testdata(String testdata) throws JSONException, InterruptedException, IOException {
		
		statusSubmitServicePageActions.statussubmitserviceUIValidationScenario(testdata);
		homePageActions.closeSearchResultTab_img.click();
		homePageActions.closeRequestTab_img.click();
		 
	}

}
