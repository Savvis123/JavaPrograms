package com.centurylink.statusmanager.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.centurylink.statusmanager.pageFactoryActions.ManageUsersPageActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ManageUsersPage {
	
	private WebDriver driver;
	ManageUsersPageActions manageUsersPageActions = new ManageUsersPageActions(driver) ;
	
	@Then("^I should land on manage Users page$")
	public void i_should_land_on_manage_user_page() {
		
		System.out.println("driver = "+ driver);
		manageUsersPageActions.verifyLandingPageforManageUsers();
	}
	
	@Then("^Manage Users Page should be launched in a new tab$")
	public void manage_Users_Page_should_be_launched_in_a_new_tab() throws InterruptedException {
		
		manageUsersPageActions.validateCUID();
	}
	
	@And("^I close the Manage Users tab$")
	public void i_close_manage_user_tab() {
		
		manageUsersPageActions.verifyandcloseManageUsertab();
	}

}
