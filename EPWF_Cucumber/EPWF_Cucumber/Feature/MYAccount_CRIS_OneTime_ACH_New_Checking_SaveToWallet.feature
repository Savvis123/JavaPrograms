Feature: Submit Payment

@Regression_Epwf
Scenario: Validate MYAccount_CRIS_OneTime_ACH_New_Checking_SaveToWallet
	Given I have the request XML for "MYAccount_CRIS_OneTime_ACH_New_Checking_DoNotSaveToWallet" 
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
	