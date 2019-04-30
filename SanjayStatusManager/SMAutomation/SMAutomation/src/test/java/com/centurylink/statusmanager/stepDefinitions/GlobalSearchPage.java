package com.centurylink.statusmanager.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.GlobalSearchPageActions;
import com.centurylink.statusmanager.pageFactoryActions.HomePageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class GlobalSearchPage {

	WebDriver driver ;
	
	GlobalSearchPageActions globalsearchactions = new GlobalSearchPageActions(driver);
	HomePageActions homePageActions = new HomePageActions(driver);

	@And("^I enter partial \"([^\"]*)\" \"([^\"]*)\" in the Global search$")
	public void i_enter_partial_data_in_global_search(String arg1, String arg2) throws InterruptedException {

		globalsearchactions.selectparamType(arg1, arg2);
	}
	
 
	@Then("^I validate the request page with the input data$")
	public void i_validate_the_request_page_with_the_input_data() throws InterruptedException {
		
		globalsearchactions.validateRequestPage();
		homePageActions.closeRequestTab_img.click();
	}

}
