Feature: Submit Payment
@Regression_Epwf 
Scenario: Validate MYAccount_CRIS_Autopay_Enrollment_Update_Remove_ACH_SaveToWallet 
	Given I have the request XML for "MYAccount_CRIS_Autopay_Enrollment_Update_Remove_ACH_SaveToWallet" 
	And I trigger it and launch the session URL
	Then I Choose the method of payment
	Then I Choose the account to be Removed/delete
	Then I validate the deleted account
	

	