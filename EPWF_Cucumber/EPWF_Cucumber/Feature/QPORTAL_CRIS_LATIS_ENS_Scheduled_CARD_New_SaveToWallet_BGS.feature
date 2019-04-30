Feature: Submit Payment

@Regression_Epwf
Scenario: Validate QPORTAL_CRIS_LATIS_ENS_Scheduled_CARD_New_SaveToWallet_BGS
	Given I have the request XML for "QPORTAL_CRIS_LATIS_ENS_Scheduled_CARD_New_SaveToWallet_BGS"
	And I trigger it for Qportal and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB 
	
