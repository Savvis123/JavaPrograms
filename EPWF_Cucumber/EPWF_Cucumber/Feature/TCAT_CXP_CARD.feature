Feature: Submit Payment

@Regression_Epwf1
Scenario: Validate TCAT_CXP_CARD
	Given I have the request XML for "TCAT_CXP_CARD" 
	And I trigger it and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB
	Then I write the payment_id and payment status in excel
