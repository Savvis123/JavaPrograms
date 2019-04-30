package stepDefinition;

import cucumber.api.java.en.Then;
import genericUtilities.CommonMethods;
import genericUtilities.GlobalVariables;
import genericUtilities.IFrameNavigation;

public class Payment_Steps extends GlobalVariables {
	
	IFrameNavigation iFrameNavigation = new IFrameNavigation();
	
	@Then("^I make the payment based on payment type$")
	public void make_Payment_Details() throws Exception{
		
		/*if(sessionURL.contains("hcde")){
			iFrameNavigation.payFromHCDEIframe();
		}*/
		if(sessionURL.contains("voicetoken")){
			iFrameNavigation.verifyResponse();
			iFrameNavigation.payFromHCDEIframe();
		     }
		else {
			iFrameNavigation.payFromHCDEIframe();
		}
		driver.quit();
	}
	@Then("^I make the payment based on payment type and cancel the payment$")
	public void i_make_the_payment_based_on_payment_type_and_cancel_the_payment() throws Throwable {
		if(sessionURL.contains("hcde")){
			iFrameNavigation.payFromHCDEIframe();
		}
	}
	
	@Then("^I Choose the method of payment$")
	public void i_Choose_the_method_of_payment() throws Throwable {
		if(sessionURL.contains("hcde")){
		
			iFrameNavigation.Autopay_Enrollment_Update_Remove();

		}
	}

	@Then("^I Choose the account to be Removed/delete$")
	public void i_Choose_the_account_to_be_Removed_delete() throws Throwable {
		if(sessionURL.contains("hcde")){
			iFrameNavigation.Remove_Delete_Account();
		
		}
	}

	@Then("^I validate the deleted account$")
	public void i_validate_the_deleted_account() throws Throwable {
	
		if(sessionURL.contains("hcde")){
			iFrameNavigation.Validate_Remove_Delete_Account();
	
		}
	}
	
	@Then("^I Update and validate the account$")
	public void i_Update_and_validate_the_account() throws Throwable {
		if(sessionURL.contains("hcde")){
			iFrameNavigation.Update_Account();
		}
	}

}
