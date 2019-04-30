package com.centurylink.statusmanager.stepDefinitions;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.PublishServicePageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class PublishServicePage {

	private WebDriver driver;
	PublishServicePageActions publishservice = new PublishServicePageActions(driver);

	@And("^I fill publish service form$")
	public void i_fill_publish_service_form() throws IOException, InterruptedException {

		publishservice.fill_publish_service_form();
		
	}

	@Then("^I validate the response received$")
	public void i_validate_the_response_received() throws InterruptedException, JSONException, ParseException {
		
		publishservice.validateResponse();
	}
}
