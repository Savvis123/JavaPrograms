Feature: Submit Payment

@Regression_Epwf
Scenario: Validate TCAT_SBI_ENS_CON_CARD
	Given I have the request XML for "TCAT_SBI_CRIS_CON_CARD" 
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
	
