package com.centurylink.statusmanager.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.QueryHstoryPageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class QueryHistoryPage {
	
	WebDriver driver ;
	
	QueryHstoryPageActions queryHstoryActions = new QueryHstoryPageActions(driver);
	
	@And("^I click on Query History link$")
	public void i_click_on_Query_History_link() throws InterruptedException {
		
		queryHstoryActions.clickonQueryHistoryLink();
	}
	
	@And("^I click on ViewMore link$")
	public void i_click_on_view_more_link() {
		
		queryHstoryActions.clickonViewMoreLink();
	}
	
	@Then("^I verify request details page is launched when clicked on view icon of a CorrelationID$")
	public void i_verify_request_details_page_is_launched_when_clicked_on_view_icon_of_a_CorrelationID() throws InterruptedException {
		
		queryHstoryActions.validate_Query_History_tab();
	}
}
