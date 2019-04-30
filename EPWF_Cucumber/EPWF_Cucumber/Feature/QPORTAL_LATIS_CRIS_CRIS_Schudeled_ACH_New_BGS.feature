Feature: Submit Payment

@Regression_Epwf
Scenario: Validate QPORTAL_LATIS_CRIS_CRIS_Schudeled_ACH_New_BGS
	Given I have the request XML for "QPORTAL_LATIS_CRIS_CRIS_Schudeled_ACH_New_BGS" 
	And I trigger it for Qportal and launch the session URL
	Then I make the payment based on payment type
	Then I validate payment status from DB 
