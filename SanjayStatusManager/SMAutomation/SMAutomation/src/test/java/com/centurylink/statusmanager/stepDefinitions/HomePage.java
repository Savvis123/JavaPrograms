package com.centurylink.statusmanager.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.GetRequestDetailsByCorrelationIDPageActions;
import com.centurylink.statusmanager.pageFactoryActions.HomePageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage {

	WebDriver driver ;
	
	HomePageActions homePageActions = new HomePageActions(driver);
	GetRequestDetailsByCorrelationIDPageActions getReqDetailsByCorrIDActions = new GetRequestDetailsByCorrelationIDPageActions(driver);
	
	public static String flagSearchparam ;
	public static String flagName ;
	public static String msName_search ;

/*	@And("^I am on the SM HomePage$")
	public void i_am_on_the_SM_HomePage() throws Throwable {
		
		homePageActions.waitforHomePageToLoad();
		homePageActions.getAppVersionfromHomePage();
	}*/
	
	@Then("^I should land on the HomePage$")
	public void i_should_land_on_homepage() {
		
		homePageActions.waitforHomePageToLoad();
		homePageActions.getAppVersionfromHomePage();
	}

	@And("^I click on \"([^\"]*)\" and select \"([^\"]*)\"$")
	public void i_click_on_and_select(String arg1, String arg2) throws Throwable {

		homePageActions.clickonTestRestLink();
		homePageActions.selectTestRestoptions(arg2);

	}
	
	@And("^I clicked on Search Link$")
	public void i_clicked_on_Search_link() {
		
		homePageActions.clickonSearchLink();
		
	}
	
	@And("^I select \"([^\"]*)\" as Search Type in Search slider$")
	public void i_select_as_search_type_in_search_slider(String searchtype) {
		
		homePageActions.selectSeachtype(searchtype);
	}
	
	
	
	@And("^I enter \"([^\"]*)\" in the MicroService Name dropdown$")
	public void i_enter_in_the_MicroService_Name_dropdown(String msName) throws InterruptedException {
		
		msName_search = msName ;
		homePageActions.searchByMicroserviceName(msName_search);
	}
	
	@And("^I search for request using \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_search_for_using_param_and_value(String sparam, String value){
		
		homePageActions.selectSearchByRequestoptions(sparam, value);
	}
	
	@And("^I click on Search button$")
	public void i_click_on_Search_button() {
		
		homePageActions.clickonSearchbutton();
	}
	 
	@And("^I click on view icon in Search Result page$")
	public void i_click_on_view_icon_in_search_result_page() throws InterruptedException {
		
		homePageActions.clickonViewEditIcon();
	}

	@And("^I close the search results page$")
	public void i_close_the_search_results_page() throws InterruptedException {
		
		homePageActions.closeSearchResultsTab();
	}
	
	@And("^I close the Request Details Page$")
	public void i_close_the_Request_Details_Page() throws InterruptedException {
		
		homePageActions.closeRequestDetailsTab();
	}

	@And("^I search for request using microservice parameters \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_search_for_request_using_different_microservice_param_and_value(String sparam, String value){
		
		homePageActions.selectSearchByMicroserviceoptions(sparam, value);
	}
	
	@And("^I search for request using Flag parameters \"([^\"]*)\" \"([^\"]*)\"$")
	public void i_search_for_request_using_different_flag_param_and_value(String sparam, String value){
		
		homePageActions.selectSearchByFlagoptions(sparam, value);
		flagName = value ;
		flagSearchparam = sparam ;
	}
	
	@And("^I click on the username link$")
	public void i_click_on_username_link() {
		
		homePageActions.clickonUsernameLink();
	}
	
	@When("^I click on Profile link$")
	public void i_click_on_profile_link() {
		
		homePageActions.clickonProfileLink();
	}

	
	
}
